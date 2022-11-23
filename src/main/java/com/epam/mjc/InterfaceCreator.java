package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                char[] array = str.toCharArray();
                if (!Character.isUpperCase(array[0])) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> res = new ArrayList<>();
            for (int item : x) {
                if (item % 2 == 0) {
                    res.add(item);
                }
            }
            x.addAll(res);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>(values);
            for (String item : values) {
                if (item.charAt(item.length() - 1) != '.') {
                    res.remove(item);
                }
                char[] chars = item.toCharArray();
                if (!Character.isUpperCase(chars[0])) {
                    res.remove(item);
                }
                int numberOfSpaces = 0;
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == ' ') {
                        numberOfSpaces++;
                    }
                }
                if (numberOfSpaces < 3) {
                    res.remove(item);
                }
            }
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String item:x){
                result.put(item, item.length());
            }
            return result;};
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> res = new ArrayList<>();
            res.addAll(list1);
            res.addAll(list2);
            return res;
        };
    }
}
