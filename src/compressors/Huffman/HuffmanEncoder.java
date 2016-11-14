/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressors.Huffman;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeSet;

/**
 *
 * @author Fzwael
 */
public class HuffmanEncoder{
  String rawData;  
  TreeSet <HuffTree>theTree = new TreeSet<HuffTree>();
  ArrayList <Byte>binaryEncodedData = 
                                     new ArrayList<Byte>();
  Hashtable <Character,Integer>frequencyData = 
                        new Hashtable<Character,Integer>();
  StringBuffer code = new StringBuffer();
  Hashtable <Character,String>huffEncodeTable;
  String stringEncodedData;
  Hashtable <String,Byte>encodingBitMap = new Hashtable<String,Byte>();
  ArrayList<Byte> encode(String rawData,Hashtable <Character,String>huffEncodeTable){
    this.rawData = rawData;
    this.huffEncodeTable = huffEncodeTable;
    createFreqData();
    createLeaves();
    createHuffTree();
    createBitCodes(theTree.first());
    encodeToString();
    buildEncodingBitMap();
    encodeStringToBits();
    return binaryEncodedData;
  }
  void displayRawDataAsBits(){
    for(int cnt = 0,charCnt = 0;cnt < rawData.length();cnt++,charCnt++){
      char theCharacter = rawData.charAt(cnt);
      String binaryString = Integer.toBinaryString(theCharacter);
      while(binaryString.length() < 8){
        binaryString = "0" + binaryString;
      }//end while loop
      if(charCnt%6 == 0){
        //Display 48 bits per line.
        charCnt = 0;
        System.out.println();//new line
      }//end if
      System.out.print(binaryString);
    }//end for loop
    System.out.println();
  }//end displayRawDataAsBits
  void createFreqData(){
    for(int cnt = 0;cnt < rawData.length();cnt++){
      char key = rawData.charAt(cnt);
      if(frequencyData.containsKey(key)){
        int value = frequencyData.get(key);
        value += 1;
        frequencyData.put(key,value);
      }else{
        frequencyData.put(key,1);
      }//end else
    }//end for loop
  }//end createFreqData
  void displayFreqData(){
    System.out.println("nFrequency Data");
    Enumeration <Character>enumerator = 
                                      frequencyData.keys();
    while(enumerator.hasMoreElements()){
      Character nextKey = enumerator.nextElement();
      System.out.println(
               nextKey + " " + frequencyData.get(nextKey));
    }//end while
  }//end displayFreqData
  void createLeaves(){
    Enumeration <Character>enumerator = 
                                      frequencyData.keys();
    while(enumerator.hasMoreElements()){
      Character nextKey = enumerator.nextElement();
      theTree.add(new HuffLeaf(
                      nextKey,frequencyData.get(nextKey)));
    }//end while
  }//end createLeaves
  class HuffLeaf extends HuffTree{
    private int value;
    public HuffLeaf(int value, int frequency){
      this.value = value;
      this.frequency = frequency;
    }//end HuffLeaf constructor
    public int getValue(){
      return value;
    }//end getValue
  
  }
  void createHuffTree(){
    while(theTree.size() > 1){
      HuffTree left = theTree.first();
      theTree.remove(left);
      HuffTree right = theTree.first();
      theTree.remove(right);
      HuffNode tempNode = new HuffNode(left.getFrequency() + right.getFrequency(),left,right);
      theTree.add(tempNode);
    }//end while
  }//end createHuffTree
  void displayHuffTree(HuffTree tree,int recurLevel){recurLevel++;
    if(tree instanceof HuffNode){
      HuffNode node = (HuffNode)tree;
      HuffTree left = node.getLeft();
      HuffTree right = node.getRight();
      System.out.print("  Left to " + recurLevel + " ");
      displayHuffTree(left,recurLevel);
      System.out.print("  Right to " + recurLevel + " ");
      displayHuffTree(right,recurLevel);
    }else{
      HuffLeaf leaf = (HuffLeaf)tree;
      System.out.println(
                        "  Leaf:" + (char)leaf.getValue());
    }//end else
    System.out.print("  Back ");
  }
  class HuffNode extends HuffTree{
    private HuffTree left;
    private HuffTree right;
    public HuffNode(int frequency,HuffTree left,HuffTree right){
      this.frequency = frequency;
      this.left = left;
      this.right = right;
    }//end HuffNode constructor
  
    public HuffTree getLeft(){
      return left;
    }//end getLeft
  
    public HuffTree getRight(){
      return right;
    }//end getRight
  
  }//end HuffNode class
  void createBitCodes(HuffTree tree){
    if(tree instanceof HuffNode){
      HuffNode node = (HuffNode)tree;
      HuffTree left = node.getLeft();
      HuffTree right = node.getRight();
      code.append("0");
      createBitCodes(left);
      code.deleteCharAt(code.length() - 1);//Delete the 0.
      code.append("1");
      createBitCodes(right);
      code.deleteCharAt(code.length() - 1);
    }else{
      HuffLeaf leaf = (HuffLeaf)tree;
      huffEncodeTable.put((char)(
                         leaf.getValue()),code.toString());
    }//end else

  }//end createBitCodes
  void displayBitCodes(){
    System.out.println("nMessage Characters versus Huffman BitCodes");
    Enumeration <Character>enumerator =huffEncodeTable.keys();
    while(enumerator.hasMoreElements()){
      Character nextKey = enumerator.nextElement();
      System.out.println(nextKey + " " + huffEncodeTable.get(nextKey));
    }//end while
  }//end displayBitCodes
  void encodeToString(){
    StringBuffer tempEncoding = new StringBuffer();
    for(int cnt = 0;cnt < rawData.length();cnt++){
      tempEncoding.append(huffEncodeTable.get(
                                     rawData.charAt(cnt)));
    }//end for loop    
    stringEncodedData = tempEncoding.toString();
  }//end encodeToString
  void buildEncodingBitMap(){

    for(int cnt = 0; cnt <= 255;cnt++){
      StringBuffer workingBuf = new StringBuffer();
      if((cnt & 128) > 0){workingBuf.append("1");
        }else{workingBuf.append("0");};
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
      encodingBitMap.put(workingBuf.toString(),
                                              (byte)(cnt));
    }//end for loop
  }//end buildEncodingBitMap
  void encodeStringToBits(){
    int remainder = stringEncodedData.length()%8;
    for(int cnt = 0;cnt < (8 - remainder);cnt++){
      stringEncodedData += "0";
    }//end for loop
    for(int cnt = 0;cnt < stringEncodedData.length();cnt += 8){
      String strBits  = stringEncodedData.substring(cnt,cnt+8);
      byte realBits = encodingBitMap.get(strBits);
      binaryEncodedData.add(realBits);
    }//end for loop
  }//end encodeStringToBits
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
}