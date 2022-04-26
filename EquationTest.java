import java.util.LinkedList;

public class EquationTest {
	LinkedList <char[]> equationsvalides;
	private char[] equation ;
	
	public EquationTest() {    //constructeur
		
		char [] Operateurs = {'+','-','*','/','0','1','2','3','4','5','6','7','8','9'};
		char [] Operateurs2 ={'+','-','*','/','0'};
		equationsvalides = new LinkedList <char[]>();
		equation = new char[8];
		LinkedList <char[]> Operateurscorrects = new LinkedList <char[]>();
		int resultatCalcul = 0;
		double resultatCalculDivision = 0.0;
		

		equation = new char[8];
		for (int a = 4 ; a < 7 ; a ++){
			for (int i = 0 ; i < equation.length ; i ++){
				equation[i] = '0';
			}
			equation[a] = '=';
			
			
				
			if ( a == 4 ) {
				for (int c = 0 ; c < Operateurs2.length ; c ++){
						equation[1] = Operateurs[c]; 
						for (int d = 0 ; d < Operateurs2.length ; d ++){
							equation[2] = Operateurs[d];
							if (OperateurBienPlace(equation)){
								Operateurscorrects.add(equation);
								if ( estOperateur(equation[1]) ){
									for ( int y = 5 ; y < Operateurs.length ; y ++){
										equation[0] = Operateurs[y];
										for ( int x = 5 ; x < Operateurs.length ; x ++){
											equation[2] = Operateurs[x]; 
											for ( int w = 4 ; w < Operateurs.length ; w ++){
												equation[3] = Operateurs[w];
												char [] passerelle = new char[8];
												if (equation[1] == '+'){
													resultatCalcul = (Character.getNumericValue(equation[0])+ CreerNombre2(equation[2],equation[3]));
													if ( NombreDeChiffre(resultatCalcul) == 3 && resultatValide(resultatCalcul)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultatCalcul),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
														for (int g = 0 ; g < passerelle.length ; g++){
															passerelle[g] = equation[g];
														}
														equationsvalides.add(passerelle);
															
														
												
															
													}
															
																
												}if ( equation[1] == '*'){
													resultatCalcul = (Character.getNumericValue(equation[0])* CreerNombre2(equation[2],equation[3]));
													if ( NombreDeChiffre(resultatCalcul) == 3 && resultatValide(resultatCalcul)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultatCalcul),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
														for (int g = 0 ; g < passerelle.length ; g++){
															passerelle[g] = equation[g];
														}
														equationsvalides.add(passerelle);
													}
																
												}
											}
										}
									}	
								}if ( estOperateur(equation[2]) ){
									for ( int y = 5 ; y < Operateurs.length ; y ++){
										equation[0] = Operateurs[y];
										for ( int x = 4 ; x < Operateurs.length ; x ++){
											equation[1] = Operateurs[x]; 
											for ( int w = 5 ; w < Operateurs.length ; w ++){
												equation[3] = Operateurs[w];
												char [] passerelle = new char[8];
												if ( equation[2] == '+'){
													resultatCalcul = (CreerNombre2(equation[0],equation[1]) + Character.getNumericValue(equation[3]));
													if ( NombreDeChiffre(resultatCalcul) == 3 && resultatValide(resultatCalcul)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultatCalcul),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
														for (int g = 0 ; g < passerelle.length ; g++){
															passerelle[g] = equation[g];
														}
														equationsvalides.add(passerelle);		
													}			
												}if ( equation[2] == '*'){
													resultatCalcul = (CreerNombre2(equation[0],equation[1]) * Character.getNumericValue(equation[3]));
													if ( NombreDeChiffre(resultatCalcul) == 3 && resultatValide(resultatCalcul)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultatCalcul),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
														for (int g = 0 ; g < passerelle.length ; g++){
															passerelle[g] = equation[g];
														}
														equationsvalides.add(passerelle);
													}					
												}
											}
										}
									}	
								}
							}
								
						}
				}
			}else if ( a == 5 ){
				for (int c = 0 ; c < Operateurs2.length ; c ++){
						equation[1] = Operateurs[c]; 
						for (int d = 0 ; d < Operateurs2.length ; d ++){
							equation[2] = Operateurs[d];
							for (int e = 0 ; e < Operateurs2.length ; e ++){
								equation[3] = Operateurs[e];
								if (OperateurBienPlace(equation)){
									Operateurscorrects.add(equation);
									
									if ( estOperateur(equation[2] )){
										for ( int y = 5 ; y < Operateurs.length ; y ++){
											equation[0] = Operateurs[y];
											for ( int x = 4 ; x < Operateurs.length ; x ++){
												equation[1] = Operateurs[x]; 
												for ( int w = 5 ; w < Operateurs.length ; w ++){
													equation[3] = Operateurs[w];
													for ( int z = 4 ; z < Operateurs.length ; z ++){
														equation[4] = Operateurs[z];
														char [] passerelle = new char[8];
														if ( equation[2] == '+'){
															resultatCalcul = (CreerNombre2(equation[0],equation[1]) + CreerNombre2(equation[3],equation[4]));
															if ( NombreDeChiffre(resultatCalcul) == 2 && resultatValide(resultatCalcul)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
																for (int g = 0 ; g < passerelle.length ; g++){
																	passerelle[g] = equation[g];
																}
																equationsvalides.add(passerelle);
															
															}		
														}if ( equation[2] == '-'){
															resultatCalcul = (CreerNombre2(equation[0],equation[1])- CreerNombre2(equation[3],equation[4]));
															if ( NombreDeChiffre(resultatCalcul) == 2 && resultatValide(resultatCalcul)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
																for (int g = 0 ; g < passerelle.length ; g++){
																	passerelle[g] = equation[g];
																}
																equationsvalides.add(passerelle);
																
															}			
														}
													}
												}
											}
										}
									}
									if ( estOperateur(equation[3]) && !estOperateur(equation[1])){
										for ( int y = 5 ; y < Operateurs.length ; y ++){
											equation[0] = Operateurs[y];
											for ( int x = 4 ; x < Operateurs.length ; x ++){
												equation[1] = Operateurs[x]; 
												for ( int w = 4 ; w < Operateurs.length ; w ++){
													equation[2] = Operateurs[w];
													for ( int z = 5 ; z < Operateurs.length ; z ++){
														equation[4] = Operateurs[z];
														char [] passerelle = new char[8];
														if ( equation[3] == '-'){
															resultatCalcul = (CreerNombre3(equation[0],equation[1],equation[2]) - Character.getNumericValue (equation[4]));
															if ( NombreDeChiffre(resultatCalcul) == 2 && resultatValide(resultatCalcul)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
																for (int g = 0 ; g < passerelle.length ; g++){
																	passerelle[g] = equation[g];
																}
																equationsvalides.add(passerelle);
															}		
														}if ( equation[3] == '/' && equation[4] != '0' && (CreerNombre3(equation[0],equation[1],equation[2]) % Character.getNumericValue(equation[4])) == 0.0 ){
															resultatCalculDivision = (CreerNombre3(equation[0],equation[1],equation[2]) / Character.getNumericValue(equation[4]));
															resultatCalcul = (int)(resultatCalculDivision);
															if ( NombreDeChiffre(resultatCalcul) == 2 && resultatValide(resultatCalculDivision)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultatCalcul),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultatCalcul),10);
																for (int g = 0 ; g < passerelle.length ; g++){
																	passerelle[g] = equation[g];
																}
																equationsvalides.add(passerelle);
																
															}			
														}
													}
												}
											}
										}
									}	
								}
							}
						}
					}
				}
			}
		
		System.out.println(equationsvalides.size());
		int numeroEquation = (int)(Math.random()*equationsvalides.size());	
		equation = equationsvalides.get(numeroEquation);
		
		}
	
	
	
	
	
	public boolean OperateurBienPlace(char [] equation){
		char [] e = new char[8];
		for (int i = 0 ; i < e.length ; i++){
			e[i] = equation[i];
		}
		boolean r = true; 
		boolean OperatorPresent = false;
		for (int i = 0; i < e.length-1 ; i ++){
			if ((e[i] == '+' || e[i] == '-' || e[i] == '*' || e[i] == '/' || e[i] == '=' ) && (e[i+1] == '+' || e[i+1] == '-' || e[i+1] == '*' || e[i+1] == '/' || e[i+1] == '=')){
				r = false;
			}
			if (equation[i] == '+' || equation[i] == '-'|| equation[i] == '*' || equation[i] == '/'){
				OperatorPresent = true;
			}
		}
	 	if (!OperatorPresent){
			r = false;
		}
		return r;
	}

	public int genererNombre(int TailleDuNombre){
		int r = 0 ;
		if ( TailleDuNombre == 1){
			r = (int)(Math.random()*9);
		}else if ( TailleDuNombre == 2){
			r =  (int)(Math.random()*99);
		}else if ( TailleDuNombre == 3){
			r = (int)(Math.random()*999);
		}
		return r;
	}	
	
	public int NombreDeChiffre( double Nombre){
		int r = 0;
		if ( (int)(Nombre/100.0) >= 1 ){
			r = 3;
		}else if ( (int)(Nombre/10.0) >= 1 ){
			r = 2;
		}else{ 
			r = 1;
		}
		return r;
	}
	
	public boolean resultatValide (double nombre){
		boolean r = false ; 
		if (nombre >= 0) {
			r = true;
		}
		return r;
	}
	
	public boolean resultatValideDivision(double nombre){
		boolean r = true;
		if ( nombre%1.0 != 0.0){
			r = false;
		}
		return r;
	}
		
	public int CreerNombre2(char nombre1, char nombre2){
		int n1 = Character.getNumericValue(nombre1);
		int n2 = Character.getNumericValue(nombre2);
		return(10*n1 + n2);
	}
	
	public int CreerNombre3(char nombre1, char nombre2, char nombre3){
		int n1 = Character.getNumericValue(nombre1);
		int n2 = Character.getNumericValue(nombre2);
		int n3 = Character.getNumericValue(nombre3);
		return(100*n1 + 10*n2 + n3);
	}
		
	public boolean estOperateur(char c){
		boolean r = false;
		if ( c == '+' || c == '-' || c == '*' || c == '/'){
			r = true; 
		}
		return r;
	}
		
		
	public int ExtraireChiffre ( int emplacement, int Nombre ){
		int r = 0;
		if ( emplacement == 1){
			r = (int)(Nombre % 10);
		}else if ( emplacement == 2){
			r = (int)((int)(Nombre/10) % 10);
		}else if ( emplacement == 3){
			r = (int)((int)(Nombre/100) % 10);
		}
		return r;
	}
	public char[] getEquation() {
		return equation;
	}
	
				
		
		
		
		
}
