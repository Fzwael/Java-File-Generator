/*
    Exemple: AAAAAAAAZZEEEEEER donne : 8A2Z6E1R
 */
package compressors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 *
 * @author Fzwael , Dorra
 */
public class RLE {
    public static void compress(File file) {
        System.out.println("I will compress " + file.getName());
        try{
        File compressedFile = new File(file.getName() + "-RLE");
        PrintWriter writer = new PrintWriter(compressedFile, "UTF-8");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8")));
        int c;
        int occ = 1;
        char prevChar = (char) reader.read();
        System.out.println("INIT " + prevChar);
        while((c = reader.read()) != -1) {
            char character = (char) c;
            if(character != prevChar){
               writer.print(occ+""+prevChar);
               occ = 1;
               prevChar = character;
            }
            else
                occ+=1;
       }
        writer.print(occ+""+prevChar);
        writer.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        System.out.println();
        System.out.println("ALL DONE");
    }
}
