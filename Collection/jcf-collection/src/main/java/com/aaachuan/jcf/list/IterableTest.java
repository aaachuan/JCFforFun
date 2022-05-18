package com.aaachuan.jcf.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IterableTest {
    public static <T> void forEaches(List<T> list, Consumer<T> c) {
        for (T i: list) {
            c.accept(i);
        }
    }

    public static void main(String[] args) {
        forEaches(
                Arrays.asList(1,2,3,4,5),
                (Integer i) -> System.out.print(i+" ")
        );
        System.out.println();
        /**
         * ArrayList中出现`transient Object[] elementData;`原因：
         * ArrayList本身实现java.io.Serializable接口，elementData为缓存数组，可动态扩容，
         * 序列化时writeObject和readObject获取size和element，保证序列化时只序列化实际存储的元素。
         */
        Lists.newArrayList("v1","v2","v3","v4").forEach(
                item -> {
                    System.out.print(item+" ");
                }
        );
        System.out.println();

        /**
         * public ArrayList(Collection<? extends E> c)
         * // c.toArray might (incorrectly) not return Object[] (see 6260652)
         */
        System.out.println(Arrays.asList("v1","v2","v3").toArray().getClass()==Object[].class);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.stream().forEach(i -> {
            System.out.println(i);
        });
    }
}
