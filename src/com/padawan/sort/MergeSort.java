package com.padawan.sort;

/**
 * Created by padawan on 5/11/17.
 */
public class MergeSort implements Sort<Integer> {

    public void sort(Integer[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(Integer[] array, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    private void merge(Integer[] array, int low, int middle, int high) {
        Integer[] temp = array.clone();

        int i = low, j = middle+1, k = low;

        while (i <= middle && j <= high) {
            if (temp[i] < temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle){
            array[k] = temp[i];
            i++;
            k++;
        }

    }
}


