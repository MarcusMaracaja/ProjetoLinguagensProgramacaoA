package to;

import java.util.ArrayList;
import java.util.List;

public class TokensTO {

	public List<String> listaPalavrasChaves = new ArrayList<>();
	public List<String> listaDelimitadores = new ArrayList<>();
	public List<String> listaComandoAtribuicao = new ArrayList<>();
	public List<String> listaOperadoresRelacionais = new ArrayList<>();
	public List<String> listaOperadoresAditivos = new ArrayList<>();
	public List<String> listaOperadoresMultiplicativos = new ArrayList<>();

	// Construtor da classe
	public TokensTO() {
		// Inicialização de lista de palavras-chave
		listaPalavrasChaves.add("program");
		listaPalavrasChaves.add("var");
		listaPalavrasChaves.add("integer");
		listaPalavrasChaves.add("real");
		listaPalavrasChaves.add("boolean");
		listaPalavrasChaves.add("procedure");
		listaPalavrasChaves.add("begin");
		listaPalavrasChaves.add("end");
		listaPalavrasChaves.add("if");
		listaPalavrasChaves.add("then");
		listaPalavrasChaves.add("else");
		listaPalavrasChaves.add("while");
		listaPalavrasChaves.add("do");
		listaPalavrasChaves.add("not");
		listaPalavrasChaves.add("writeln");

		// Inicialização de lista de delimitadores
		listaDelimitadores.add(";");
		listaDelimitadores.add(".");
		listaDelimitadores.add(",");
		listaDelimitadores.add(":");
		listaDelimitadores.add("(");
		listaDelimitadores.add(")");

		// Inicialização de lista de comandos de atribuição (f)
		listaComandoAtribuicao.add(":=");

		// Inicialização de lista de operadores relacionais (e)
		listaOperadoresRelacionais.add("=");
		listaOperadoresRelacionais.add("<");
		listaOperadoresRelacionais.add(">");
		listaOperadoresRelacionais.add("<=");
		listaOperadoresRelacionais.add(">=");
		listaOperadoresRelacionais.add("<>");

		// Inicialização de lista de operadores aditivos (g)
		listaOperadoresAditivos.add("+");
		listaOperadoresAditivos.add("-");
		listaOperadoresAditivos.add("or");

		// Inicialização de lista de operadores multiplicativos (h)
		listaOperadoresMultiplicativos.add("*");
		listaOperadoresMultiplicativos.add("/");
		listaOperadoresMultiplicativos.add("and");
	}

	public void adicionarPalavraChave(String palavra) {
		listaPalavrasChaves.add(palavra);
	}
}
