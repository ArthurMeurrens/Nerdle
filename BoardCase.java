import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardCase {
	private JPanel p = new JPanel();
	private JLabel l = new JLabel();
	private int state;     //0 etat init, 1 faux char, 2 mauvaise position, 3 trouvé
	
	public BoardCase(int x, int y) {
		state=0;

		l.setText(" ");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setVerticalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Arial", Font.BOLD, 22));
		l.setForeground(new Color(255, 255, 255));
		l.setBounds(0, 0, 60, 55);
		
		p.setLayout(null);
		p.setBackground(Color.gray);
		p.setBounds(x, y, 60, 55);
		p.add(l);
	}
	
	public JPanel getDisplay() {
		return p;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int i) {
		state=i;
		switch (state) {
		case 1:
			p.setBackground(Color.black);
			p.setForeground(Color.white);
			break;
		case 2:
			p.setBackground(new Color(255,113,104));
			break;
		case 3:
			p.setBackground(new Color(123,217,131));
			break;
		}
	}
	
	public void setChar (char c) {
		l.setText(Character.toString(c));
	}
}
