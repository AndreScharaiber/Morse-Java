class ArvoreMorse {
    Node raiz;

    String[] codigomorse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
    };

    char[] letras = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    public void inicializa() {
        this.raiz = new Node();
    }

    public void IniciaArvore() {
        if (this.raiz == null) {
            inicializa();
        }

        int i = 0;
        while (i < letras.length) {
            Insere(codigomorse[i], letras[i]);
            i++;
        }
        System.out.println("Tudo inserido");
    }

    public void Insere(String codigo, char letra) {
        Node atual = this.raiz;

        int i = 0;
        while (i < codigo.length()) {
            char simbolo = codigo.charAt(i);

            if (simbolo == '.') {
                if (atual.esquerdo == null) {
                    atual.esquerdo = new Node();
                }
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                if (atual.direito == null) {
                    atual.direito = new Node();
                }
                atual = atual.direito;
            }
            i++;
        }

        atual.caractere = letra;
    }

    public char acha(String codigo) {
        Node atual = this.raiz;

        int i = 0;
        while (i < codigo.length()) {
            char simbolo = codigo.charAt(i);

            if (simbolo == '.') {
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                atual = atual.direito;
            }
            i++;

            if (atual == null) {
                return '\0';
            }
        }

        System.out.println("Decodificando " + codigo + ": " + atual.caractere);
        return atual.caractere;
    }
    public String decodificarMensagem(String mensagem) {
        String resultado = "";

        int inicio = 0;
        int fim = 0;
        mensagem = mensagem.trim();

        while (inicio < mensagem.length()) {
            fim = inicio;
            while (fim < mensagem.length() && mensagem.charAt(fim) != ' ') {
                fim++;
            }
            String codigoAtual = mensagem.substring(inicio, fim);

            if (codigoAtual.length() > 0) {
                char caractereDecodificado = acha(codigoAtual);
                resultado = resultado + caractereDecodificado;
            }
            inicio = fim + 1;
            while (inicio < mensagem.length() && mensagem.charAt(inicio) == ' ') {
                inicio++;
            }
        }

        return resultado;
    }
    public boolean remove(char c) {
        String codigoParaRemover = null;
        int i = 0;
        while (i < letras.length) {
            if (letras[i] == c) {
                codigoParaRemover = codigomorse[i];
                break;
            }
            i++;
        }

        if (codigoParaRemover == null) {
            System.out.println("Nao tá na lista");
            return false;
        }

        Node atual = this.raiz;
        i = 0;
        while (i < codigoParaRemover.length()) {
            char simbolo = codigoParaRemover.charAt(i);

            if (simbolo == '.') {
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                atual = atual.direito;
            }
            i++;
        }

        if (atual != null && atual.caractere == c) {
            atual.caractere = '\0';
            System.out.println("Removido");
            return true;
        }

        return false;
    }

    public void mostra() {
        System.out.println("Mostrando arvore");
        if (this.raiz == null) {
            System.out.println("Vazia");
            return;
        }

        mostraRecursivo(this.raiz, "");
    }

    void mostraRecursivo(Node n, String prefixo) {
        if (n != null) {
            String simb = (n.caractere != '\0') ? " Caractere: " + n.caractere : " (no)";
            System.out.println(prefixo + simb);

            if (n.esquerdo != null) {
                System.out.println(prefixo + "- Esquerda");
                mostraRecursivo(n.esquerdo, prefixo + "  ");
            }

            if (n.direito != null) {
                System.out.println(prefixo + "- Direita");
                mostraRecursivo(n.direito, prefixo + "  ");
            }
        }
    }
}
