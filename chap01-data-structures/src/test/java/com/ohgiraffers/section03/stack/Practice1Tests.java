package com.ohgiraffers.section03.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/* 괄호 - 백준(9012) */
class Practice1Tests {

    Practice1 practice1;

    @BeforeEach
    void setUp(){
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideTestCases(){
        return Stream.of(
                Arguments.arguments("(())())", "NO"),
                Arguments.arguments("(((()())()", "NO"),
                Arguments.arguments("(()())((()))", "YES"),
                Arguments.arguments("((()()(()))(((())))()", "NO"),
                Arguments.arguments("()()()()(()()())()", "YES"),
                Arguments.arguments("(()((())()(", "NO")
        );
    }

    @DisplayName("올바른 괄호 문자열 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")  // 위의 메소드명을 복사 붙여넣기
    void testParentesisString(String input, String expected){
        String result = practice1.solution(input);
        Assertions.assertEquals(expected, result);
    }






}