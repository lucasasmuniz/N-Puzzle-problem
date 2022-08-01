package puzzleN;
import java.util.*;

public class Dados { //Essa classe depois herdará de usuarios
	private int tamanho;
	private int[] quad;
	private int tela;
	private int numBranco;
	private int numQuad;
	private boolean gameOver;
	public void setTamanho(int tamanho){ //Onde será setado o valor do tamanho
		if (tamanho >= 2 && tamanho <= 4){
			this.tamanho = tamanho;
			this.numQuad = (this.tamanho * this.tamanho) - 1;
			this.quad = new int[this.tamanho*this.tamanho];
		}
	}
	public void jogo(){ //Onde o jogo irá rodar
		this.gameOver = false;
	}
	public void embaralhar() { //onde fica
		Random random = new Random();
		this.numBranco = 0;
		this.quad[numQuad] = this.numBranco; 
	    for (int i=0; i < numQuad ;i++) {
	    	quad[i] = random.nextInt(numQuad) + 1; //O método esta repetindo os numeros aleatorios por enquanto. 
	    }
	    System.out.print(Arrays.toString(quad));
	}
}
