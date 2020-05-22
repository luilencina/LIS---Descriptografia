import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


    public class Criptografa {


    //Metodo para ler o arquivo SecretMessage
    public static String lerMensagem() {
        // achar arquivo SecretMessage
        File file = new File("SecretMessage.txt");
        FileReader fileReader = null;
        // adicionar ele a um novo file
        try {
            fileReader = new FileReader(file);
        }
        // caso arquivo não for encontrado
        catch (java.io.FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
        // escrever arquivo
        Scanner in = new Scanner(fileReader);
        // continuar linha x linha e retornar STRING
        String msg = "";
        while (in.hasNextLine()) {
            String line = in.nextLine();
            msg += line;
        }
        return msg;
    }

    // lista de posições e letras (array)
    private char[] listCriptogafa = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.', ',', ';', '!', '?'};

    private char[] criptografaMensagem;


    // vai pegar o array criptografa mensagem
    // vai ler o metodo do arquivo
    public Criptografa() {
        this.criptografaMensagem = lerMensagem().toUpperCase().toCharArray();
    }

    public int acharChave() {
        // Pegar a mensagem criptografada e separar em palavras (encontrar # e esplitar)
        // variavéis
        String criptografa = new String(this.criptografaMensagem);
        String [] listaPalavras = criptografa.split("#");

        ArrayList<String> palavrasComTamanhoCinco = new ArrayList<String>();


        for (String pal : listaPalavras){
            int tamanho = pal.length();
            if (tamanho == 6) {
                palavrasComTamanhoCinco.add(pal);
            }
        } // fecha for

        // iniciar varivéis
        int key = 0;
        boolean achouChave = false;
        String[] lista = new String[palavrasComTamanhoCinco.size()];
        while (!achouChave) {
            for (String pal : palavrasComTamanhoCinco.toArray(lista)){
                for (int i = 0; i < 60; i++) {
                    String palavraDescriptografada = this.descriptografar(pal, key);
                    if (palavraDescriptografada.equals("PRAZO")) {
                        key = i;
                        achouChave = true;
                        break;
                    }
                }
            }
        } // fecha while
        return key;
    }

    public String descriptografar(String mensagem, int chave){
        //pegar lista de caracteres (mensagem)

        char[] listaDeCaracteres = mensagem.toCharArray();


        //adicionar eles a um array
        ArrayList<Character> listaDeCaracteresDescriptografados = new ArrayList<Character>();
        String stringCaracteres = new String(this.listCriptogafa);

        // percorrendo o array
        for (char c : listaDeCaracteres) {

            // deixar em letra maiuscula caso nao houver
            char letraMaiuscula = Character.toUpperCase(c);

            // posição da letra, ex: A = 0
            int posicaoLetra = stringCaracteres.indexOf(letraMaiuscula);

            // adicionando a chave na posição da letra EERROO
            int indiceLetraDescriptografada = (posicaoLetra + chave) % 31;

            // letra descriptografada
            char letraDescriptografada = stringCaracteres.charAt(indiceLetraDescriptografada);

            // caso houver "#" ele substitui por " "
            if(c == '#'){
                letraDescriptografada = ' ';
            }
            //populando array
            listaDeCaracteresDescriptografados.add(letraDescriptografada);
        } // fim for

        String mensagemDescriptografada = listaDeCaracteresDescriptografados.toString();
        return mensagemDescriptografada;

    }

}







