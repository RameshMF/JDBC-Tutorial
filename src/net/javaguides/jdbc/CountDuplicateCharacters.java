package net.javaguides.jdbc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharacters {
	private static final String TEXT = "Java is a popular "
			+ " general-purpose programming language "
			+ "and computing platform. It is fast, reliable, and secure.";
       
    public static void main(String[] args) {
        
        System.out.println("Input text: \n" + TEXT + "\n");
        
        System.out.println("HashMap based solution:");
        Map<Character, Integer> duplicatesV1 = countDuplicateCharactersV1(TEXT);
        System.out.println(Arrays.toString(duplicatesV1.entrySet().toArray()));
        
        System.out.println();        
        System.out.println("Java 8, functional-style solution:");
        Map<Character, Long> duplicatesV2 = countDuplicateCharactersV2(TEXT);
        System.out.println(Arrays.toString(duplicatesV2.entrySet().toArray()));
    }
    
    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {

        if (str == null) {
            // or throw IllegalArgumentException
            return Collections.EMPTY_MAP;
        }

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);

            Integer count = result.get(ch);
            if (count != null) {
                result.put(ch, ++count);
            } else {
                result.put(ch, 1);
            }
        }

        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {
        
        if (str == null) {
            // or throw IllegalArgumentException
            return Collections.EMPTY_MAP;
        }
     
        Map<Character, Long> result = str.chars()                
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}
