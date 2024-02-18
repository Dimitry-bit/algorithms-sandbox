# 2.3.1

Show, in the style of the trace given with partition(), how that method
patitions the array E A S Y Q U E S T I O N.

                        i  j    0 1 2 3 4 5 6 7 8 9 10 11
initial values          0  12   **E** A S Y Q U E S T I O  N
scan left, scan right   2  6    E A *S* Y Q U *E* S T I O  N
exchange                2  6    E A *E* Y Q U *S* S T I O  N
scan left, scan right   3  2    E A *E* *Y* Q U S S T I O  N
final exchange             2    *E* A *E* Y Q U S S T I O  N
result                          *E* A *E* Y Q U S S T I O  N
