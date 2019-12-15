package com.bushemi;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.toList;

public class Main {
    private static final int TOTAL_TRIES = 5000000;
    private static final int LIST_SIZE = 10000;
    private static int counter = 0;
    private static long sum;

    public static void main(String[] args) {

        final List<Integer> list = Stream.generate(() -> counter++)
                .limit(LIST_SIZE)
                .collect(toList());

        List<Integer> order = asList(1, 2, 3, 4, 5, 6);
        shuffle(order);

        measureForCasesInOrder(list, order);
    }

    private static void measureForCasesInOrder(List<Integer> list, List<Integer> order) {
        order.forEach((n) -> {
            switch (n) {
                case 1:
                    measureForI(list);
                    break;
                case 2:
                    measureForE(list);
                    break;
                case 3:
                    measureForEach(list);
                    break;
                case 4:
                    measureForIterator(list);
                    break;
                case 5:
                    measureForEachWithStream(list);
                    break;
                case 6:
                    measureForEachWithParallelStream(list);
                    break;
            }
        });
    }

    private static void measureForEachWithParallelStream(List<Integer> list) {
        long start;
        long finish;
        start = System.nanoTime();
        for (int i = 0; i < TOTAL_TRIES; i++) {
            forEachWithParallelStream(list);
        }
        finish = System.nanoTime();
        System.out.println("for each with Parallel Stream = (finish-start)/TOTAL_TRIES = " + ((finish - start) / TOTAL_TRIES));
    }

    private static void measureForEachWithStream(List<Integer> list) {
        long start;
        long finish;
        start = System.nanoTime();
        for (int i = 0; i < TOTAL_TRIES; i++) {
            forEachWithStream(list);
        }
        finish = System.nanoTime();
        System.out.println("for each with Stream = (finish-start)/TOTAL_TRIES = " + ((finish - start) / TOTAL_TRIES));
    }

    private static void measureForIterator(List<Integer> list) {
        long start;
        long finish;
        start = System.nanoTime();
        for (int i = 0; i < TOTAL_TRIES; i++) {
            forIterator(list);
        }
        finish = System.nanoTime();
        System.out.println("for Iterator = (finish-start)/TOTAL_TRIES = " + ((finish - start) / TOTAL_TRIES));
    }

    private static void measureForEach(List<Integer> list) {
        long start;
        long finish;
        start = System.nanoTime();
        for (int i = 0; i < TOTAL_TRIES; i++) {
            forEach(list);
        }
        finish = System.nanoTime();
        System.out.println("for Each = (finish-start)/TOTAL_TRIES = " + ((finish - start) / TOTAL_TRIES));
    }

    private static void measureForE(List<Integer> list) {
        long start;
        long finish;
        start = System.nanoTime();
        for (int i = 0; i < TOTAL_TRIES; i++) {
            forE(list);
        }
        finish = System.nanoTime();
        System.out.println("for E = (finish-start)/TOTAL_TRIES = " + ((finish - start) / TOTAL_TRIES));
    }

    private static void measureForI(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < TOTAL_TRIES; i++) {
            fori(list);
        }
        long finish = System.nanoTime();
        System.out.println("for i = (finish-start)/TOTAL_TRIES = " + ((finish - start) / TOTAL_TRIES));
    }


    private static void fori(List<Integer> list) {
        sum = 0L;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
    }

    private static void forE(List<Integer> list) {
        sum = 0L;
        for (Integer integer : list) {
            sum += integer;
        }
    }

    private static void forEach(List<Integer> list) {
        sum = 0L;
        list.forEach((n) -> sum += n);
    }

    private static void forIterator(List<Integer> list) {
        sum = 0L;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
    }

    private static void forEachWithStream(List<Integer> list) {
        sum = 0L;
        list.stream().forEach((n) -> sum += n);
    }

    private static void forEachWithParallelStream(List<Integer> list) {
        sum = 0L;
        list.parallelStream().forEach((n) -> sum += n);
    }

}
