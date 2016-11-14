/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressors.Huffman;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Fzwael
 */
public class HuffmanDecoder{
  Hashtable <String,Character>huffDecodeTable = 
                         new Hashtable<String,Character>();
  String stringDecodedData;
  String decodedData = "";
  Hashtable <Byte,String>decodingBitMap =new Hashtable<Byte,String>();
  ArrayList <Byte>binaryEncodedData;
  Hashtable <Character,String>huffEncodeTable;
  //Used to eliminate the extraneous characters on the end.
  int rawDataLen;
  String decode(ArrayList <Byte>binaryEncodedData,
               Hashtable <Character,String>huffEncodeTable,
               int rawDataLen){
    this.binaryEncodedData = binaryEncodedData;
    this.huffEncodeTable = huffEncodeTable;
    this.rawDataLen = rawDataLen;
    buildDecodingBitMap();
    decodeToBitsAsString();
    buildHuffDecodingTable();
    decodeStringBitsToCharacters();
    return decodedData.substring(0,rawDataLen);    
  }
  void buildDecodingBitMap(){
    for(int cnt = 0; cnt <= 255;cnt++){
      StringBuffer workingBuf = new StringBuffer();
      if((cnt & 128) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 64) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 32) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 16) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 8) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 4) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 2) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      if((cnt & 1) > 0){workingBuf.append("1");
        }else {workingBuf.append("0");};
      decodingBitMap.put((byte)(cnt),workingBuf.
                                               toString());
    }//end for loop
  }//end buildDecodingBitMap()
  void decodeToBitsAsString(){
    StringBuffer workingBuf = new StringBuffer();

    for(Byte element : binaryEncodedData){
      byte wholeByte = element;
      workingBuf.append(decodingBitMap.get(wholeByte));
    }//end for-each
    stringDecodedData = workingBuf.toString();
  }//end decodeToBitsAsString
  void buildHuffDecodingTable(){
    Enumeration <Character>enumerator = 
                                    huffEncodeTable.keys();
    while(enumerator.hasMoreElements()){
      Character nextKey = enumerator.nextElement();
      String nextString = huffEncodeTable.get(nextKey);
      huffDecodeTable.put(nextString,nextKey);
    }//end while
  }
  void decodeStringBitsToCharacters(){
    StringBuffer output = new StringBuffer();
    StringBuffer workBuf = new StringBuffer();
    for(int cnt = 0;cnt < stringDecodedData.length();cnt++){
      workBuf.append(stringDecodedData.charAt(cnt));
      if(huffDecodeTable.containsKey(workBuf.toString())){
        output.append(
                  huffDecodeTable.get(workBuf.toString()));
        workBuf = new StringBuffer();
      }//end if
    }//end for loop
    
    decodedData = output.toString();
  }
  void display48(String data){
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

}