# 2.4.15

Design a linear-time certification algorithm to check whether an array pq[] is
a min-oriented heap.

```cpp
public static boolean certification(Comparable[] pq) {
{
    int N = pq.length;

    while (int k = 1; k * 2 <= N; k++) {
        int j = k * 2;

        // Check left child
        if (!less(pq[k], pq[j])) { return false; }
        // Check right child
        if ((j < N) && !less(pq[k], pq[j + 1])) { return false; }
    }

    return true;
}
```
