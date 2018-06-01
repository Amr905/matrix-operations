/*
 * Amr Morsy 150908
 */
public class MyEquation {
	int n;
	double LHS[];
	double RHS;

	public MyEquation(int num) {
		n = num;
		LHS = new double[n];
	}

	public MyEquation(String s) {

		n = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))// if its
																										// charcter
				n++;
		}
		LHS = new double[n];
		int counter = 0, start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))// if its
																										// charcter
			{
				// System.out.println(s.substring(start, i).length());
				// System.out.println(s.charAt(0));

				String num = s.substring(start, i);
				if (s.substring(start, i).length() == 0 || (num.length() == 1 && num.charAt(0) == '+')) {
					LHS[counter] = 1;
				} else if ((num.length() == 1) && num.charAt(0) == '-') {
					LHS[counter] = -1;
				} else {
					LHS[counter] = Integer.parseInt(s.substring(start, i));
				}

				// System.out.println(LHS[counter]);
				start = i + 1;
				counter++;
			}
		}

		// System.out.println(Double.parseDouble(s.substring((s.indexOf('=')+1))));
		RHS = Double.parseDouble(s.substring((s.indexOf('=') + 1)));
		// System.out.println(RHS);

	}

	public MyEquation(int n, double[] lHS, double rHS) {
		this.n = n;
		LHS = lHS;
		RHS = rHS;
	}

	public MyEquation(double[] lHS, double rHS) {
		n = lHS.length;
		LHS = lHS;
		RHS = rHS;
	}

}
