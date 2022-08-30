package puzzleN.interfaceGraf;
import javax.swing.*;
import puzzleN.funcoes.*;
import java.awt.event.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener{
	Color fundo = new Color(253,184,39);
	Font fonteT = new Font("", Font.BOLD,60);
	JButton iniciar = new JButton("Início");
	JButton dificuldade = new JButton("Dificuldade");
	JButton ranking = new JButton("Ranking");
	JButton sair = new JButton("Sair");
	JPanel maior = new JPanel();
	private Usuario player;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==iniciar) {
			TipoJogo tipoJogo = new TipoJogo(maior, this, player);
			setContentPane(tipoJogo);
			tipoJogo.revalidate();
		}else if(e.getSource()==sair) {
			System.exit(0);
		}
	}
	
	public Menu(Usuario player){
		this.player = player;
		setTitle("Menu");
		setSize(500,430);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		painelMaior();
	}
	
	public void painelMaior() {	
		maior.setLayout(new BoxLayout(maior, BoxLayout.PAGE_AXIS));
		maior.setBackground(fundo);
		maior.setPreferredSize(new Dimension(500,430));
		
		JLabel tituloJogo = new JLabel("PUZZLE-N"); 
		tituloJogo.setFont(fonteT);
		tituloJogo.setForeground(new Color(54,54,54));
		tituloJogo.setAlignmentX(CENTER_ALIGNMENT);
		
		iniciar.setAlignmentX(CENTER_ALIGNMENT);
		iniciar.setMaximumSize(new Dimension(110,40));
		iniciar.addActionListener(this);
		
		dificuldade.setAlignmentX(CENTER_ALIGNMENT);
		dificuldade.setMaximumSize(new Dimension(100,40));
		
		ranking.setAlignmentX(CENTER_ALIGNMENT);
		ranking.setMaximumSize(new Dimension(100,40));
		
		sair.setAlignmentX(CENTER_ALIGNMENT);
		sair.setMaximumSize(new Dimension(100,40));	
		sair.addActionListener(this);
		
		maior.add(tituloJogo);
		maior.add(Box.createRigidArea(new Dimension(0,50)));
		maior.add(iniciar);
		maior.add(Box.createRigidArea(new Dimension(0,10)));
		maior.add(dificuldade);
		maior.add(Box.createRigidArea(new Dimension(0,10)));
		maior.add(ranking);
		maior.add(Box.createRigidArea(new Dimension(0,10)));
		maior.add(sair);
		
		add(maior, BorderLayout.CENTER);
	}
}
