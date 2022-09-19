package com.example.demo;

import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LambokDemo {

    public static void main(String[] args) {
//method 1
        //正常方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }).start();

        //Lambok表达式
        new Thread(()->{
            System.out.println("test");
        }).start();

        //简化
        new Thread(()->System.out.println("test")).start();
//method 2
        //匿名
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(i);

        //lambda
        int j = calculateNum((a, b) -> a + b);
        System.out.println(j);

//method 3

        //普通
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });

        //lambda
        printNum(value -> value % 2 == 0);

//method 4
        //普通
        Integer num = typeConvert(new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        System.out.println(num);
        //lambda
        Integer num2 = typeConvert(s -> Integer.parseInt(s));
        System.out.println(num2);
        //lambda简化
        Integer num3 = typeConvert(Integer::parseInt);
        System.out.println(num3);

//method 5
        //普通方法
        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        });

        //lambda
        foreachArr(value -> System.out.print(value));

        //简化lambda
        foreachArr(System.out::print);


    }
    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        for (int i : arr) {
            consumer.accept(i);
        }
    }

    public static <R> R typeConvert(Function<String, R> function) {
        String str = "1235";
        return function.apply(str);
    }
    interface Function<T,R>{
        R apply(T t);
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }


}
