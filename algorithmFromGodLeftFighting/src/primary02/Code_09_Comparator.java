package primary02;

import java.util.*;

/**
 * @Author: Tommy
 * @DATE: 2022/2/3
 */
public class Code_09_Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student (String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public static class IdAscendingComparator implements Comparator<Student> {

            @Override
            public int compare(Student o1, Student o2) {
                // 如果返回负数， 则第一个参数应该放在前面
                // 如果返回正数， 则第二个参数应该放在前面
                // 如果返回0， 则 两个对象一样大
                return o1.id - o2.id;
            }

        }

        public static class IdDescendingComparator implements Comparator<Student> {

            @Override
            public int compare(Student o1, Student o2) {
                return o2.id - o1.id;
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o){return true;}
            if (o == null || getClass() != o.getClass()){ return false; }
            Student student = (Student) o;
            return id == student.id && age == student.age && name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, age);
        }

        public static void main(String[] args) {
            PriorityQueue<Student> heap = new PriorityQueue<>(new Student.IdAscendingComparator());
            //红黑树
            TreeSet<Student> treeSet = new TreeSet(new Student.IdAscendingComparator());
        }

    }



}
