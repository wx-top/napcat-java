package icu.wenxin.napcat.utils;

import java.util.List;

public class ListUtils {

    public static <T> void addIfNotNull(List<T> list, T element) {
        if (element != null) {
            list.add(element);
        }
    }

    public static <T> void addToHeadIfNotNull(List<T> list, T element) {
        list.add(0, element);
    }
}
