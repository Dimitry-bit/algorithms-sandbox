# 2.4.13

Describe a way to avoid the j < N test in sink().

```cpp
private void sink(int k)
{

    // Changing 2 * k <= N to 2 * k < N, would guarantee than (2 * k + 1) is always valid, so j < N would be unnecessary.
    while (2 * k < N)
    {
        int j = 2 * k;
        if (less(j, j + 1)) j++;
        if (!less(k, j)) break;
        exch(k, j);
        k = j;
    }


    // If we reached the n-1 level of the heap and it only has 1 child (the left child), we need one more verification.
    // If the current element is smaller than its child, exchange them.
    if ((2 * k == N) && less(k, 2 * k)) {
        exch(k, 2 * k);
    }
}
```
