package puzzleN;

public class JogoMain {
	
	public static void main(String[] args) {
		Usuario usuario1 = new Usuario();
		usuario1.setName("Lucas");
		Dados dados1 = new Dados();
		dados1.setTamanho(3);
		dados1.embaralhar();
	}
}
