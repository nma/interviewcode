package arrays;
// Equilibrium Index.
// Find Index where upper and lower are the same sum.

import java.util.*;

class EquilibriumIndex {

    static int myEqIndex(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++)
            sum += input[i];
        
        int left = 0;
        int right = sum - input[0];

        for (int i = 1; i < input.length; i++) {
            if (left == right) {
                return i;
            }

            left += input[i-1];
            right -= input[i]; 
        }

        return -1;
    }

    public static void main(String args[]){
        int[] input = {2,3,4,5};
        
        int index = myEqIndex(input);
        System.out.println(index);
    }
}
