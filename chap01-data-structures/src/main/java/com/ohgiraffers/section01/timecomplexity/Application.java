package com.ohgiraffers.section01.timecomplexity;

import java.util.Arrays;

/* 시간 복잡도를 이해할 수 있다. */
public class Application {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 15, 4, 9, 10, 7};
        System.out.println(getFirst(arr));
        System.out.println(binarySearch(arr, 1));
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(fibonacci(7));
    }

    /* 상수 시간 O(1) */
    private static int getFirst(int[] arr) {
        return arr[0];
    }

    /* 로그 시간 O(log n)*/
    public static int binarySearch(int[] nums, int target) {

//        Arrays.sort(nums);

        /* 배열의 처음과 끝을 지정하는 인덱스를 담은 변수(포인터) */
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; //while문을 돌 때마다 범위가 ½씩 줄어 듦!
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /* 선형시간 O(n) */
    public static int[] reverse(int[] nums) {
        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversed[nums.length - i - 1] = nums[i];
        }
        return reversed;
    }

    /* 지수 시간 O(n^2) */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci (n - 1) + fibonacci (n - 2);
    }
}
