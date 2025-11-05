package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Application {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 요소 조회
        System.out.println(stack.peek());

        // 요소 제거
        System.out.println(stack.pop());

        // 스택 비어있는지 확인
        System.out.println(stack.isEmpty());
    }
}
