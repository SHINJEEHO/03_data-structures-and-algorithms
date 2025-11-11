package com.ohgiraffers.section03.greedy;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
* 최소 신장 트리
* 프림 알고리즘(Priority Queue 방식)
* 시작 정점에서 시작하여, 최소 가중치 간선을 추가하면서 최소 스패닝 트리를 확장하는 방법
* 우선순위 큐를 사용하여 가장 적은 가중치의 간선을 효율적으로 선택
* */
public class G_PrimAlgorithm {


    static class Edge{
            int vertex, weight;
            Edge(int vertex, int weight){
                this.vertex = vertex;
                this.weight = weight;
            }
        }

    public static Long solution(String input) {
        return 0l;
    }



}
