# 2.1.9

2.1.9 Show, in the style of the example trace with Algorithm 2.3, how shellsort sorts
the array E A S Y S H E L L S O R T Q U E S T I O N.

h     0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
13    *E* A S Y S H E L L S  O  R  T  **Q**  U  E  S  T  I  O  N
      E *A* S Y S H E L L S  O  R  T  Q  **U**  E  S  T  I  O  N
      E A **E** Y S H E L L S  O  R  T  Q  U  *S*  S  T  I  O  N
      E A E **S** S H E L L S  O  R  T  Q  U  S  *Y*  T  I  O  N
      E A E S *S* H E L L S  O  R  T  Q  U  S  Y  **T**  I  O  N
      E A E S S *H* E L L S  O  R  T  Q  U  S  Y  T  **I**  O  N
      E A E S S H *E* L L S  O  R  T  Q  U  S  Y  T  I  **O**  N
      E A E S S H E *L* L S  O  R  T  Q  U  S  Y  T  I  O  **N**
4     *E* A E S **S** H E L L S  O  R  T  Q  U  S  Y  T  I  O  N
      E *A* E S S **H** E L L S  O  R  T  Q  U  S  Y  T  I  O  N
      E A *E* S S H **E** L L S  O  R  T  Q  U  S  Y  T  I  O  N
      E A E **L** S H E *S* L S  O  R  T  Q  U  S  Y  T  I  O  N
      E A E L **L** H E S *S* S  O  R  T  Q  U  S  Y  T  I  O  N
      E A E L L *H* E S S **S**  O  R  T  Q  U  S  Y  T  I  O  N
      E A E L L H *E* S S S  **O**  R  T  Q  U  S  Y  T  I  O  N
      E A E L L H E **R** S S  O  *S*  T  Q  U  S  Y  T  I  O  N
      E A E L L H E R *S* S  O  S  **T**  Q  U  S  Y  T  I  O  N
      E A E L L H E R S **Q**  O  S  T  *S*  U  S  Y  T  I  O  N
      E A E L L H E R S Q  *O*  S  T  S  **U**  S  Y  T  I  O  N
      E A E L L H E R S Q  O  *S*  T  S  U  **S**  Y  T  I  O  N
      E A E L L H E R S Q  O  S  *T*  S  U  S  **Y**  T  I  O  N
      E A E L L H E R S Q  O  S  T  *S*  U  S  Y  **T**  I  O  N
      E A E L L H E R S Q  **I**  S  T  S  *O*  S  Y  T  *U*  O  N
      E A E L L H E **O** S Q  I  *R*  T  S  O  *S*  Y  T  U  *S*  N
      E A E L L H E O **N** Q  I  R  *S*  S  O  S  *T*  T  U  S  *Y*
1     **A** *E* E L L H E O N Q  I  R  S  S  O  S  T  T  U  S  Y
      A *E* **E** L L H E O N Q  I  R  S  S  O  S  T  T  U  S  Y
      A E *E* **L** L H E O N Q  I  R  S  S  O  S  T  T  U  S  Y
      A E E *L* **L** H E O N Q  I  R  S  S  O  S  T  T  U  S  Y
      A E E **H** *L* *L* E O N Q  I  R  S  S  O  S  T  T  U  S  Y
      A E E **E** *H* *L* *L* O N Q  I  R  S  S  O  S  T  T  U  S  Y
      A E E E H L *L* **O** N Q  I  R  S  S  O  S  T  T  U  S  Y
      A E E E H L L **N** *O* Q  I  R  S  S  O  S  T  T  U  S  Y
      A E E E H L L N *O* **Q**  I  R  S  S  O  S  T  T  U  S  Y
      A E E E H **I** *L* *L* *N* *O*  *Q*  R  S  S  O  S  T  T  U  S  Y
      A E E E H I L L N O  *Q*  **R**  S  S  O  S  T  T  U  S  Y
      A E E E H I L L N O  Q  *R*  **S**  S  O  S  T  T  U  S  Y
      A E E E H I L L N O  Q  R  *S*  **S**  O  S  T  T  U  S  Y
      A E E E H I L L N O  **O**  *Q*  *R*  *S*  *S*  S  T  T  U  S  Y
      A E E E H I L L N O  O  Q  R  S  *S*  **S**  T  T  U  S  Y
      A E E E H I L L N O  O  Q  R  S  S  *S*  **T**  T  U  S  Y
      A E E E H I L L N O  O  Q  R  S  S  S  *T*  **T**  U  S  Y
      A E E E H I L L N O  O  Q  R  S  S  S  T  *T*  **U**  S  Y
      A E E E H I L L N O  O  Q  R  S  S  S  **S**  *T*  *T*  *U*  Y
      A E E E H I L L N O  O  Q  R  S  S  S  S  T  T  *U*  **Y**
