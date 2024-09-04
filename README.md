Aluno: Marcus Vinícius Maracajá Pires
RGM 40526259

 PROJETO 1:
Analisador Sintático

Objetivo do Projeto
O objetivo deste projeto é desenvolver um analisador sintático para a linguagem Pascal, capaz de interpretar e classificar trechos de código. O analisador identifica tokens como palavras reservadas, identificadores, delimitadores, operadores de atribuição, aditivos e relacionais, fornecendo uma representação estruturada do código.

Estrutura do Código:
O núcleo do projeto é a classe `TokensTO`, que contém listas que definem as palavras-chave e operadores da linguagem Pascal. Ao inicializar essa classe, garantimos que o analisador tenha um repertório adequado para a identificação correta dos tokens. Por exemplo:

Java:
listaPalavrasChaves.add("program");
listaPalavrasChaves.add("var");
listaPalavrasChaves.add("begin");
```

Essas definições são fundamentais para o funcionamento do analisador.

Funcionamento do Analisador:
O método principal, `leitorString`, processa o código linha por linha, ignorando espaços em branco e comentários. A lógica de controle é essencial para garantir uma leitura limpa do código. Um exemplo dessa lógica é:

java
if (linha.startsWith("{", posicaoAtual)) {
    dentroDoComentario = true;
}
```

Detecção e Classificação de Tokens:
A classificação correta dos tokens é um aspecto crucial. O analisador verifica a presença de operadores de atribuição, como `:=`, antes de operadores aditivos, como `+` e `-`, para evitar confusões. O trecho de código a seguir ilustra essa verificação:

java
if (linha.startsWith(":=", posicaoAtual)) {
    tabelaTokens.add(":=\tAtribuição\t" + linhaAtual);
    posicaoAtual += 2; // Pula o ":="
    continue;
}
```

Essa abordagem assegura que a atribuição seja reconhecida corretamente.

Resultados:
Ao final da análise, o projeto gera uma tabela de tokens que representa a estrutura do código Pascal. Esta tabela não só documenta a interpretação do código, mas também reflete o aprendizado sobre manipulação de strings, lógica condicional e uso de listas em Java.

Considerações Finais:
Este projeto demonstra a aplicação prática de conceitos de programação em um contexto real de análise de linguagem. A construção do analisador sintático não apenas proporciona uma melhor compreensão da linguagem Pascal, mas também aprimora habilidades em Java. Estou aberto a discussões sobre as decisões tomadas durante o desenvolvimento e quaisquer perguntas que possam surgir.
