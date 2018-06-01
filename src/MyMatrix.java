/*
 * Amr Morsy 150908
 */
public class MyMatrix {

	public int n, m;
	public double matrix[][];

	public MyMatrix(MyMatrix mat) {// copy constructor
		this.matrix = new double[mat.n][mat.m];
		n = mat.n;
		m = mat.m;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				matrix[i][j] = mat.matrix[i][j];
	}

	public MyMatrix(int row, int col) {// constructor
		this.matrix = new double[row][col];
		n = row;
		m = col;
	}

	public MyMatrix(int row, int col, double arr[][]) {// constructor
		this.matrix = arr;
		n = row;
		m = col;

	}

	public MyMatrix(double arr[][]) {// constructor
		n = arr.length;
		m = arr[0].length;
		this.matrix = new double[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				matrix[i][j] = arr[i][j];

	}

	public void setValues(double arr[][]) {
		n = arr.length;
		m = arr[0].length;
		this.matrix = new double[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				matrix[i][j] = arr[i][j];
	}

	MyMatrix transpose() {
		MyMatrix temp = new MyMatrix(m, n);
		if (n > 0) {
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++) {
					temp.matrix[i][j] = matrix[j][i];
				}

		}
		return temp;
	}

	MyMatrix scalarMultiply(int k) {
		MyMatrix temp;// = new MyMatrix();
		temp = this;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				temp.matrix[i][j] *= k;
		return temp;

	}

	MyMatrix sum(MyMatrix mat) {

		if (mat.m == m && mat.n == n) {// if valid
			MyMatrix temp = new MyMatrix(n, m);
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					temp.matrix[i][j] = mat.matrix[i][j] + matrix[i][j];
			return temp;
		} else {
			System.out.println("can't summation two different size of matrix");
			return this;
		}

	}

	MyMatrix multiply(MyMatrix mat) {
		if (this.validForMultiplication(mat)) {
			MyMatrix temp = new MyMatrix(n, mat.m);// row of first and col of sec matrix
			for (int i = 0; i < n; i++) // row of first
				for (int j = 0; j < mat.m; j++) // col of second
					for (int k = 0; k < m; k++) { // col of first
						temp.matrix[i][j] += matrix[i][k] * mat.matrix[k][j];
					}
			return temp;
		} else {
			System.out.println("can't multiply this two matrix");
			return this;
		}

	}

	boolean isSymmetric() {
		if (n != m)// try this function after addition of this line
			return false;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (matrix[i][j] != matrix[j][i])
					return false;
		return true;
	}

	boolean equals(MyMatrix mat) {
		if (mat.m == m && mat.n == n) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (matrix[i][j] != mat.matrix[i][j])
						return false;
		} else
			return false;
		return true;
	}

	static MyMatrix zeroMatrix(int x, int y) {
		MyMatrix temp = new MyMatrix(x, y);
		return temp;
	}

	static MyMatrix identityMatrix(int x) {
		MyMatrix temp = new MyMatrix(x, x);
		for (int i = 0; i < x; i++)
			for (int j = 0; j < x; j++)
				if (i == j)
					temp.matrix[i][j] = 1.0;

		return temp;
	}

	MyMatrix inverse() {

		if (n != m) {
			System.out.println("non square matrix doesnt have inverse ");
			return this;
		}

		if (determinant(this) == 0) {
			System.out.println("this inversable matrix as determinant equal zero ");
			return this;
		}

		double temp;
		MyMatrix Aug = this;// augmented matrix
		MyMatrix Iden = MyMatrix.identityMatrix(n);// identity matrix

		for (int k = 0; k < n; k++) {
			temp = Aug.matrix[k][k]; // store the value so it will not change

			for (int j = 0; j < n; j++) // during the operation A[i][j]/=A[k][k]
			// when i=j=k
			{
				Aug.matrix[k][j] /= temp; // dvide to make it 1
				Iden.matrix[k][j] /= temp;
			}
			for (int i = 0; i < n; i++) {
				temp = Aug.matrix[i][k];
				for (int j = 0; j < n; j++) {
					if (i == k)
						break;
					Aug.matrix[i][j] -= Aug.matrix[k][j] * temp;
					Iden.matrix[i][j] -= Iden.matrix[k][j] * temp;
				}
			}
		}

		return Iden;
	}

	public static double determinant(MyMatrix mat) {
		MyMatrix temporary;
		double result = 0;

		if (mat.matrix.length == 1) {
			result = mat.matrix[0][0];
			return (result);
		}

		if (mat.matrix.length == 2) {
			result = ((mat.matrix[0][0] * mat.matrix[1][1]) - (mat.matrix[0][1] * mat.matrix[1][0]));
			return (result);
		}

		for (int i = 0; i < mat.matrix[0].length; i++) {// loop over col
			temporary = new MyMatrix(mat.matrix.length - 1, mat.matrix[0].length - 1);// row and col -1

			for (int j = 1; j < mat.matrix.length; j++) {// loop over row
				for (int k = 0; k < mat.matrix[0].length; k++) {// col
					if (k < i) {
						temporary.matrix[j - 1][k] = mat.matrix[j][k];
					} else if (k > i) {
						temporary.matrix[j - 1][k - 1] = mat.matrix[j][k];
					}
				}
			}

			result += mat.matrix[0][i] * Math.pow(-1, i) * determinant(temporary);
		}
		return (result);
	}

	boolean validForMultiplication(MyMatrix mat) {
		if (m == mat.n)
			return true;
		else
			return false;
	}

	void swapCol(int col, MyMatrix mat) {// for crummer rule only
		for (int i = 0; i < n; i++)
			matrix[i][col] = mat.matrix[i][0];

	}

	void display() {
		String disp, space = "                              ";
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				disp = String.valueOf(matrix[i][j]);
				if (5 - disp.length() > 0)
					disp += space.substring(0, 5 - disp.length());
				// System.out.print(matrix[i][j]);
				System.out.print(disp);
				if (j == m - 1)
					System.out.print("\n");
				else
					System.out.print("   ");
			}
	}
}
