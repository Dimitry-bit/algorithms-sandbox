/* 3.2.13 Give nonrecursive implementations of get() and put() for BST.
The implementation of put() is more complicated because of the need to save a point-
er to the parent node to link in the new node at the bottom. Also, you need a separate
pass to check whether the key is already in the table because of the need to update the
counts. Since there are many more searches than inserts in performance-critical imple-
mentations, using this code for get() is justified; the corresponding change for put()
might not be noticed. */

/* 3.2.14 Give nonrecursive implementations of min(), max(), floor(), ceiling(),
rank(), and select(). */

package prj.algs4.chapter3.section2;

import java.util.ArrayDeque;
import java.util.Queue;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int N;

        public Node(K key, V value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
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
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.val;
            } else if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            }
        }

        return null;
    }

    public void put(K key, V val) {
        Node x = root;
        Node p = null;

        int cmp = -1;
        while (x != null) {
            cmp = key.compareTo(x.key);
            if (cmp == 0) {
                break;
            }

            p = x;
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            }
        }

        if (root == null) {
            root = new Node(key, val, 1);
        } else if (x != null) {
            x.val = val;
        } else {
            x = new Node(key, val, 1);
            if (cmp < 0) {
                p.left = x;
            } else {
                p.right = x;
            }
            p.N = size(p.left) + size(p.right) + 1;
        }
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node x) {
        while (x.right != null) {
            x = x.right;
        }

        return x;
    }

    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }

        return x.key;
    }

    private Node floor(Node x, K key) {
        Node currentFloor = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp == 0) {
                return x;
            }

            if (cmp < 0) {
                x = x.left;
            } else {
                currentFloor = x;
                x = x.right;
            }
        }

        return currentFloor;
    }

    public K ceiling(K key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }

        return x.key;
    }

    private Node ceiling(Node x, K key) {
        Node currentCeil = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp == 0) {
                return x;
            }

            if (cmp > 0) {
                x = x.right;
            } else {
                currentCeil = x;
                x = x.left;
            }
        }

        return currentCeil;
    }

    public K select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        while (x != null) {
            int t = size(x.left);
            if (t > k) {
                x = x.left;
            } else if (t < k) {
                x = x.right;
                k = k - t - 1;
            } else {
                return x;
            }
        }

        return null;
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node x, K key) {
        int rank = 0;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
                rank += 1 + size(x.left);
            } else {
                rank += size(x.left);
                break;
            }
        }

        return rank;
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
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
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
}
