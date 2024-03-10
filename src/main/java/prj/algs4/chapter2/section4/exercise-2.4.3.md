# 2.4.3

Provide priority-queue implementations that support insert and remove the
maximum, one for each of the following underlying data structures: unordered array,
ordered array, unordered linked list, and linked list. Give a table of the worst-case
bounds for each operation for each of your four implementations.

| Operation | Unordered array | Ordered array | Unordered list | Ordered list |
| --------- | --------------- | ------------- | -------------- | ------------ |
| insert    | O(1)            | O(N)          | O(1)           | O(N)         |
| max       | O(N)            | O(1)          | O(N)           | O(N)         |
