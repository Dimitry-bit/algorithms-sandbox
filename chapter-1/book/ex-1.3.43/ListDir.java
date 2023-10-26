/* 1.3.43 Listing files. A folder is a list of files and folders. Write a program that takes the
name of a folder as a command-line argument and prints out all of the files contained
in that folder, with the contents of each folder recursively listed (indented) under that
folder’s name. */

import java.io.File;

public class ListDir {
    private static final int defaultIndent = 2;
    private static final String cornerConnector = "│";
    private static final String cornerTeeConnector = "├";
    private static final String cornerEnd = "└";
    private static final String cornerDash = "─";

    private ListDir() {
    }

    public static String[] ListFiles(String path, boolean showHidden) {
        return ListFilesRecursive(path, 0, showHidden);
    }

    private static String[] ListFilesRecursive(String path, int depth, boolean showHidden) {
        if (path == null) {
            return new String[0];
        }

        QueueResizingArray<String> q = new QueueResizingArray<>();
        final String dashRepeat = new String(cornerDash).repeat(defaultIndent);
        final String spaceRepeat = new String(" ").repeat(defaultIndent);

        File fp = new File(path);
        if (depth == 0) {
            q.enqueue(fp.getPath());
        }
        if (!fp.canRead()) {
            return new String[0];
        }

        if (fp.isDirectory()) {
            File[] files = fp.listFiles();
            for (int i = 0; i < files.length; ++i) {
                File file = files[i];
                if (file.isHidden() && !showHidden) {
                    continue;
                }

                boolean isLastFile = (i == files.length - 1);
                final String corner = (isLastFile) ? cornerEnd : cornerTeeConnector;
                q.enqueue(String.format("%s%s%s", corner, dashRepeat, file.getName()));

                if (file.isDirectory()) {
                    final String childCorner = (isLastFile) ? " " : cornerConnector;
                    String[] childFiles = ListFilesRecursive(file.getPath(), depth + 1, showHidden);
                    for (String str : childFiles) {
                        q.enqueue(String.format("%s%s%s", childCorner, spaceRepeat, str));
                    }
                }
            }
        }

        String[] out = new String[q.size()];
        int index = 0;
        while (!q.isEmpty()) {
            out[index] = q.dequeue();
            index++;
        }

        return out;
    }

    public static void main(String[] args) {
        boolean showHidden = false;

        for (String argv : args) {
            if (argv.charAt(0) == '-') {
                for (int i = 1; i < argv.length(); i++) {
                    if (argv.charAt(i) == 'a') {
                        showHidden = true;
                    }
                }
                continue;
            }

            File fp = new File(argv);
            if (!fp.exists()) {
                System.out.printf("'%s' does not exit!\n", argv);
            } else if (fp.isFile()) {
                System.out.printf("'%s' is a file!\n", argv);
            } else if (fp.isDirectory()) {
                String[] fileNames = ListFiles(argv, showHidden);
                for (String name : fileNames) {
                    System.out.println(name);
                }
            }
        }
    }
}