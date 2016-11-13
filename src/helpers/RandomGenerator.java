/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Fzwael
 */
public class RandomGenerator {

  private static Random random = new Random((new Date()).getTime());

    public static String generateRandomString(int length) {
      char[] values = {'A','B','C'};

      String out = "";

      for (int i=0;i<length;i++) {
          int idx=random.nextInt(values.length);
          out += values[idx];
      }
      return out;
    }
}
