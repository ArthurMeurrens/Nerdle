import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class WindowNerdle extends JFrame implements ActionListener {
	private Equation finalEquation;
	private char[] equationPlayed = new char[8]; // on crée un tableau de char pour récupérer la proposition du joueur
	private int[] caseStates = {0, 0, 0, 0, 0, 0, 0, 0};

	private int round = 0; // compteur du nombre de tours joué par le joueur
	private int nbBoxFilled = 0; // compteur du nombre de caractères joués par le joueur
	private int totalRounds = 0;
	private int creditsCount = 0;

	ArrayList<Character> wrongChar = new ArrayList<>();
	ArrayList<Character> wrongPos = new ArrayList<>();
	ArrayList<Character> rightPos = new ArrayList<>();

	JPanel mainPanel = new JPanel();
	JPanel gameDisplay = new JPanel();
	JPanel menuDisplay = new JPanel();
	JPanel rulesDisplay = new JPanel();
	JPanel endGameDisplay = new JPanel();
	JPanel buttonsDisplay = new JPanel();
	JPanel boardDisplay = new JPanel();
	JPanel creditsDisplay = new JPanel();
	
	JLabel finalText = new JLabel();
	
	JLabel winGif = new JLabel(new ImageIcon("src/win.gif"));
	JLabel loseGif = new JLabel(new ImageIcon("src/lose.gif"));

	private BoardCase[][] board; // tableau 2D avec les cases de jeu

	JButton[] actionButtons = new JButton[3]; // tableau avec les boutons action
	JButton[] charButtons = new JButton[15];
	JButton[] difficultyButtons = new JButton[3];

	// crédits, 0 en 1er caratère, règles du jeu au début, priorités matsh, division non euclidienne
    // boardDisplay à removeAll() pour chaque play again
	// buttonsDisplay à set background pour chaque play again

	public WindowNerdle() {
		super("Nerdle");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);        
        
        gameInit();
		finalEquation = new Equation();
	}

	private void gameInit() {
		mainPanel.setLayout(null);
		this.add(mainPanel);
		
		rulesDisplay.setLayout(null);
		rulesDisplay.setBounds(500,250,530,250);
		rulesDisplay.setBackground(Color.pink);
		
		menuDisplay.setLayout(null);
		menuDisplay.setBounds(500,250,530,250);
	    menuDisplay.setBackground(Color.yellow);	
		
		gameDisplay.setLayout(null);
        gameDisplay.setBounds(220,0,1100,1000);
        gameDisplay.setBackground(Color.blue);
		
		boardDisplay.setLayout(null);
	    boardDisplay.setBounds(0,0,750,1000);
	    boardDisplay.setBackground(Color.orange);
	    
	    buttonsDisplay.setLayout(null);
	    buttonsDisplay.setBounds(750,0,350,1000);
	    buttonsDisplay.setBackground(Color.green);
	    
	    endGameDisplay.setLayout(null);
	    endGameDisplay.setBounds(750,0,350,1000);
	    endGameDisplay.setBackground(Color.red);


	    
		JLabel text1 = new JLabel("Choose your difficulty level", SwingConstants.CENTER);
		text1.setBounds(0, 0, 530, 150);
		text1.setFont(new Font("Arial", Font.BOLD, 20));
		menuDisplay.add(text1);
		
		finalText.setBounds(0, 150, 350, 100);
		finalText.setFont(new Font("Arial", Font.BOLD, 60));
		finalText.setHorizontalAlignment(SwingConstants.CENTER);
		endGameDisplay.add(finalText);
		
		winGif.setBounds(0, 250, 350, 200);
		loseGif.setBounds(0, 250, 350, 400);
		
		
		
		JTextArea rules = new JTextArea("Voici les règles du jeu : \n-Mange tes Morts\nBien Cordialement");
		rules.setEditable(false);
		rules.setBounds(0, 0, 530, 200);
		rules.setFont(new Font("Arial", Font.PLAIN, 18));
		rulesDisplay.add(rules);
		
		JButton exitRules = new JButton("OK");
		exitRules.setBackground(new Color(80, 220, 0));
		exitRules.setBounds(190, 200, 150, 50);
		exitRules.setFont(new Font("Arial", Font.BOLD, 28));
		rulesDisplay.add(exitRules);
		exitRules.addActionListener(this);
		

		JButton secretCredits = new JButton("Credits");
		buttonsDisplay.add(secretCredits);
		
		JButton exitCredits = new JButton("EXIT");
		creditsDisplay.add(exitCredits);
		

		difficultyButtons[0] = new JButton("Easy");
		difficultyButtons[0].setBackground(new Color(80, 220, 0));
		difficultyButtons[0].setBounds(20, 150, 150, 50);
		difficultyButtons[0].setFont(new Font("Arial", Font.BOLD, 20));
		menuDisplay.add(difficultyButtons[0]);
		difficultyButtons[0].addActionListener(this);

		difficultyButtons[1] = new JButton("Medium");
		difficultyButtons[1].setBackground(new Color(240, 145, 20));
		difficultyButtons[1].setBounds(190, 150, 150, 50);
		difficultyButtons[1].setFont(new Font("Arial", Font.BOLD, 20));
		menuDisplay.add(difficultyButtons[1]);
		difficultyButtons[1].addActionListener(this);

		difficultyButtons[2] = new JButton("Hard");
		difficultyButtons[2].setBackground(new Color(230, 0, 0));
		difficultyButtons[2].setBounds(360, 150, 150, 50);
		difficultyButtons[2].setFont(new Font("Arial", Font.BOLD, 20));
		menuDisplay.add(difficultyButtons[2]);
		difficultyButtons[2].addActionListener(this);
		

		for (int i = 0; i < 5; i++) {
			charButtons[i] = new JButton(String.valueOf(i));			
			charButtons[i].setBounds(70*i, 200, 50, 55);
			buttonsDisplay.add(charButtons[i]);
		}
		
		for (int i = 5; i < 10; i++) {
			charButtons[i] = new JButton(String.valueOf(i));
			charButtons[i].setBounds(70*(i-5), 270, 50, 55);
			buttonsDisplay.add(charButtons[i]);
		}
		
		charButtons[10] = new JButton("+"); // boutons char
		charButtons[11] = new JButton("-");
		charButtons[12] = new JButton("*");
		charButtons[13] = new JButton("/");
		charButtons[14] = new JButton("=");
		
		for (int i = 10; i < 15; i++) {
			charButtons[i].setBounds(70*(i-10), 370, 50, 55);
			buttonsDisplay.add(charButtons[i]);
		}

		for (int i = 0; i < charButtons.length; i++) {
			charButtons[i].setFont(new Font("Arial", Font.BOLD, 22));
			charButtons[i].setBackground(Color.lightGray);
			charButtons[i].addActionListener(this);
		}
		
		
		
		actionButtons[0] = new JButton("Enter"); // bouton ENTER en 0 et DELETE en 
		actionButtons[0].setBackground(Color.lightGray);
		actionButtons[0].setBounds(20, 470, 130, 55);
		actionButtons[0].setFont(new Font("Arial", Font.BOLD, 20));
		buttonsDisplay.add(actionButtons[0]);
		actionButtons[0].addActionListener(this);
		
		actionButtons[1] = new JButton("Delete");
		actionButtons[1].setBackground(Color.lightGray);
		actionButtons[1].setBounds(170, 470, 130, 55);
		actionButtons[1].setFont(new Font("Arial", Font.BOLD, 20));
		buttonsDisplay.add(actionButtons[1]);
		actionButtons[1].addActionListener(this);
		
		actionButtons[2] = new JButton("Play Again");
		actionButtons[2].setBackground(new Color(102, 0, 153));
		actionButtons[2].setForeground(new Color(255, 255, 255));
		actionButtons[2].setBounds(820, 700, 150, 50);
		gameDisplay.add(actionButtons[2]);
		actionButtons[2].addActionListener(this);

		
		
		gameDisplay.add(boardDisplay);
		gameDisplay.add(buttonsDisplay);
	    mainPanel.add(rulesDisplay);	
		
		
		this.revalidate();
		this.repaint();		
	}

	private void gridCreation(int difficulty) {
		board = new BoardCase[difficulty][8];
		for(int i = 0 ; i < board.length ; i ++ ) {
            for(int j = 0 ; j < board[0].length ; j++) {
            	board[i][j] = new BoardCase(90 + 70*j, 150 + 65*i); 
            	boardDisplay.add(board[i][j].getDisplay());

            }
        }
	}

	public void actionPerformed(ActionEvent e) {
		JButton selectedButton = (JButton) e.getSource();
		String source = selectedButton.getText();
		if (source == "Enter" || source == "Delete" || source == "Play Again") // si le joueur a selectionné un bouton action																			
			newAction(source);
		else if (source == "Easy" || source == "Medium" || source == "Hard") // si le joueur a selectionné un niveau de difficulté																				
			choseDifficulty(source);
		else if (source == "Credits")      //si le joueur a trouvé les crédits
			credits(source);
		else if (source == "OK") {            //quand le joueur a fini de bien lire les règles comme un grand
			mainPanel.remove(rulesDisplay);
			mainPanel.add(menuDisplay);
			this.revalidate();
			this.repaint();
		}	
		else // si le joueur a sélectionné un chiffre ou un opérateur
			newChar(source);
	}

	private void choseDifficulty(String source) {
		switch (source) {
		case "Easy":
			totalRounds = 8;
			break;
		case "Medium":
			totalRounds = 6;
			break;
		case "Hard":
			totalRounds = 4;
			break;
		}
		
		gridCreation(totalRounds);
		
		mainPanel.remove(menuDisplay);
		mainPanel.add(gameDisplay);
		
		this.revalidate();
		this.repaint();
	}

	private void updateDisplay(int[] states) {
		for (int i = 0; i < 8; i++) { // mettre à jour les cases de la lignes
			board[round][i].setState(states[i]);
		}

		for (int i = 0; i < charButtons.length; i++) {      // mettre a jour les boutons
			if (charButtons[i].getBackground() == Color.lightGray) {
				if(rightPos.contains(charButtons[i].getText().charAt(0))) {
					charButtons[i].setBackground(Color.green);
				}
				else if (wrongPos.contains(charButtons[i].getText().charAt(0))) {
					charButtons[i].setBackground(Color.red);
					charButtons[i].setForeground(Color.white);
				}
				else if (wrongChar.contains(charButtons[i].getText().charAt(0))) {
					charButtons[i].setBackground(Color.black);
					charButtons[i].setForeground(Color.white);
				} 				
			}
		}
		this.revalidate();
		this.repaint();
	}

	private void newAction(String source) {
		switch (source) {

		case "Enter":
			int nbTerms = 1;
			if (nbBoxFilled == 8) { // on vérifie si le joueur a joué toutes les cases
				ArrayList<Integer> operatorsPos = new ArrayList<>();
				ArrayList<Character> operatorsList = new ArrayList<>();
				
				for (int i = 0; i < 8; i++) {
					if (isAnOperator(equationPlayed[i])) {
						operatorsPos.add(i); // on récupère la position de tous les opérateurs : +, -, *, / et = dans // une ArrayList												
						operatorsList.add(equationPlayed[i]);
					}
				}
				

				for (int i = 1; i < 8; i++) {
					if (!isAnOperator(equationPlayed[i]) && isAnOperator(equationPlayed[i - 1])) // on compte le nombre de termes dans l'équation																								
						nbTerms += 1;
				}
				
				
				if (!operatorsList.isEmpty()) {
					if (nbTerms - operatorsPos.size() == 1 && operatorsList.get(operatorsList.size() - 1) == '='
							&& Collections.frequency(operatorsList, '=') == 1) { // on vérifie si l'équation est correcte au niveau de la syntaxe
						if (correctMath(equationPlayed, nbTerms, operatorsPos, operatorsList)) { // on vérifie si l'équation entrée est juste mathématiquement																																								
							gameRound();
						} else {
							JOptionPane.showMessageDialog(null, "Veuillez entrer une équation juste",  " ", JOptionPane.WARNING_MESSAGE);
							nbBoxFilled = 0;
							for (int i = 0; i < equationPlayed.length; i++) {
								equationPlayed[i] = ' ';
								board[round][i].setChar(' ');
							}
							this.revalidate();
							this.repaint();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une équation valide", " ", JOptionPane.ERROR_MESSAGE);
						nbBoxFilled = 0;
						for (int i = 0; i < equationPlayed.length; i++) {
							equationPlayed[i] = ' ';
							board[round][i].setChar(' ');
						}
						this.revalidate();
						this.repaint();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Ceci n'est pas une équation",  " ", JOptionPane.ERROR_MESSAGE);
					nbBoxFilled = 0;
					for (int i = 0; i < equationPlayed.length; i++) {
						equationPlayed[i] = ' ';
						board[round][i].setChar(' ');
					}
					this.revalidate();
					this.repaint();
				}				
			}
			break;

		case "Delete":
			if (nbBoxFilled > 0) { // on verifie si le joueur a au moins joué une case
				nbBoxFilled -= 1;
				equationPlayed[nbBoxFilled] = ' '; // le égale donne l'illusion d'une valeur nulle
				board[round][nbBoxFilled].setChar(' ');
				this.repaint();
			}
			break;

		case "Play Again":
			round = 0;
			totalRounds = 0;
			nbBoxFilled = 0; // réinitialiser les variables
			creditsCount = 0;

			for (int i = 0; i < charButtons.length; i++) { // réinitialiser le couleurs des boutons
				charButtons[i].setBackground(Color.lightGray);
				charButtons[i].setForeground(Color.black);
			}

			finalEquation = new Equation();
			
			boardDisplay.removeAll();
			mainPanel.remove(gameDisplay);
			mainPanel.add(menuDisplay);
			
			gameDisplay.remove(endGameDisplay);
			gameDisplay.add(buttonsDisplay);
			
			this.revalidate();
			this.repaint();
			break;
		}
	}

	private void endGame() {
		if (Arrays.equals(equationPlayed, finalEquation.getEquation())) {
			finalText.setText("Gagné !");   // gagné
			endGameDisplay.remove(loseGif);
			endGameDisplay.add(winGif);
			gameDisplay.remove(buttonsDisplay);
			gameDisplay.add(endGameDisplay);
		} 
		else if (round == totalRounds) {
			finalText.setText("Perdu !");
			endGameDisplay.remove(winGif);
			endGameDisplay.add(loseGif);
			gameDisplay.remove(buttonsDisplay);
			gameDisplay.add(endGameDisplay);
		}
		
		this.revalidate();
		this.repaint();
	}

	private boolean correctMath(char[] equation, int nbTerms, ArrayList<Integer> operatorsPos,
			ArrayList<Character> operatorsList) {
		boolean b = false;
		if (nbTerms == 3) {
			int x = 0, y = 0, z = 0;
			
			for (int i = operatorsPos.get(0) - 1; i > -1; i--) {   // on récupère les valeurs des termes dans des int
				x = (int) (x + Math.pow(10, operatorsPos.get(0) - 1 - i) * Character.getNumericValue(equation[i]));
			}
			for (int i = operatorsPos.get(1) - 1; i > operatorsPos.get(0); i--) {
				y = (int) (y + Math.pow(10, operatorsPos.get(1) - 1 - i) * Character.getNumericValue(equation[i]));
			}
			for (int i = equation.length - 1; i > operatorsPos.get(1); i--) { 
				z = (int) (z + Math.pow(10, 7 - i) * Character.getNumericValue(equation[i]));
			}

			switch (operatorsList.get(0)) {
			case '+':
				if (x + y == z)
					b = true;
				break;
			case '-':
				if (x - y == z)
					b = true;
				break;
			case '*':
				if (x * y == z)
					b = true;
				break;
			case '/':
				if ((double) x / (double) y == (double) z)
					b = true;
				break;
			}
		} else if (nbTerms == 4) {
			int s = 0, t = 0, u = 0, v = 0;         //equation : s+t+u=v avec s+t=w
			double w = 0.0;
			
			for (int i = operatorsPos.get(0) - 1; i > -1; i--) {
				s = (int) (s + Math.pow(10, operatorsPos.get(0) - 1 - i) * Character.getNumericValue(equation[i]));
			}
			for (int i = operatorsPos.get(1) - 1; i > operatorsPos.get(0); i--) {
				t = (int) (t + Math.pow(10, operatorsPos.get(1) - 1 - i) * Character.getNumericValue(equation[i]));
			}
			for (int i = operatorsPos.get(2) - 1; i > operatorsPos.get(1); i--) {
				u = (int) (u + Math.pow(10, operatorsPos.get(2) - 1 - i) * Character.getNumericValue(equation[i]));
			}
			for (int i = equation.length - 1; i > operatorsPos.get(2); i--) {
				v = (int) (v + Math.pow(10, 7 - i) * Character.getNumericValue(equation[i]));
			}

			switch (operatorsList.get(0)) {
			case '+':
				w = s + t;
				break;
			case '-':
				w = s - t;
				break;
			case '*':
				w = s * t;
				break;
			case '/':
				w = s / t;
				break;
			}

			switch (operatorsList.get(1)) {
			case '+':
				if (w + u == v)
					b = true;
				break;
			case '-':
				if (w - u == v)
					b = true;
				break;
			case '*':
				if (w * u == v)
					b = true;
				break;
			case '/':
				if (w / (double) u == (double) v)
					b = true;
				break;
			}
		}
		return b;
	}

	private void newChar(String source) {
		if(nbBoxFilled != 8) {
			if(source.charAt(0) != '0' || (nbBoxFilled != 0 && !isAnOperator(equationPlayed[nbBoxFilled-1]))) {
				equationPlayed[nbBoxFilled] = source.charAt(0);
				board[round][nbBoxFilled].setChar(source.charAt(0));
				nbBoxFilled +=1;
				this.revalidate();
				this.repaint();		
			}
		}
	}

	private boolean isAnOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '=') {
			return true;
		} else {
			return false;
		}
	}

	private void gameRound() {
		ArrayList<Character> undiscovered = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			if (equationPlayed[i] == finalEquation.getEquation()[i]) {
				caseStates[i] = 3;
				rightPos.add(equationPlayed[i]);
			}
			else {
				undiscovered.add(finalEquation.getEquation()[i]);
			}
		}
		for (int i = 0; i < 8; i++) {
			if (caseStates[i] != 3 && undiscovered.contains(Character.valueOf(equationPlayed[i]))) {
				caseStates[i] = 2;
				undiscovered.remove(Character.valueOf(equationPlayed[i]));
				if (!wrongPos.contains(equationPlayed[i]))
					wrongPos.add(equationPlayed[i]);
			}
			
			else if (caseStates[i] != 3 && !undiscovered.contains(Character.valueOf(equationPlayed[i]))){
				caseStates[i] = 1;
				if (!wrongChar.contains(equationPlayed[i]))
					wrongChar.add(equationPlayed[i]);
			}
		}
		updateDisplay(caseStates);		
		round += 1;
		nbBoxFilled = 0;
		endGame();
		
		for (int i = 0; i < 8; i++) {
			equationPlayed[i] = ' ';
			caseStates[i] = 0;
		}
	}
	
	private void credits(String source) {
		if (totalRounds == 4 && round == 0) {
			creditsCount+=1;
			
			if(creditsCount == 7) {
				creditsCount=0; 

				JLabel textCredits1 = new JLabel("Bravo, vous avez trouvé ce petit Easter Egg (on espère que vous n'avez pas du fouiller dans le code pour ça)", SwingConstants.CENTER);
				creditsDisplay.add(textCredits1);
				
				JLabel textCredits2 = new JLabel("Jeu réalisé par :", SwingConstants.CENTER);
				creditsDisplay.add(textCredits2);
				
				JLabel textCredits3 = new JLabel("EL AOUFIR Souheïl    MAFROUZ Ahmed    MEURRENS Arthur", SwingConstants.CENTER);
				creditsDisplay.add(textCredits3);
								
				mainPanel.remove(gameDisplay);
				mainPanel.add(creditsDisplay);
				
				this.revalidate();
				this.repaint();
			}
			
		}
	}
}