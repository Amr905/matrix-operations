# matrix-operations
implementation of some of the matrix operations and solving linear equations using crummer rule 
## instruction 
call the methods in class main.java 
## matrix operation methods in class MyMatrix
- transpose
- scalarMultiply
- sum (sumation of 2 matrices and return the sumed matrix)
- multiply (multiplication of 2 matrices and return the multiplied matrix)
- validForMultiplication (check if 2 matrices valid for multiplication)
- isSymmetric  
- equals (check if the two matrices are equals)
- identityMatrix (static method return identity matrix) 
- zeroMatrix (static method return zero matrix) 
- inverse (return the iverse of matrix)
- determinant (static method return determinant of matrix)
- display (display the matrix  )
## solving linear equation 
make instances of class MyEquation as required for the number of equation 
the equation can be either in array format or in a string format as 
```
ax+by+cz=t such as
0x+2Y+Z=8
```
then add the equations to systemOfEquation object with method  insertNewEquation(MyEquation x)
then call method solve in systemOfEquation to solve the system and return array with the solution
