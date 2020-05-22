import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;


 public class main {
     public static void main(String args[]) {

         // achar arquivo SecretMessage
         File file = new File("SecretMessage.txt");
         FileReader fileReader = null;
         // adicionar ele a um novo file
         try {
             fileReader = new FileReader(file);

         } // caso arquivo não for encontrado
          catch (java.io.FileNotFoundException e) {
             System.out.println("Arquivo não encontrado!");
         }
         // escrever arquivo
         Scanner in = new Scanner(fileReader);
         // continuar linha x linha
         while (in.hasNextLine()) {
             String line = in.nextLine();
             System.out.println(line);
         }


     }
 }
