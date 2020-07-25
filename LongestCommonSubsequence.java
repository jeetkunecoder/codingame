
public class LongestCommonSubsequence {

  public static int lcs(String s1, String s2) {
    int[][] cache = new int[s2.length() + 1][s1.length() + 1];

    for (int i = 0; i <= s2.length(); i++) {
      for (int j = 0; j <= s1.length(); j++) {
        if (i == 0 || j == 0) {
          cache[i][j] = 0;
        } else if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
          cache[i][j] = cache[i - 1][j - 1] + 1;
        } else {
          cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
        }
      }
    }

    return cache[s2.length()][s1.length()];
  }

  public static void main(String[] args) {
    System.out.println(lcs("aab", "acb"));
  }
}