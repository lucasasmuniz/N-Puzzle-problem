package puzzleN.interfaceGraf;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import puzzleN.*;
import puzzleN.funcoes.*;

public class GUIJogo extends JFrame{
	
	private int tamanho = 3;//3 ou 4(quando tiver dificuldade será setado lá)
	private int[] numerosRandom;//POSICAO DOS BOTOES
	private int[][] resposta;
	private int numBranco;//POSICAO DO BOTAO EM BRANCO
	private int numQuad;//QUANTIDADE DE BOTOES - 1
	private boolean gameOver;//PARA QUANDO O JOGO ACABAR
	private int movimentos;
	private JButton[][] botoes;
	
	Color fundo = new Color(253,184,39);
	JButton reset = new JButton("Recomeçar");
	JButton ajuda = new JButton("Ajuda");
	Font fonteTexto = new Font("", Font.BOLD, 30);
	Font fonteBotao = new Font("", Font.BOLD, 50);
	Font botaoBranco = new Font("", Font.BOLD,0);
	
	public GUIJogo(String jogador){
		
		this.numQuad = (tamanho*tamanho)-1;
		this.numerosRandom= new int[tamanho*tamanho]; 
		this.resposta = new int[tamanho][tamanho];
		
		Dados dadosPlayer = new Dados();
		numerosRandom = dadosPlayer.random(this.tamanho);
		this.resposta = dadosPlayer.gabarito(this.tamanho);
		
		setTitle("Puzzle-N");
		setSize(700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		parteCima(jogador, 0);
		parteMeio();
		parteBaixo();
		}
	
	public void parteCima(String nome, int mov){
		JPanel norte = new JPanel();
		norte.setBackground(fundo);
		norte.setBorder(new EmptyBorder(10,10,0,0));
		norte.setLayout(new BoxLayout(norte, BoxLayout.PAGE_AXIS));
		norte.setPreferredSize(new Dimension(700,100));
		JLabel usuario = new JLabel(nome);
		usuario.setFont(fonteTexto);
		JLabel tentativas = new JLabel("TENTATIVAS: " +mov);
		tentativas.setFont(fonteTexto);
		norte.add(usuario);
		norte.add(tentativas);
		add(norte,BorderLayout.NORTH);
	}
	
	public void parteBaixo() {
		JPanel sul = new JPanel(new FlowLayout());
		sul.setPreferredSize(new Dimension(700,100));
		sul.setBackground(fundo);
		sul.add(reset);
		//BotaoAjuda botaoAjuda = new BotaoAjuda(this, resposta, tamanho, ajuda);
		//ajuda.addActionListener(botaoAjuda);
		sul.add(ajuda);
		add(sul,BorderLayout.SOUTH);
	}

	public void parteMeio() {
		JPanel meio = new JPanel(new GridLayout(this.tamanho,this.tamanho));
		meio.setBackground(fundo);
		meio.setBorder(new EmptyBorder(10,10,0,10));
		this.botoes = new JButton[tamanho][tamanho];
		int k = 0;
		MovJogo controles = new MovJogo(this.tamanho,this.botoes,this.resposta);
		for(int i = 0; i<botoes.length; i++) {
			for(int j = 0; j<botoes[i].length ;j++) {
				if(String.valueOf(numerosRandom[k]).equals("-1")) {
					botoes[i][j] = new JButton();
					botoes[i][j].setBackground(fundo);
					botoes[i][j].addActionListener(controles);
					botoes[i][j].setFont(botaoBranco);
					botoes[i][j].setText(String.valueOf(numerosRandom[k]));
					meio.add(botoes[i][j]);
				} else {
					botoes[i][j] = new JButton();
					botoes[i][j].addActionListener(controles);
					botoes[i][j].setBackground(new Color(84,37,131));
					botoes[i][j].setFont(fonteBotao);
					botoes[i][j].setForeground(Color.white);
					botoes[i][j].setText(String.valueOf(numerosRandom[k]));
					if(String.valueOf(resposta[i][j]).equals(botoes[i][j].getText())) {
						botoes[i][j].setBackground(new Color(153,50,204));
					}
				}
				k++;
				meio.add(botoes[i][j]);
			}
		}
		add(meio);
	}
}