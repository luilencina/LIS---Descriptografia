import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;


 public class Main {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         // chamando objeto criptografar
         Criptografa criptografa = new Criptografa();
         System.out.println("mensagem criptografada: " + criptografa.lerMensagem());

         // espaço pra deixar bonitinho
         System.out.println(" ");

         //Criando ArrayList das letras
         ArrayList<Character> letrasDescriptografadas = criptografa.descriptografar();

         System.out.print("Mensagem Descriptografada: ");

         // pegando letra por letra e populando um ArrayList
         for(Character mensagemDescriptografada: letrasDescriptografadas){
         System.out.print(mensagemDescriptografada);
         }
         }
     }



