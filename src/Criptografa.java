import java.lang.reflect.Array;
import java.util.ArrayList;

public class Criptografa {

    private char [] listCriptogafa = { 'A', 'B' , 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
     'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.', ',', ';', '!', '?'};

    private char [] criptografaMensagem;
    private int key = 15;


    public Criptografa(String mensagem){
        this.criptografaMensagem = mensagem.toUpperCase().toCharArray();
    }

    public String descriptografar() {
         //pegar lista de caracteres (mensagem)
        char[] listaDeCaracteres = this.listaCaracteres();
        //adicionar eles a um array
         ArrayList<Character> listaDeCaracteresDescriptografados = new ArrayList<Character>();

        // percorrendo o array
        for(char c: listaDeCaracteres) {
            // deixar em letra maiuscula caso nao houver
            char letraMaiuscula = Character.toUpperCase(c);
            // posição da letra, ex: A = 0
            int posicaoLetra = java.util.Arrays.asList(this.listCriptogafa).indexOf(letraMaiuscula);
            // adicionando a chave na posição da letra
            int indiceLetraDescriptografada = posicaoLetra + key;
            // letra descriptografada
            char letraDescriptografada = this.listCriptogafa[indiceLetraDescriptografada];
            // mensagem
            listaDeCaracteresDescriptografados.add(letraDescriptografada);
        }

        char[] arrayCaracteres = new char[listaDeCaracteresDescriptografados.size()];
        return new String(arrayCaracteres);
    }

    private char[] listaCaracteres() {
        return this.criptografaMensagem;
    }

    private int cont (int i){
        int cont = Math.abs(30 + (i - key));
        while(cont>30){
            cont = Math.abs(cont - 30);
        }
        return cont;
    }



}
