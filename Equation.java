
public class Equation {
	private char[] equation;
	
	public Equation() {    //constructeur
		equation = generationAleatoire();
	}
	
	public boolean equationJuste (char[] aTester) {
		boolean b = true;
		for (int i=0; i<equation.length; i++)
			if (aTester[i] != equation[i])
				b = false;
		return b;
	}

	private char[] generationAleatoire() {
		char[] e = { '1', '2', '+', '3', '5', '=', '4', '7' };
		return e;
	}
	
	public char[] getEquation() {
		return equation;
	}
}