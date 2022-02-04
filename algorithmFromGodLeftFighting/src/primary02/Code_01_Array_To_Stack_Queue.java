package primary02;

/**
 * 用数组实现栈、队列
 *
 * @Author: Tommy
 * @DATE: 2022/2/4
 */
public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack{
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        public Integer peek() {
            if(index == 0){
                return null;
            }
            return arr[index - 1];
        }

        public void push(int obj){
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[index++] = obj;
        }

        public Integer pop(){
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--index];
        }
    }

    public static class ArrayQueue{

    }

}
