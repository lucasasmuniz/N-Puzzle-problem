package puzzleN.funcoes;

public class Usuario {
	private String nome;
	private int movimento;
	private int tamanho;
	
	public void setNome(String nome){
		if(nome.isEmpty()) {
			this.nome = "Indefinido";
		}else if(nome.length()>12) {
			this.nome = nome.substring(0,12);
		}else {
			this.nome = nome;
		}
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setTamanho(int dificuldade) {
		this.tamanho = dificuldade;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
}
