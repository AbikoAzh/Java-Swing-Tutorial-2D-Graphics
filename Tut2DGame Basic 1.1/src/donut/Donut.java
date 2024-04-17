package donut;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Donut extends JFrame {

	public Donut() {
		initUI();
	}
	
	private void initUI(){
		add(new Board());
		setSize(330,330);
		setTitle("Donut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// this need for JRE 1.8 AND here we use JRE 1.7
//		EventQueue.invokeLater(() ->{
			Donut d = new Donut();
			d.setVisible(true);
//		});
	}

}
