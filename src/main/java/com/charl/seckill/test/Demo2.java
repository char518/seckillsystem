package com.charl.seckill.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-05 15:30
 **/
public class Demo2 {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            return task1("helloworld,ur beautiful");
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            return task1("super hero!!");
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(task1, task2);

        try {
            String s = task1.get();
            String s1 = task2.get();

            System.out.println("结果："+s+",s1:"+s1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("spend time:"+(System.currentTimeMillis() - l));

    }

    public static String task1(String str) {
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str.toUpperCase();
    }

}
