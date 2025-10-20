# Morse-Java

O projeto consiste na implementação de uma Árvore Binária para a simulação da decodificação de mensagens em Código Morse. O objetivo central é gerenciar o mapeamento completo dos caracteres alfanuméricos, de forma que o caminho percorrido da raiz até cada nó defina o código: ponto (.) para o lado esquerdo e traço (-) para o lado direito.

O desenvolvimento da solução seguiu restrições rigorosas de baixo nível, evitando a utilização de bibliotecas avançadas como java.util, funções automatizadas (StringBuilder) e outras coleções prontas. O foco foi na implementação manual de estruturas e lógicas, utilizando apenas tipos primitivos e estruturas básicas de controle de fluxo.

A solução está organizada em duas classes principais: Node e ArvoreMorse. A classe Node define a estrutura básica da Árvore Binária, com referências explícitas para os nós esquerdo e direito, seguindo o padrão de implementação de estruturas de dados.

Na lógica de implementação, arrays como String[] codigomorse e char[] letras funcionam como tabelas estáticas de dados primitivos, essenciais para a inserção automática dos caracteres na árvore.
