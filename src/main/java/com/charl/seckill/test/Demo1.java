package com.charl.seckill.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-04 14:05
 **/
public class Demo1 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList ("hello", "nihao", "linjunjie", "sdfads", "1231");
        System.out.println ("begin");
        List<CompletableFuture<String>> collect = strings.stream ().map (v -> CompletableFuture.supplyAsync (() -> {
            return handle (v);
        })).collect (Collectors.toList ());

        CompletableFuture[] completableFutures = new CompletableFuture[collect.size ()];
        int i = 0;
        for (CompletableFuture<String> stringCompletableFuture : collect) {
            stringCompletableFuture.handle ((v, e) -> {
                System.out.println ("v is :====" + v);
                System.out.println ("e is :====" + e);
                return "hello";
            });

            completableFutures[i] = stringCompletableFuture;
            i++;
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf (completableFutures);

        System.out.println ("completableFuture:+++++" + completableFuture);

        try {
            Thread.sleep (5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public static String handle(String str) {
        try {
            Thread.sleep (1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        if(str.length () == 5) {
            int i = 1/0;
        }
        System.out.println ("执行啦:" + str);
        return str.toUpperCase ();
    }

}
