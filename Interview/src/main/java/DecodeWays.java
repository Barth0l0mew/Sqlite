// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26

// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays decodeWays= new DecodeWays();
        System.out.println(decodeWays.numDecodings("123"));
    }
    public int numDecodings(String s) {
        int n = s.length();

        if(n == 0) {
            return 0;
        }
        System.out.println(s+" "+n);
        int[] dp = new int[n +1];
        dp[n] = 1;
        System.out.println(s.charAt(n -1) != '0');
        dp[n - 1] = s.charAt(n -1) == '0' ? 0 : 1;
        System.out.println(Arrays.toString(dp)+" "+n);
        for(int i = n - 2; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                continue;
            } else {
                System.out.println(Arrays.toString(dp));
                dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        
        return dp[0];
    }
}