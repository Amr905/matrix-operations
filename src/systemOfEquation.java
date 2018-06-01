/*
 * Amr Morsy 150908
 */
import java.util.ArrayList;

public class systemOfEquation {
	int varNums;
	ArrayList<MyEquation> system;

	public systemOfEquation() {
		varNums = 0;
		system = new ArrayList<>();

	}

	void insertNewEquation(MyEquation x) {
		system.add(x);
		varNums = Math.max(x.n, varNums);

	}

	void swapEquations(int i, int j) {
		MyEquation tempi = system.get(i - 1);
		MyEquation tempj = system.get(j - 1);
		system.set(i - 1, tempj);
		system.set(j - 1, tempi);
	}

	double[] solveSystem() {
		int col = system.size();
		MyMatrix lmat = new MyMatrix(varNums, col);// make matrix of lhs;
		MyMatrix rMat = new MyMatrix(varNums, 1);// matrix of rhs
		int i = 0;
		double ans[] = new double[varNums];
		for (MyEquation equation : system) {
			for (int j = 0; j < equation.LHS.length; j++) {
				lmat.matrix[i][j] = equation.LHS[j];
			}
			rMat.matrix[i][0] = equation.RHS;
			i++;
		}

		double D = MyMatrix.determinant(lmat);
		if (D == 0) {
			System.out.println("determenent equal zero it cant be solved using crummer rule ");
		}
		MyMatrix temp = new MyMatrix(lmat);

		for (i = 0; i < col; i++) {
			temp.swapCol(i, rMat);// swap col
			// temp.display();
			ans[i] = MyMatrix.determinant(temp)/D;
			temp = new MyMatrix(lmat);// make new matrix with main numbers before swapping col
		}
		return ans;

	}

}
