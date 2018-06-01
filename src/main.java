/*
 * Amr Morsy 150908
 */
public class main {
	public static void main(String[] args) {
		double arr[][] = { { 7, 5, 1 }, { 5, 8, 3 }, { 1, 3, 4 } };// matrix used
		double arr2[][] = { { 1, 0, 0 }, { 0, 1,-2  },{0,0,1} };
		double arr7[][] = { { 1, 0, 0 }, { 0, -1,0  },{0,0,1} };
		double arr8[][] = { { 1, 0, 0 }, { 0, 1,2  },{0,0,1} };
		double arr3[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		double arr4[][] = { { 1, 2, 3 }, { 0, 1, 4 }, { 5, 6, 0 } };
		double arr5[][] = { { 1, 5, 3 }, { 2, 4, 7 }, { 1, 6, 2 } };
		double arr6[][] = { { 5, -2, 2, 7 }, { 1, 0, 0, 3 }, { -3, 1, 5, 0 }, { 3, -1, -9, 4 } };

		MyMatrix z=new MyMatrix(arr2);
		z=z.multiply(new MyMatrix(arr7));
		z=z.multiply(new MyMatrix(arr8));
		z.display();
		MyMatrix x = new MyMatrix(arr);
		MyMatrix y = new MyMatrix(arr);
		System.out.println("the matrix:");
		x.display();
		System.out.println("determinant of the matrix is:" + MyMatrix.determinant(x));
		System.out.println("inverse of the matrix:");// how accurate is this program !
		x = x.inverse();
		x.display();
		x = new MyMatrix(arr);// Initialize it again as its has inverse value

		System.out.println();// some matrix operation
		// x.display();
		// MyMatrix z=x.scalarMultiply(5);
		// MyMatrix z=x.transpose();
		// MyMatrix z=x.sum(x);
		// MyMatrix z=x.multiply(y);
		//
		// System.out.println(y.equals(x));
		// MyMatrix z = MyMatrix.identityMatrix(4);
		// z.display();

		systemOfEquation ss = new systemOfEquation();
		// the equation must be in that form ax+by=z where a,b,c numbers >=0
		ss.insertNewEquation(new MyEquation("x+0Y+2Z=9"));
		ss.insertNewEquation(new MyEquation("0x+2Y+Z=8"));
		ss.insertNewEquation(new MyEquation("4x-3y+0Z=-2"));

		////////////////////// Equation in array will also work
		// double e1[] = { 1, 0, 2 };
		// double e2[] = { 0, 2, 1 };
		// double e3[] = { 4, -3, 0 };
		// MyEquation e = new MyEquation(e1, 9);
		// ss.insertNewEquation((e));
		// ss.insertNewEquation(new MyEquation(e2,8));
		// ss.insertNewEquation(new MyEquation(e3,-2));
		// ss.swapEquations(1, 3);
		String var = "XYZ";
		System.out.println("the solution of the equations\nx+0Y+2Z=9\n0x+2Y+Z=8\n4x-3y+0Z=-2\nis: ");
		double ff[] = ss.solveSystem();
		for (int i = 0; i < ff.length; i++)
			System.out.println(var.charAt(i) + " = " + ff[i]);
	}
}
