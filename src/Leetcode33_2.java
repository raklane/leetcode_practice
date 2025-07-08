public class Leetcode33_2 {

    public int search(int[] nums, int target) {

        int mid = (0+ nums.length)/2;

        return 0;

    }

    public boolean searchInDividedArray(int[] nums, int start, int end, int mid, int target){

        return false;
    }

}


/*
1   2   3   4   5   6   7

6   7   1   2   3   4   5
i           m           r
i   m   r
    i   r



1   2
i   r
m

i>mid and i>target and mid < target     right
i>mid and i<target and mid < target     left
i>mid and i>target and mid > target     right
 */
