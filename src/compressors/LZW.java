/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressors;

/**
 *
 * @author Fzwael
 */
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LZW {
    /** Compress a string to a list of output symbols. */
            static int c;
            static BufferedReader reader;
            static String s = "";
            static int read = 0;
            static String compressedString;
            
    public static void compress(File file){
        try{
        File compressedFile = new File(file.getName() + "-LZW");
        PrintWriter writer = new PrintWriter(compressedFile, "UTF-8");
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8")));
        
        while((c = reader.read()) != -1) {
            char character = (char) c;
            if(read == 100){
                //System.out.println("STRING     " + s);
                //System.out.println("COMPRESSED " + compressString(s).toString());
                //compressedString = compressString(s).toString();
                compressedString = Arrays.toString(compressString(s).toArray()).replace("[", "").replace("]", "").replace(" ", "").replace(",", " ");
                writer.print(compressedString);
                s = "";
                read = 0;
            }
            else{
                read ++;
                s = s+character;
            }
       }
        writer.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        System.out.println("ALL DONE LZW");
    }
    
    public static List<Integer> compressString(String uncompressed) {
        // Build the dictionary.
        int dictSize = 256;
        Map<String,Integer> dictionary = new HashMap<String,Integer>();
        //for (int i = 0; i < 256; i++)
            //dictionary.put("" + (char)i, i);
            
          for (int i = 65; i < 123; i++)
            dictionary.put("" + (char)i, i - 64);
 
        String w = "";
        List<Integer> result = new ArrayList<Integer>();
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc))
                w = wc;
            else {
                result.add(dictionary.get(w));
                // Add wc to the dictionary.
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }
        // Output the code for w.
        if (!w.equals(""))
            result.add(dictionary.get(w));
        return result;
    }
 
    /** Decompress a list of output ks to a string. */
    public static String decompress(List<Integer> compressed) {
        // Build the dictionary.
        int dictSize = 256;
        Map<Integer,String> dictionary = new HashMap<Integer,String>();
        for (int i = 0; i < 256; i++)
            dictionary.put(i, "" + (char)i);
 
        String w = "" + (char)(int)compressed.remove(0);
        StringBuffer result = new StringBuffer(w);
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k))
                entry = dictionary.get(k);
            else if (k == dictSize)
                entry = w + w.charAt(0);
            else
                throw new IllegalArgumentException("Bad compressed k: " + k);
 
            result.append(entry);
 
            // Add w+entry[0] to the dictionary.
            dictionary.put(dictSize++, w + entry.charAt(0));
 
            w = entry;
        }
        System.out.println(dictionary);
        return result.toString();
    }
}