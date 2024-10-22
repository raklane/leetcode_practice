public class Leetcode35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {

        return searchIndex(nums, 0, nums.length, target);

    }

    public static int searchIndex(int[] nums, int start, int end, int target){

        int mid = (start+end)/2;

        if(target<nums[start])
            return start;
        if(target>nums[end-1])
            return end;
        if(nums[start] == target)
            return start;
        if(nums[mid-1] == target)
            return mid-1;
        if(nums[mid] == target)
            return mid;
        if(nums[mid-1]>target)
            return searchIndex(nums,start,mid,target);
        if (nums[mid] < target && nums[end-1] >= target)
            return searchIndex(nums,mid,end,target);
        if(nums[mid-1] < target)
            return mid;
        return -1;
    }
}
