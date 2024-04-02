/* 3.2.6 Add to BST a method height() that computes the height of the tree. Develop two
implementations: a recursive method (which takes linear time and space proportional
to the height), and a method like size() that adds a field to each node in the tree (and
takes linear space and constant time per query). */

package prj.algs4.chapter3.section2;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTRecursive<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int N;
        private int height;

        public Node(K key, V value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
        }

        public Node(K key, V value, int N, int height) {
            this.key = key;
            this.val = value;
            this.N = N;
            this.height = height;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }

        return x.N;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            return new Node(key, val, 1, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }

        return max(x.right);
    }

    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }

        return x.key;
    }

    private Node floor(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            return x;
        }

        if (cmp < 0) {
            return floor(x.left, key);
        }

        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public K ceiling(K key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }

        return x.key;
    }

    private Node ceiling(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            return x;
        }

        if (cmp > 0) {
            return ceiling(x.right, key);
        }

        Node t = ceiling(x.left, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public K select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }

        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node x, K key) {
        if (x == null) {
            return 0;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }

            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        Queue<K> q = new ArrayDeque<>();
        keys(root, q, lo, hi);
        return q;
    }

    private void keys(Node x, Queue<K> q, K lo, K hi) {
        if (x == null) {
            return;
        }

        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0) {
            keys(x.left, q, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            q.add(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, q, lo, hi);
        }
    }

    public int heightRecursive() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node x) {
        if (x == null) {
            return 0;
        }

        return Math.max(heightRecursive(x.left), heightRecursive(x.right)) + 1;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return 0;
        }

        return x.height;
    }
}
