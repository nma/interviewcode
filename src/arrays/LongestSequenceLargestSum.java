package arrays;

import java.util.*;

class LongestSequenceLargestSum {
	
	// O{N^2} bad bad bad. Need to do it again and make it O(n)
    static int[] myGetSubsequence(int[] input) {
        int largest_sum = 0;
        int seq_length = 0;
        int start_idx = 0;
        
        for ( int i = 0; i < input.length; i++ ) {
            int sum = 0;
            int cur_length = 0;
            
            for ( int j = i; j < input.length; j++ ) {
                sum += input[j];
                cur_length = j - i + 1;
                if ((sum > largest_sum) || (sum == largest_sum && seq_length < cur_length)) {
                    start_idx = i;
                    largest_sum = sum;
                    seq_length = cur_length;
                } 
            }
        }
        
        return Arrays.copyOfRange(input, start_idx, start_idx+seq_length);
    }

    public static void main(String args[]) {
        int[] input = {1,2,3,-2,5,-1,-100};

        int[] response = myGetSubsequence(input);
        for ( int i = 0; i < response.length; i++ ) {
            System.out.println(response[i]);
        }
    }
}
