package puzzleN;

import puzzleN.funcoes.*;
import puzzleN.interfaceGraf.*;

public class JogoMain {
	
	public static void main(String[] args) {
		Usuario player = new Usuario();
		Menu novoJogo = new Menu(player); //Não sei porque, mas algumas vezes o JFrame buga e tem que rodar o menu novamente para aparecer algo
	}
}
