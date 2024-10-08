/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author thanh
 */
public class BangMaChuDon {
  public static void generateKey() {
        keyMap.clear();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        for (char c : alphabet.toCharArray()) {
            char newChar;
            do {
                newChar = alphabet.charAt(random.nextInt(alphabet.length()));
            } while (keyMap.containsValue(newChar)); 
            keyMap.put(c, newChar);
        }
    }

   
    public static String encrypt(String input, String keyString) {
        Map<Character, Character> customKeyMap = createKeyMap(keyString);
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            encrypted.append(customKeyMap.getOrDefault(c, c)); 
        }
        return encrypted.toString();
    }

   
    public static String decrypt(String input, String keyString) {
        Map<Character, Character> customKeyMap = createKeyMap(keyString);
        Map<Character, Character> reverseKeyMap = new HashMap<>();
        
     
        for (Map.Entry<Character, Character> entry : customKeyMap.entrySet()) {
            reverseKeyMap.put(entry.getValue(), entry.getKey());
        }

        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            decrypted.append(reverseKeyMap.getOrDefault(c, c)); 
        }
        return decrypted.toString();
    }

    private static Map<Character, Character> createKeyMap(String keyString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
