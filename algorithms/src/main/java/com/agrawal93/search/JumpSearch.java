package com.agrawal93.search;

import java.util.List;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class JumpSearch {

    public static <T extends Comparable> T search(T[] array, T value) {
        int skip = (int) Math.floor(Math.sqrt(array.length));
        int blockStart = 0;
        int blockEnd = skip;
        
        while(blockEnd < array.length && value.compareTo(array[blockEnd]) >= 0) {
            blockStart = blockEnd;
            blockEnd += skip;
        }
        
        if(blockEnd >= array.length) blockEnd = array.length - 1;
        
        while(blockStart <= blockEnd) {
            T currentValue = array[blockStart++];
            if(value.compareTo(currentValue) == 0) return currentValue;
        }
        return null;
    }

    public static <T extends Comparable> T search(List<T> list, T value) {
        int skip = (int) Math.floor(Math.sqrt(list.size()));
        int blockStart = 0;
        int blockEnd = skip;
        
        while(blockEnd < list.size() && value.compareTo(list.get(blockEnd)) >= 0) {
            blockStart = blockEnd;
            blockEnd += skip;
        }
        
        if(blockEnd >= list.size()) blockEnd = list.size() - 1;
        
        while(blockStart <= blockEnd) {
            T currentValue = list.get(blockStart++);
            if(value.compareTo(currentValue) == 0) return currentValue;
        }
        return null;
    }

}
