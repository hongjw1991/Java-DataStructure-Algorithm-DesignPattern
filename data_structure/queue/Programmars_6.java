package com.data_structure.queue;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        String[] operations = {"I 16", "D 1"};
        int[] answer = s.solution(operations);

        for(int a : answer){
            System.out.print(a + ", ");
        }
        System.out.println();

        operations = new String[]{"I 7", "I 5", "I -5", "D -1"};
        answer = s.solution(operations);
        for(int a : answer){
            System.out.print(a + ", ");
        }
        System.out.println();


        operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        answer = s.solution(operations);
        for(int a : answer){
            System.out.print(a + ", ");
        }


    }
    public int[] solution(String[] operations){
        LinkedList<Integer> linkedList = new LinkedList<>();

        StringTokenizer st;
        for(String op : operations){
            st = new StringTokenizer(op);
            if(st.nextToken().equals("I")){
                linkedList.offer(Integer.parseInt(st.nextToken()));
            } else {
                if(linkedList.isEmpty()){
                    continue;
                }
                int num = Integer.parseInt(st.nextToken());
                if(num == -1){
                    linkedList.pollLast();
                } else {
                    linkedList.pollFirst();
                }
            }
            Collections.sort(linkedList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
        int[] answer = new int[2];
        if(linkedList.isEmpty()){
            return answer;
        } else {
            answer[0] = linkedList.pollFirst();
            answer[1] = linkedList.pollLast();
        }
        return answer;
    }

}
