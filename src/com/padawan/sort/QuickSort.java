package com.padawan.sort;

import java.util.List;


public class QuickSort implements Sort<Integer> {

    public void sort(Integer[] array) {
        quickSort(array, 0, array.length-1);
    }

    private void quickSort(Integer[] array, int low, int high){
        if(array == null || array.length == 0) return;

        if(low >= high) return;

        int middle = low + (high-low)/2;
        Integer pivot = array[middle];

        int i = low, j = high;

        while (i <= j){
            while(array[i] < pivot){
                i++;
            }
            while(array[j] > pivot){
                j--;
            }

            if(i<=j){
                Integer temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if(low < j){
            quickSort(array, low, j);
        }
        if(high > i){
            quickSort(array, i, high);
        }

    }
}
