/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressors.Huffman;

/**
 *
 * @author Fzwael
 */
public abstract class HuffTree implements Comparable{

  int frequency;
  
  public int getFrequency(){
    return frequency;
  }
  public int compareTo(Object obj){
    HuffTree theTree = (HuffTree)obj;
    if (frequency == theTree.frequency){
      return (hashCode() - theTree.hashCode());
    }else{
      return frequency - theTree.frequency;
    }//end else
  }//end compareTo
}