/* 3.2.10 Write a test client TestBST.java for use in testing the implementations of
min(), max(), floor(), ceiling(), select(), rank(), delete(), deleteMin(),
deleteMax(), and keys() that are given in the text. Start with the standard indexing
client given on page 370. Add code to take additional command-line arguments, as appropriate. */

package prj.algs4.chapter3.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTRecursiveTest {

    @Test
    public void BSTRecusive_heightRecursiveWorstCase() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        int actual = bst.heightRecursive();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_heightRecursiveBalanced() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(10, 10);
        bst.put(8, 8);
        bst.put(7, 7);
        bst.put(9, 9);
        bst.put(12, 12);
        bst.put(11, 11);
        bst.put(13, 13);

        int expected = 3;
        int actual = bst.heightRecursive();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_heightWorstCase() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        int actual = bst.height();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_heightBalanced() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(10, 10);
        bst.put(8, 8);
        bst.put(7, 7);
        bst.put(9, 9);
        bst.put(12, 12);
        bst.put(11, 11);
        bst.put(13, 13);

        int actual = bst.height();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_min() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        int actual = bst.min();
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_max() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        int actual = bst.max();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_floor() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        Assertions.assertAll("Floor group",
                () -> assertEquals(2, bst.floor(2)),
                () -> assertEquals(null, bst.floor(0)));
    }

    @Test
    public void BSTRecusive_ceil() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        Assertions.assertAll("Ceil group",
                () -> assertEquals(2, bst.ceiling(2)),
                () -> assertEquals(null, bst.ceiling(4)));
    }

    @Test
    public void BSTRecusive_select_shouldReturnKeyOfAGivenRank() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        int actual = bst.select(1);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BSTRecusive_rank_shouldReturnRankOfAGivenKey() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        int actual = bst.rank(2);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    public void BSTRecusive_delete_shouldDeleteAGivenKey() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        bst.delete(2);

        Assertions.assertAll("Delete group",
                () -> assertEquals(null, bst.get(2)),
                () -> assertEquals(2, bst.size()));
    }

    public void BSTRecusive_keys_shouldReturnAnInOrderIterable() {
        BSTRecursive<Integer, Integer> bst = new BSTRecursive<>();

        bst.put(0, 1);
        bst.put(1, 2);
        bst.put(2, 3);

        int i = 0;
        for (var key : bst.keys()) {
            Assertions.assertEquals(i, key);
        }
    }
}
