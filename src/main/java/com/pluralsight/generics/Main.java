package com.pluralsight.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("b");

        String string1 = list.get(0);
        System.out.println(string1);
    }
}
