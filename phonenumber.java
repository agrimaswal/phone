import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] phoneMapping = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, digits, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMapping[digit - '0'];

        for (char letter : letters.toCharArray()) {
            backtrack(result, digits, current + letter, index + 1);
        }
    }
}
