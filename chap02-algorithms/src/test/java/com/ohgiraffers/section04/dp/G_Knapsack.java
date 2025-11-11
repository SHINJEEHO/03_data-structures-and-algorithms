package com.ohgiraffers.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class G_Knapsack {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 물건의 개수
        int k = Integer.parseInt(st.nextToken());   // 가방 무게

        int[][] dp = new int[n + 1][k + 1];         // dp[물건인덱스][무게] = 최적 가치값

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());       // 현재 물건의 무게
            int v = Integer.parseInt(st.nextToken());       // 현재 물건의 가치

            // 각 물건에 대한 dp 배열의 행의 값을 채워 나가는 작업
            // 가방의 키로수까지 반복
            for(int j = 1; j <= k; j++) {
                // 물건이 가방에 들어갈 수 있는지 확인
                if(j < w) {
                    // 1. 들어갈 수 없다면? 가치값의 변화가 없으므로 이전 행의 값을 그대로 반영
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 2. 들어갈 수 있다면?
                    // 담는다 : 물건 가치 + 해당 무게 빼고 남는 가치
                    // 안 담는다 : 이전 행의 값 -> 두 가지를 비교해서 높은 값을 반영
                    dp[i][j] = Math.max(v + dp[i-1][j-w], dp[i-1][j]);
                }
            }
        }

        return dp[n][k];
    }

}
