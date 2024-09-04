package Analisador;

public class Main {

	public static void main(String[] args) {
		String programa1 = "program teste; {programa exemplo}\n" +
				"var\n" +
				"valor1: integer;\n" +
				"valor2: real;\n" +
				"begin\n" +
				"valor1 := 10;\n" +
				"end.";
		
		String programa2 = "program ExemploProcedura;\n" +
                "\n" +
                "var\n" +
                "    valor1: integer;\n" +
                "    valor2: real;\n" +
                "\n" +
                "procedure SomaValores;\n" +
                "begin\n" +
                "    valor1 := 10;\n" +
                "    valor2 := 5.5;\n" +
                "    writeln('A soma é: ', valor1 + valor2);\n" +
                "end;\n" +
                "\n" +
                "begin\n" +
                "    SomaValores;\n" +
                "end.";

		Analisador scanner = new Analisador();
        System.out.println("Inicio da análise Lexica do programa 1\n\n");
		scanner.leitorString(programa1);
//        System.out.println("\n\nPrograma 2\n\n");
//        scanner.leitorString(programa2);

	}

}
