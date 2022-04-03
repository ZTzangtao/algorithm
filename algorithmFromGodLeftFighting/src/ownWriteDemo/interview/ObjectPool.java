package ownWriteDemo.interview;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 *
 *
 * @Author: Tommy
 * @DATE: 2022/3/27
 */
public class ObjectPool<T> {
    // 定义对象池存储可供使用的对象

    private Class<T> clazz;

    private Queue<T> queue = new ArrayDeque<>();

    public ObjectPool(Class<T> clazz, int size) {
        // 初始化对象池，填入对象
        for (int i = 0; i < size; i++) {
            try {
                T newInstance = clazz.getDeclaredConstructor().newInstance();
                queue.add(newInstance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.clazz = clazz;

    }

    public T get() {
        // 从对象池里取出一个对象，注意:不允许返回null
        if (queue.size() == 0) {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();

    }

    public void recycle(T obj) {
        // 当对象可以回收时，通过调用该方法把对象放回对象池
        if(obj == null){
            throw new NullPointerException();
        }
        queue.add(obj);
    }
}
