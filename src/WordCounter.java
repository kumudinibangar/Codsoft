
    import java.util.HashMap;
import java.util.Map;

    public class WordCounter {
        public static void main(String[] args) {
            String inputText = getInputText();

            if (inputText.isEmpty()) {
                System.out.println("No input provided.");
                return;
            }

            String[] words = inputText.split("[\\s\\p{Punct}]+");

            int totalWordCount = words.length;
            System.out.println("Total number of words: " + totalWordCount);

            // Optional: Count unique words and their frequencies
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("Unique words and their frequencies:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        private static String getInputText() {
            // Implement code to read input from the user or a file
            // For simplicity, let's assume input is provided as a string
            String inputText = "Kumudini is a preety girl she likes dancing ";
            return inputText;
        }
    }


