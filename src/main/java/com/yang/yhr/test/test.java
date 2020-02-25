package com.yang.yhr.test;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: yhr
 * @description: test
 * @packagename: com.yang.yhr.test
 * @author: yangyu
 * @date: 2020-02-23 10:38
 **/
public class test {
    static List<String[]> eggs = new ArrayList<>();
    // 自增生成组编号
    static int group = 1;
    // 自增生成学生编号
    static int student = 1;

    public static void main(String[] args) {
        // 第一箱鸡蛋
        eggs.add(new String[]{"鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1"});
        // 第二箱鸡蛋
        eggs.add(new String[]{"鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2"});


        map();
        flatMap();
    }


    /**
     * 把二箱鸡蛋分别加工成煎蛋，还是放在原来的两箱，分给2组学生
     */
    public static void map() {
        eggs.stream()
                .map(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("组" + group++ + ":" + Arrays.toString(x.toArray())));
    }

    /**
     * 把二箱鸡蛋分别加工成煎蛋，然后放到一起【10个煎蛋】，分给10个学生
     */
    public static void flatMap() {
        eggs.stream()
                .flatMap(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("学生" + student++ + ":" + x));
    }

}
