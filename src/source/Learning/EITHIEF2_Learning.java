/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Learning;

import java.util.Scanner;

/**
 *
 * @author Satan
 */
public class EITHIEF2_Learning {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        long[][] dp = new long[n + 1][p + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= p; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][p]);
    }

}
