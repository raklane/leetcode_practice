public class Leetcode34 {

    public static void main(String[] args) {
        int[] result = searchRange(new int[]{},0);
        for(int r : result){
            System.out.print(r + "\t");
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length==0)
            return new int[]{-1,-1};

        return new int[]{searchStart(nums,0,nums.length,target,-1),searchEnd(nums,0,nums.length,target,-1)};

    }

    public static int searchStart(int[] arr, int start, int end, int target, int foundIndex){

        if(start<=end){
            if(arr[start] == target)
                return start;
            return foundIndex;
        }
        int mid = (start+end)/2;
        if(arr[mid-1] >= target){
            if(arr[mid-1] == target)
                foundIndex = foundIndex == -1 ? mid : Math.min(foundIndex,mid-1);
            return searchStart(arr,start,mid,target,foundIndex);
        }
        if(arr[mid] <= target){
            if(arr[mid] == target)
                foundIndex = foundIndex == -1 ? mid : Math.min(foundIndex,mid);
            return searchStart(arr,mid,end,target,foundIndex);
        }
        return -1;

    }

    public static int searchEnd(int[] arr, int start, int end, int target, int foundIndex){

        if(start<=end){
            if(arr[start] == target)
                return start;
            return foundIndex;
        }
        int mid = (start+end)/2;
        if(arr[mid] <= target){
            if(arr[mid] == target)
                foundIndex = foundIndex == -1 ? mid : Math.max(foundIndex,mid);
            return searchEnd(arr,mid,end,target,foundIndex);
        }
        if(arr[mid-1] >= target){
            if(arr[mid-1] == target)
                foundIndex = foundIndex == -1 ? mid-1 : Math.max(foundIndex,mid-1);
            return searchEnd(arr,start,mid,target,foundIndex);
        }

        return -1;

    }
}
