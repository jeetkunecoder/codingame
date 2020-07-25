import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

  public static int longestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int end = 0;
    int total = 0;

    while (end < s.length()) {
      // Check if char exists already. If so, assign end to be the new start index
      start = Math.max(start, map.getOrDefault(s.charAt(end), -1));
      // Record the last appearance of the char seen, end in this case;
      map.put(s.charAt(end), end);
      // The total is the maximum between the previous
      // calculation on a previous substring and the current one
      total = Math.max(end - start , total);
      end++;
    }
    return  total;
  }

  public static void main(String[] args) {
    System.out.println(longestSubstring("ABCDEFGHABADEC"));
  }
}
