public class Main {

    public static void main(String[] args) {

        ArvoreMorse arvore = new ArvoreMorse();
        arvore.inicializa();
        arvore.IniciaArvore();

        System.out.println("- Vis. da Estrutura -");
        arvore.mostra();

        System.out.println("- Busca Individual -");
        buscarLegivel(arvore, "...");
        buscarLegivel(arvore, "---");
        buscarLegivel(arvore, "....-");

        String morseMensagem = ".-. .--. . -.-.";
        System.out.println("- Mensagem -");
        System.out.println("Entrada Morse: " + morseMensagem);
        String mensagemDecodificada = arvore.decodificaTudo(morseMensagem);
        System.out.println("Mensagem: " + mensagemDecodificada);

        System.out.println("- Remoção -");
        char charRemover = 'E';
        arvore.remove(charRemover);
        System.out.println("- Busca após Remoção: '" + charRemover);
        buscarLegivel(arvore, ".");

        System.out.println("- Vis. Final -");
        arvore.mostra();
    }
    private static void buscarLegivel(ArvoreMorse arvore, String codigoMorse) {
        char resultado = arvore.acha(codigoMorse);
        if (resultado == '\0') {
            System.out.println("Morse: '" + codigoMorse + "': removido ou inexistente");
        } else {
            System.out.println("Morse: '" + codigoMorse + "': Caractere = " + resultado);
        }
    }
}