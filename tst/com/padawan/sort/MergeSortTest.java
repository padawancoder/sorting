package com.padawan.sort;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by padawan on 5/14/17.
 */
class MergeSortTest {
    @Ignore
    public abstract static class TestContextBase {
        @InjectMocks
        MergeSort mergeSort;

        protected Integer[] result;
        protected Integer[] numbers;
        protected final static int SIZE = 7;
        protected final static int MAX = 20;

        @Before
        public void becauseOf() throws Exception {
            numbers = new Integer[SIZE];
            Random generator = new Random();
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = generator.nextInt(MAX);
            }

            MockitoAnnotations.initMocks(this);
            result = getResponse();
        }

        protected abstract Integer[] getResponse() throws Exception;

    }

    public static class When_I_do_a_sort extends TestContextBase {
        @Override
        protected Integer[] getResponse() throws Exception {
            //Execute
            mergeSort.sort(numbers);

            return numbers;
        }

        @Test
        public void it_should_respond_with_sorted_list() {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }
    }
}