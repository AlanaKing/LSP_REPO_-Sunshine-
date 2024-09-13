package org.howard.edu.lsp.assignment2;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LSPAssignment2_king{

    public static void main(String[] args) {
        
        String filePath = "LSPAssignment2_word.txt";

        
        Map<String, Integer> wordCountMap = new HashMap<>();

        
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            
            while ((line = reader.readLine()) != null) {
               
                processLine(line.toLowerCase(), wordPattern, wordCountMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        printWordCounts(wordCountMap);
    }

    private static void processLine(String line, Pattern wordPattern, Map<String, Integer> wordCountMap) {
        
        java.util.regex.Matcher matcher = wordPattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            
            if (word.length() > 3) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
    }

    private static void printWordCounts(Map<String, Integer> wordCountMap) {
        
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.printf("%-10s %d%n", entry.getKey(), entry.getValue());
        }
    }
}
