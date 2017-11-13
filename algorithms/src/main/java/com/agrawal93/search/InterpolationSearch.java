package com.agrawal93.search;

import java.util.List;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class InterpolationSearch {
    
    public static <T extends Number> T search(T[] array, T value) {
        int low = 0;
        int high = array.length - 1;
        while(low <= high && array[low].doubleValue() <= value.doubleValue() && value.doubleValue() <= array[high].doubleValue()) {
            int position = low + (int)(( (high - low) / (array[high].doubleValue() - array[low].doubleValue()) ) * (value.doubleValue() - array[low].doubleValue()));
            if(array[position].doubleValue() == value.doubleValue()) return array[position];
            if(array[position].doubleValue() < value.doubleValue()) low = position + 1;
            else high = position - 1;
        }
        return null;
    }

    public static <T extends Number> T search(List<T> list, T value) {
        int low = 0;
        int high = list.size() - 1;
        while(low <= high && list.get(low).doubleValue() <= value.doubleValue() && value.doubleValue() <= list.get(high).doubleValue()) {
            double lowValue = list.get(low).doubleValue();
            double highValue = list.get(high).doubleValue();
            
            int position = low + (int)(( (high-low) / (highValue - lowValue) ) * (value.doubleValue()-lowValue));
            
            T positionValue = list.get(position);
            if(positionValue.doubleValue() == value.doubleValue()) return positionValue;
            if(positionValue.doubleValue() < value.doubleValue()) low = position + 1;
            else high = position - 1;
        }
        return null;
    }
    
}
