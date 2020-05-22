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
         Criptografa criptografa = new Criptografa();
         System.out.println("mensagem criptografada: " + criptografa.lerMensagem());

         System.out.println("Descriptografada: " + criptografa.descriptografar());

         ArrayList<Character> listaQualquer = criptografa.descriptografar();

         System.out.println("testando: " + listaQualquer);

         for(Character testando: listaQualquer){
         System.out.print(testando);
         }
         }
     }



