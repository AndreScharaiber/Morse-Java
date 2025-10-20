class Node {
    char caractere;

    Node esquerdo; // .
    Node direito; // -

    public Node() {
        this.caractere = ' ';
        this.esquerdo = null;
        this.direito = null;
    }

    public Node(char caractere) {
        this.caractere = caractere;
        this.esquerdo = null;
        this.direito = null;
    }
}