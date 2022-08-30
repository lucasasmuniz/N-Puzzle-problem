package puzzleN.funcoes;
import java.util.Arrays;
import java.util.Random;

public class Dados { //Essa classe depois herdará de usuarios
	private int tamanho;
	private int[] quad;
	private int numQuad;
	private int[] resposta;
	
	public Dados(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int[][] gabarito(int tamanho) {
		int[][] array = new int[tamanho][tamanho];
		for(int i = 0; i<array.length; i++) {
			for(int j = 0; j<array[i].length; j++) {
				array[i][j] = j +(i*tamanho) + 1;
			}
		}
		array[tamanho-1][tamanho-1]= -1;
		return array;
	}
	
	public int[] random(int tamanho){
		Random rand = new Random();
		int[] array = new int[tamanho*tamanho]; 
		for(int i=0; i<tamanho*tamanho; i++) {
			array[i] = i+1;
		}
		array[(tamanho*tamanho)-1] = -1;
		for(int i=0; i<tamanho*tamanho ;i++) {
			int index = rand.nextInt(tamanho*tamanho);
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		 return array;
	}
}