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

    // chave
    private int key = 15;

  //  private void testaKey(int key) {
  //      for (int i = 0; i < 100; i++) {
    //        this.key = i;
      //      System.out.println(i);
        //    String message = "";
          //  for (char word : criptografaMensagem) {
            //    message = message + word;
            //}
            //System.out.println(message);
        //}

    //}

    // vai pegar o array criptografa mensagem
    // vai ler o metodo do arquivo
    public Criptografa() {
        this.criptografaMensagem = lerMensagem().toUpperCase().toCharArray();
    }

    public ArrayList<Character> descriptografar() {
        //pegar lista de caracteres (mensagem)
        char[] listaDeCaracteres = this.criptografaMensagem;


        //adicionar eles a um array
        ArrayList<Character> listaDeCaracteresDescriptografados = new ArrayList<Character>();
        String stringCaracteres = new String(this.listCriptogafa);

       listaDeCaracteres = metodoHash(listaDeCaracteres);

        // percorrendo o array
        for (char c : listaDeCaracteres) {

            // deixar em letra maiuscula caso nao houver
            char letraMaiuscula = Character.toUpperCase(c);

            // posição da letra, ex: A = 0
            int posicaoLetra = stringCaracteres.indexOf(letraMaiuscula);

            // adicionando a chave na posição da letra EERROO
            int indiceLetraDescriptografada = (posicaoLetra + key) % 31;

            // letra descriptografada
            char letraDescriptografada = stringCaracteres.charAt(indiceLetraDescriptografada);

            //populando array
            listaDeCaracteresDescriptografados.add(letraDescriptografada);
        } // fim for

        return listaDeCaracteresDescriptografados;

    }


    private char[] metodoHash(char[] listaDeCaracteres) {
        char hash = '#';
        char[] result = new char[listaDeCaracteres.length];

        for (int i = 0; i < listaDeCaracteres.length; i++) {
            if (listaDeCaracteres[i] == hash) {
                listaDeCaracteres[i] = ' ';
            }
            else {
                listaDeCaracteres[i] = listaDeCaracteres[i];
            }
            System.out.println("RESULTADO:: " + result);
        }
        return result;
    }
}







