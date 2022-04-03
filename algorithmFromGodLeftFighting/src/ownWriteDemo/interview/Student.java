package ownWriteDemo.interview;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Tommy
 * @DATE: 2022/3/27
 */
public class Student {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pop();
        stack.push(1);

        Queue queue = new ArrayDeque();
        queue.poll();
        queue.add(1);
    }


}
