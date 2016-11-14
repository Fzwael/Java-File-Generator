package compressors.Huffman;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeSet;


public class Huffman{
  
  public static void main(String[] args){
    Hashtable <Character,String>huffEncodeTable;
    String rawData = "AAAAABBBBCCCDDE";
    System.out.println("Raw Data");
    display48(rawData);
    int rawDataLen = rawData.length();
    System.out.println("nNumber raw data bits: " + rawData.length() * 8);
    HuffmanEncoder encoder = new HuffmanEncoder();
    huffEncodeTable = new Hashtable<Character,String>();
    ArrayList<Byte> binaryEncodedData = encoder.encode(rawData,huffEncodeTable);
    System.out.println("Number binary encoded data bits: "+ binaryEncodedData.size() * 8);
    System.out.println("Compression factor: " + (double)rawData.length()/binaryEncodedData.size());
    System.out.println("nBinary Encoded Data in Hexadecimal Format");
    hexDisplay48(binaryEncodedData);
    System.out.println();
    HuffmanDecoder decoder = new HuffmanDecoder();
    String decodedData = decoder.decode(binaryEncodedData,huffEncodeTable,rawDataLen);
    System.out.println("nDecoded Data");
    display48(decodedData);
}
  //-----------------------------------------------------//
  
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
  static void hexDisplay48(
                        ArrayList<Byte> binaryEncodedData){
    int charCnt = 0;
    for(Byte element : binaryEncodedData){
      System.out.print(
               Integer.toHexString((int)element & 0X00FF));
      charCnt++;
      if(charCnt%24 == 0){
        System.out.println();//new line
        charCnt = 0;
      }
    }
  }
}