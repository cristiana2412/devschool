package com.ing.tech;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char c1 = 'a';

        Character c = c1;

        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);

        long sum1 = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum1 += i;
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);


        Integer i1 = 1;
        int i2 = i1;

        int[] anArray = new int[5];
        anArray[0] = 1;
        anArray[1] = 2;
        anArray[2] = 3;
        anArray[3] = 4;
        anArray[4] = 5;

        for (int i : anArray) {
            System.out.println(i);
        }

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Iterator<Integer> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    static class ArrayWrapper implements Iterator {
        private int[] array = {1,2,3,4,5};
        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            return currentPosition < array.length;
        }

        @Override
        public Object next() {
            return array[currentPosition++];
        }
    }
}
