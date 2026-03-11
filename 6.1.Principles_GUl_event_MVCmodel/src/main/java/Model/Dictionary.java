package Model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) throws Exception {
        if (!words.containsKey(word.toLowerCase())) {
            throw new Exception("Word not found in dictionary.");
        }

        return words.get(word.toLowerCase());
    }

}

