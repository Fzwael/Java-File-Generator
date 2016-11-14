package compressors.Huffman;

import static compressors.LZW.compressString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeSet;


public class Huffman{
  
  public static void main(String[] args){
    Hashtable <Character,String>huffEncodeTable;
    String rawData = "CCABBBCBCAAACABACABBABACACAAAAABBBCBBABABCBACCCBBAABBACAABBAAACBACABCACBBABAABBABCACBACBCBBCCABCBAAB";
    System.out.println("Raw Data");
    display48(rawData);
    int rawDataLen = rawData.length();
    // System.out.println("nNumber raw data bits: " + rawData.length() * 8);
    HuffmanEncoder encoder = new HuffmanEncoder();
    huffEncodeTable = new Hashtable<Character,String>();
    ArrayList<Byte> binaryEncodedData = encoder.encode(rawData,huffEncodeTable);
    // System.out.println("Number binary encoded data bits: "+ binaryEncodedData.size() * 8);
    // System.out.println("Compression factor: " + (double)rawData.length()/binaryEncodedData.size());
    // System.out.println("nBinary Encoded Data in Hexadecimal Format");
    hexDisplay48(binaryEncodedData);
    System.out.println();
    HuffmanDecoder decoder = new HuffmanDecoder();
    String decodedData = decoder.decode(binaryEncodedData,huffEncodeTable,rawDataLen);
    // System.out.println("nDecoded Data");
    // display48(decodedData);
}
  //-----------------------------------------------------//
  
 public static void compress(File file){
        try{
        File compressedFile = new File(file.getName() + "-Huffman");
        PrintWriter writer = new PrintWriter(compressedFile, "UTF-8");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8")));
        int c , read = 0;
        String s = "";
        while((c = reader.read()) != -1) {
            char character = (char) c;
            if(read == 100){
                Hashtable <Character,String>huffEncodeTable;
                HuffmanEncoder encoder = new HuffmanEncoder();
                huffEncodeTable = new Hashtable<Character,String>();
                
                //System.out.println("STRING     " + s);
                //System.out.println("COMPRESSED " + hexa(encoder.encode(s,huffEncodeTable)));
                writer.print(hexa(encoder.encode(s,huffEncodeTable)));
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
        System.out.println("ALL DONE Huffman");
    }
  
  //Utility method to display a String 48 characters to
  // the line.
  static void display48(String data){
    for(int cnt = 0;cnt < data.length();cnt += 48){
      if((cnt + 48) < data.length()){
        //Display 48 characters.
        System.out.println(data.substring(cnt,cnt+48));
      }else{
        //Display the final line, which may be short.
        System.out.println(data.substring(cnt));
      }//end else
    }//end for loop
  }//end display48
  //-----------------------------------------------------//
  
  //Utility method to display hex data 48 characters to
  // the line
  
  static String hexa(ArrayList<Byte> binaryEncodedData){
      String result = "";
      int charCnt = 0;
    for(Byte element : binaryEncodedData){
      result = result + Integer.toHexString((int)element & 0X00FF);
      charCnt++;
      if(charCnt%24 == 0){
        result = result + "\n";//new line
        charCnt = 0;
      }
    }
    return result;
  }
  
  static void hexDisplay48(ArrayList<Byte> binaryEncodedData){
    int charCnt = 0;
    for(Byte element : binaryEncodedData){
      System.out.print(Integer.toHexString((int)element & 0X00FF));
      charCnt++;
      if(charCnt%24 == 0){
        System.out.println();//new line
        charCnt = 0;
      }
    }
  }
}