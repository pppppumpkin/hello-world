package com.qunar.fresh;

import java.util.Comparator;

/**
 * Created by liyingsong on 16-5-16.
 */
public class NicknameMapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer key1, Integer key2) {
        return (key1 - key2);
    }
}
