package Analisador;

import java.util.ArrayList;
import java.util.List;

import to.TokensTO;

public class Analisador {

	private TokensTO tokensTO;
	private List<String> tabelaTokens;

	public Analisador() {
		tokensTO = new TokensTO(); 
		tabelaTokens = new ArrayList<>();		
	}

	public void leitorString(String texto) {
		String[] linhas = texto.split("\n");
		int linhaAtual = 0;

		for (String linha : linhas) {
			linhaAtual++;
			linha = linha.trim();
			if (linha.isEmpty()) {
				continue; // Ignora linhas vazias
			}

			// Variável para controle de comentários
			boolean dentroDoComentario = false;
			int posicaoAtual = 0;

			while (posicaoAtual < linha.length()) {
				// Detecta início de comentário
				if (linha.startsWith("{", posicaoAtual)) {
					dentroDoComentario = true;
				}

				// Detecta fim de comentário
				if (dentroDoComentario) {
					if (linha.startsWith("}", posicaoAtual)) {
						dentroDoComentario = false;
						posicaoAtual++; // Avança para além do '}'.
						continue;
					} else {
						posicaoAtual++; // Avança para o próximo caractere dentro do comentário.
						continue;
					}
				}

				char caractere = linha.charAt(posicaoAtual);

				// Ignora espaços em branco
				if (Character.isWhitespace(caractere)) {
					posicaoAtual++;
					continue;
				}

				// Verifica se é uma atribuição ":="
				if (linha.startsWith(":=", posicaoAtual)) {
					tabelaTokens.add(":=\tAtribuição\t" + linhaAtual);
					posicaoAtual += 2; // Pula o ":="
					continue;
				}

				// Verifica se é um delimitador
				if (tokensTO.listaDelimitadores.contains(String.valueOf(caractere))) {
					tabelaTokens.add(caractere + "\tDelimitador\t" + linhaAtual);
					posicaoAtual++;
					continue;
				}

				// Verifica se é um operador aditivo
				if (tokensTO.listaOperadoresAditivos.contains(String.valueOf(caractere))) {
					tabelaTokens.add(caractere + "\tOperador aditivo\t" + linhaAtual);
					posicaoAtual++;
					continue;
				}

				// Verifica se é um identificador ou palavra reservada
				if (Character.isLetter(caractere)) {
					StringBuilder identificador = new StringBuilder();
					while (posicaoAtual < linha.length() && (Character.isLetterOrDigit(linha.charAt(posicaoAtual)))) {
						identificador.append(linha.charAt(posicaoAtual));
						posicaoAtual++;
					}
					String token = identificador.toString();
					if (tokensTO.listaPalavrasChaves.contains(token)) {
						tabelaTokens.add(token + "\tPalavra reservada\t" + linhaAtual);
					} else {
						tabelaTokens.add(token + "\tIdentificador\t" + linhaAtual);
					}
					continue;
				}

				// Verifica se é um número
				if (Character.isDigit(caractere)) {
					StringBuilder numero = new StringBuilder();
					while (posicaoAtual < linha.length() && Character.isDigit(linha.charAt(posicaoAtual))) {
						numero.append(linha.charAt(posicaoAtual));
						posicaoAtual++;
					}
					tabelaTokens.add(numero.toString() + "\tNúmero inteiro\t" + linhaAtual);
					continue;
				}

				// Incrementa a posição se não foi reconhecido
				posicaoAtual++;
			}
		}
		printaTabela();
	}



	private void printaTabela() {
		System.out.println("Token\tClassificação\t\tLinha");
		for (String tokenInfo : tabelaTokens) {
			System.out.println(tokenInfo);
		}

	}

}
