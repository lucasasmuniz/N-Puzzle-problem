package puzzleN.funcoes;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MovJogo implements ActionListener{
	
	private int tamanho;
	private JButton[][] botao;
	private int[][] gabarito;
	Font fonteTexto = new Font("", Font.BOLD, 30);
	Font fonteBotao = new Font("", Font.BOLD, 50);
	Font botaoBranco = new Font("", Font.BOLD,0);
	Color fundo = new Color(253,184,39);
	
	public MovJogo(int tamanho, JButton[][] botao, int[][] gabarito) {
		this.tamanho = tamanho;
		this.botao = botao;
		this.gabarito = gabarito;
	}

	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<botao.length ;i++) {
			for(int j = 0; j<botao[i].length ;j++) {
				if(e.getSource()==botao[i][j]) {
					if(i+1<tamanho && botao[i+1][j].getText().equals("-1")) {
						botao[i+1][j].setBackground(new Color(84,37,131));
						botao[i+1][j].setFont(fonteBotao);
						botao[i+1][j].setForeground(Color.white);
						botao[i+1][j].setText(botao[i][j].getText()); 
						botao[i][j].setBackground(fundo);
						botao[i][j].setFont(botaoBranco);
						botao[i][j].setText("-1");
					}else if(i-1>=0 && botao[i-1][j].getText().equals("-1")) {
						botao[i-1][j].setBackground(new Color(84,37,131));
						botao[i-1][j].setFont(fonteBotao);
						botao[i-1][j].setForeground(Color.white);
						botao[i-1][j].setText(botao[i][j].getText());
						botao[i][j].setBackground(fundo);
						botao[i][j].setFont(botaoBranco);
						botao[i][j].setText("-1");
					}else if(j+1<tamanho && botao[i][j+1].getText().equals("-1")){
						botao[i][j+1].setBackground(new Color(84,37,131));
						botao[i][j+1].setFont(fonteBotao);
						botao[i][j+1].setForeground(Color.white);
						botao[i][j+1].setText(botao[i][j].getText());
						botao[i][j].setBackground(fundo);
						botao[i][j].setFont(botaoBranco);
						botao[i][j].setText("-1");
					}else if(j-1>=0 && botao[i][j-1].getText().equals("-1")) {
						botao[i][j-1].setBackground(new Color(84,37,131));
						botao[i][j-1].setFont(fonteBotao);
						botao[i][j-1].setForeground(Color.white);
						botao[i][j-1].setText(botao[i][j].getText());
						botao[i][j].setBackground(fundo);
						botao[i][j].setFont(botaoBranco);
						botao[i][j].setText("-1");
					}
				}
			}
		}
		for(int i=0; i<botao.length ;i++) {
			for(int j=0; j<botao[i].length ; j++) {
				if(String.valueOf(gabarito[i][j]).equals(botao[i][j].getText())) {
					if(botao[i][j].getText().equals("-1")) {
						continue;
					}else {
						botao[i][j].setBackground(new Color(153,50,204));
					}
				}
			}
		}
	}
	
}
