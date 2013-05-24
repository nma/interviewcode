package sorting;

import java.util.*;
//You have two arrays with N integers in them. Merge those arrays using a recursive algorithm so that the integers in the final array are sorted. 
class MergeSort {
    
    public class IndexMergeSort {
    
    }

    public class ReferenceMergeSort {
        void MergeSort(int[] A) {
            if (A.length > 1) {
                int middle = A.length /2; // floor by default

                int[] left = Arrays.copyOfRange(A,0,middle);
                int[] right = Arrays.copyOfRange(A,middle,A.length);

                Merge(A, left, right);
            }
        }

        void Merge(int[] A, int[] left, int[] right) {

            int l = 0;
            int r = 0;
            int A_iter = 0;

            while ( l < left.length  && r < right.length) {
                if (left[l] <= right[r]) {
                    A[A_iter] = left[l];
                    l++;
                } else {
                    A[A_iter] = right[r];
                    r++;
                }
                A_iter++;
            }

            while( l < left.length) { 
                A[A_iter] = left[l];
                A_iter++;
                l++;
            }

            while( r < right.length ) {
                A[A_iter] = right[r];
                A_iter++;
                r++;
            }
        }

    }
    public class TraditionalMergeSort {
        int[] MergeSort(int[] A) {
            if (A.length > 1) {
                int middle = A.length /2; // floor by default

                int[] left = Arrays.copyOfRange(A,0,middle);
                int[] right = Arrays.copyOfRange(A,middle,A.length);

                int[] leftR = MergeSort(left);
                int[] rightR = MergeSort(right);

                return Merge(leftR, rightR);
            }
            return A;
        }

        int[] Merge(int[] left, int[] right) {

            int[] result = new int[left.length+right.length];
            int l = 0;
            int r = 0;
            int A_iter = 0;

            while ( l < left.length  && r < right.length) {
                if (left[l] <= right[r]) {
                    result[A_iter] = left[l];
                    l++;
                } else {
                    result[A_iter] = right[r];
                    r++;
                }
                A_iter++;
            }

            while( l < left.length) { 
                result[A_iter] = left[l];
                A_iter++;
                l++;
            }

            while( r < right.length ) {
                result[A_iter] = right[r];
                A_iter++;
                r++;
            }
            return result;
        }

    }

    static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (int num : list) {
            ret[i++] = num;
        }
        return ret;
    }

    int[] MergeAndSort(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length+arr2.length];
        int idx = 0; 
        for (int i = 0; i < arr1.length; i++) 
            merged[idx++] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            merged[idx++] = arr2[i];

        //TraditionalMergeSort tms = new TraditionalMergeSort();
        //return tms.MergeSort(merged);
        
        ReferenceMergeSort rms = new ReferenceMergeSort();
        rms.MergeSort(merged);
        return merged;
    }

    // performance test
    private static final long MEGABYTE = 1024L * 1024L;
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
    public static void main(String[] args) {

        // quick test
        int[] test_arr1 ={9,8,7,6,5,4,3,2,1};
        int[] test_arr2 = {11,15,16,10,13,14,12};

        //int[] test_arr1 = {3,2,1};
        //int[] test_arr2 = {6,4,5};  

        MergeSort sorting = new MergeSort();

        int[] finalArr = sorting.MergeAndSort(test_arr1,test_arr2);

        for (int i : finalArr) {
            System.out.println(i);
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "+ bytesToMegabytes(memory));
    }
}
