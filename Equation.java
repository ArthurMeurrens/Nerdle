import java.util.LinkedList;

public class Equation {
	LinkedList <char[]> equations;
	private char[] equation ;
	
	public Equation() {    //constructeur
		
		char [] Characters = {'+','-','*','/','0','1','2','3','4','5','6','7','8','9'};
		char [] Operators ={'+','-','*','/','0'};
		equations = new LinkedList <char[]>();
		equation = new char[8];
		//LinkedList <char[]> Operateurscorrects = new LinkedList <char[]>();
		int resultCalculation = 0;
		double resultCalculationDivision = 0.0;
		

		equation = new char[8];
		for (int PlaceEgal = 4 ; PlaceEgal < 7 ; PlaceEgal ++){
			for (int i = 0 ; i < equation.length ; i ++){
				equation[i] = '0';
			}
			equation[PlaceEgal] = '=';
			
			
				
			if ( PlaceEgal == 4 ) {
				for (int c = 0 ; c < Operators.length ; c ++){
						equation[1] = Characters[c]; 
						for (int d = 0 ; d < Operators.length ; d ++){
							equation[2] = Characters[d];
							if (WellPlacedOperators(equation)){
								//Operateurscorrects.add(equation);
								if ( IsOperator(equation[1]) ){
									for ( int y = 5 ; y < Characters.length ; y ++){
										equation[0] = Characters[y];
										for ( int x = 5 ; x < Characters.length ; x ++){
											equation[2] = Characters[x]; 
											for ( int w = 4 ; w < Characters.length ; w ++){
												equation[3] = Characters[w];
												char [] IntermediateEquation = new char[8];
												if (equation[1] == '+'){
													resultCalculation = (Character.getNumericValue(equation[0])+ GenerateNumber2(equation[2],equation[3]));
													if ( DigitNumber(resultCalculation) == 3 && ValidResult(resultCalculation)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultCalculation),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
														for (int g = 0 ; g < IntermediateEquation.length ; g++){
															IntermediateEquation[g] = equation[g];
														}
														equations.add(IntermediateEquation);
															
														
												
															
													}
															
																
												}if ( equation[1] == '*'){
													resultCalculation = (Character.getNumericValue(equation[0])* GenerateNumber2(equation[2],equation[3]));
													if ( DigitNumber(resultCalculation) == 3 && ValidResult(resultCalculation)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultCalculation),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
														for (int g = 0 ; g < IntermediateEquation.length ; g++){
															IntermediateEquation[g] = equation[g];
														}
														equations.add(IntermediateEquation);
													}
																
												}
											}
										}
									}	
								}if ( IsOperator(equation[2]) ){
									for ( int y = 5 ; y < Characters.length ; y ++){
										equation[0] = Characters[y];
										for ( int x = 4 ; x < Characters.length ; x ++){
											equation[1] = Characters[x]; 
											for ( int w = 5 ; w < Characters.length ; w ++){
												equation[3] = Characters[w];
												char [] IntermediateEquation = new char[8];
												if ( equation[2] == '+'){
													resultCalculation = (GenerateNumber2(equation[0],equation[1]) + Character.getNumericValue(equation[3]));
													if ( DigitNumber(resultCalculation) == 3 && ValidResult(resultCalculation)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultCalculation),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
														for (int g = 0 ; g < IntermediateEquation.length ; g++){
															IntermediateEquation[g] = equation[g];
														}
														equations.add(IntermediateEquation);		
													}			
												}if ( equation[2] == '*'){
													resultCalculation = (GenerateNumber2(equation[0],equation[1]) * Character.getNumericValue(equation[3]));
													if ( DigitNumber(resultCalculation) == 3 && ValidResult(resultCalculation)){
														equation[5] = Character.forDigit(ExtraireChiffre(3, resultCalculation),10);
														equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
														equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
														for (int g = 0 ; g < IntermediateEquation.length ; g++){
															IntermediateEquation[g] = equation[g];
														}
														equations.add(IntermediateEquation);
													}					
												}
											}
										}
									}	
								}
							}
								
						}
				}
			}else if ( PlaceEgal == 5 ){
				for (int c = 0 ; c < Operators.length ; c ++){
					equation[1] = Characters[c]; 
					for (int d = 0 ; d < Operators.length ; d ++){
						equation[2] = Characters[d];
						for (int e = 0 ; e < Operators.length ; e ++){
							equation[3] = Characters[e];
							if (WellPlacedOperators(equation)){
								//Operateurscorrects.add(equation);
									
									if ( IsOperator(equation[2])){
										for ( int y = 5 ; y < Characters.length ; y ++){
											equation[0] = Characters[y];
											for ( int x = 4 ; x < Characters.length ; x ++){
												equation[1] = Characters[x]; 
												for ( int w = 5 ; w < Characters.length ; w ++){
													equation[3] = Characters[w];
													for ( int z = 4 ; z < Characters.length ; z ++){
														equation[4] = Characters[z];
														char [] IntermediateEquation = new char[8];
														if ( equation[2] == '+'){
															resultCalculation = (GenerateNumber2(equation[0],equation[1]) + GenerateNumber2(equation[3],equation[4]));
															if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
																for (int g = 0 ; g < IntermediateEquation.length ; g++){
																	IntermediateEquation[g] = equation[g];
																}
																equations.add(IntermediateEquation);
															
															}		
														}if ( equation[2] == '-'){
															resultCalculation = (GenerateNumber2(equation[0],equation[1])- GenerateNumber2(equation[3],equation[4]));
															if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
																for (int g = 0 ; g < IntermediateEquation.length ; g++){
																	IntermediateEquation[g] = equation[g];
																}
																equations.add(IntermediateEquation);
																
															}			
														}
													}
												}
											}
										}
									}
									if ( IsOperator(equation[3]) && !IsOperator(equation[1])){
										for ( int y = 5 ; y < Characters.length ; y ++){
											equation[0] = Characters[y];
											for ( int x = 4 ; x < Characters.length ; x ++){
												equation[1] = Characters[x]; 
												for ( int w = 4 ; w < Characters.length ; w ++){
													equation[2] = Characters[w];
													for ( int z = 5 ; z < Characters.length ; z ++){
														equation[4] = Characters[z];
														char [] IntermediateEquation = new char[8];
														if ( equation[3] == '-'){
															resultCalculation = (GenerateNumber3(equation[0],equation[1],equation[2]) - Character.getNumericValue (equation[4]));
															if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
																for (int g = 0 ; g < IntermediateEquation.length ; g++){
																	IntermediateEquation[g] = equation[g];
																}
																equations.add(IntermediateEquation);
															}		
														}if ( equation[3] == '/' && equation[4] != '0' && (GenerateNumber3(equation[0],equation[1],equation[2]) % Character.getNumericValue(equation[4])) == 0.0 ){
															resultCalculationDivision = (GenerateNumber3(equation[0],equation[1],equation[2]) / Character.getNumericValue(equation[4]));
															resultCalculation = (int)(resultCalculationDivision);
															if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculationDivision)){
																equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
																equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
																for (int g = 0 ; g < IntermediateEquation.length ; g++){
																	IntermediateEquation[g] = equation[g];
																}
																equations.add(IntermediateEquation);
															}			
														}
													}
												}
											}
										}
									}
									if ( IsOperator(equation[3]) && IsOperator(equation[1])){
										for ( int y = 5 ; y < Characters.length ; y ++){
											equation[0] = Characters[y];
											for ( int x = 5 ; x < Characters.length ; x ++){
												equation[2] = Characters[x]; 
												for ( int w = 5 ; w < Characters.length ; w ++){
													equation[4] = Characters[w];
													char [] IntermediateEquation = new char[8];	
													if ( equation[1] == '+' && equation[3] == '+'){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);	
														}
													}
													if ( equation[1] == '*' && equation[3] == '*' && equation[0] != '1' && equation[2] != '1' && equation[4] != '1'){
														resultCalculation = (Character.getNumericValue(equation[0]) * Character.getNumericValue(equation[2]) * Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);	
														}
													}
													if ( equation[1] == '+' && equation[3] == '-'){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) - Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);	
														}
													}
													if ( equation[1] == '-' && equation[3] == '+'){
														resultCalculation = (Character.getNumericValue(equation[0]) - Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);		
														}
													}
													if ( equation[1] == '+' && equation[3] == '*' && equation[2] != '1' && equation[4] != '1'){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) * Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);	
														}
													}
													if ( equation[1] == '*' && equation[3] == '+' && equation[0] != '1' && equation[2] != '1'){
														resultCalculation = (Character.getNumericValue(equation[0]) * Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);
														}
													}
													if ( equation[1] == '+' && equation[3] == '/' && equation[4] != '1' && equation[2] != equation[4] && (Character.getNumericValue(equation[2]) % Character.getNumericValue(equation[4])) == 0.0 ){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);
														}
													}
													if ( equation[1] == '/' && equation[2] != '1' && equation[3] == '+' && equation[0] != equation[2] && (Character.getNumericValue(equation[0]) % Character.getNumericValue(equation[2])) == 0.0 ){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);
														}
													}
													if ( equation[1] == '*' && equation[3] == '-' && equation[0] != 1 && equation[2] != 1){
														resultCalculation = (Character.getNumericValue(equation[0]) * Character.getNumericValue(equation[2]) - Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);		
														}
													}
													if ( equation[1] == '*' && equation[3] == '/' && equation[0] != '1' && equation[2] != '1' && equation[4] != '1' && equation[2] != equation[4] && (Character.getNumericValue(equation[2]) % Character.getNumericValue(equation[4])) == 0.0 ){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);		
														}
													}
													if ( equation[1] == '/' && equation[3] == '*' && equation[0] != '1' && equation[2] != '1' && equation[4] != '1' && equation[0] != equation[2] && (Character.getNumericValue(equation[2]) % Character.getNumericValue(equation[4])) == 0.0 ){
														resultCalculation = (Character.getNumericValue(equation[0]) + Character.getNumericValue(equation[2]) + Character.getNumericValue(equation[4]) );
														if ( DigitNumber(resultCalculation) == 2 && ValidResult(resultCalculation)){
															equation[6] = Character.forDigit(ExtraireChiffre(2, resultCalculation),10);
															equation[7] = Character.forDigit(ExtraireChiffre(1, resultCalculation),10);
															for (int g = 0 ; g < IntermediateEquation.length ; g++){
																IntermediateEquation[g] = equation[g];
															}
															equations.add(IntermediateEquation);
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
			}else if ( PlaceEgal == 6 ){
			
			}
		}
		
		System.out.println(equations.size());
		int RandomEquation = (int)(Math.random()*equations.size());	
		equation = equations.get(RandomEquation);
		
	}
	
	
	
	
	
	public boolean WellPlacedOperators(char [] equation){
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
		
	public int DigitNumber( double Number){
		int r = 0;
		if ( (int)(Number/100.0) >= 1 ){
			r = 3;
		}else if ( (int)(Number/10.0) >= 1 ){
			r = 2;
		}else{ 
			r = 1;
		}
		return r;
	}
	
	public boolean ValidResult (double Number){
		boolean r = false ; 
		if (Number >= 0) {
			r = true;
		}
		return r;
	}
		
	public int GenerateNumber2(char Number1, char Number2){
		int n1 = Character.getNumericValue(Number1);
		int n2 = Character.getNumericValue(Number2);
		return(10*n1 + n2);
	}
	
	public int GenerateNumber3(char Number1, char Number2, char Number3){
		int n1 = Character.getNumericValue(Number1);
		int n2 = Character.getNumericValue(Number2);
		int n3 = Character.getNumericValue(Number3);
		return(100*n1 + 10*n2 + n3);
	}
		
	public boolean IsOperator(char c){
		boolean r = false;
		if ( c == '+' || c == '-' || c == '*' || c == '/'){
			r = true; 
		}
		return r;
	}
		
		
	public int ExtraireChiffre ( int place, int Number ){
		int r = 0;
		if ( place == 1){
			r = (int)(Number % 10);
		}else if ( place == 2){
			r = (int)((int)(Number/10) % 10);
		}else if ( place == 3){
			r = (int)((int)(Number/100) % 10);
		}
		return r;
	}
	public char[] getEquation() {
		return equation;
	}
	
				
		
		
		
		
}
