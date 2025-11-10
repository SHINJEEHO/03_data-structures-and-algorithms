package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class F_FindTreeParent {

    static int N;                       // 노드의 갯수
    static List<Integer>[] list;        // 연결 노드 저장 배열(최소 그래프이므로 리스트를 사용)
    static int[] parent;                // 최종 결과 저장 배열
    static boolean[] visited;           // 방문 결과 저장 배열

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++){
            list[i] = new ArrayList<>();
        }

        /* N - 1개 줄의 입력 처리 */
        StringTokenizer st;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

//        System.out.println(Arrays.toString(list));
//        dfs(1);
        bfs(1);
        /*
        * 트리 탐색이 완료 된 이후에는 parent배열에 부모 노드 값이 담겨 있으므로
        * 합쳐서 문자열로 만들고 반환
        * */
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append(" ");
        }

        return sb.toString();
    }

    private static void bfs(int root) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int parentNode = queue.poll();

            /* 연결된 노드를 반복 */
            for(int childNode : list[parentNode]){
                if(!visited[childNode]){
                    visited[childNode] = true;
                    parent[childNode] = parentNode; // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다.
                    queue.offer(childNode);
                }
            }
        }



    }

    private static void dfs(int parentNode) {
        visited[parentNode] = true;

        /* 연결 된 노드를 반복 */
        for(int childrenNode : list[parentNode]){
            if(!visited[childrenNode]){
                // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담든다.
                parent[childrenNode] = parentNode;

                // 그 자식 노드를 부모로 하는 자식 노드를 탐색한다.
                dfs(childrenNode);
            }
        }
    }

}
