package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice1 {

    public String solution(String input){

        // (())()) : > 문자열 ()
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()){  // stack :       )))
            if(c == '('){
                // 여는 괄호인 경우 stack에 push
                stack.push(c);
            } else {
                // 스택이 비어서 괄호를 꺼낼 수 없다면 여는 괄호가 부족해서 짝이 안 맞는 상황
                if(stack.isEmpty()) return "NO";
                // 닫는 괄호인 경우 stack에서 pop
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";
        return "YES";
    }
}
