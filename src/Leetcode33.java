public class Leetcode33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 6));
    }

    public static int search(int[] nums, int target) {

        return searchTarget(nums,0,nums.length,target);

    }

    public static int searchTarget(int[] arr, int start, int end, int target){

        if(start == end-1){
            if(arr[start] == target)
                return start;
            return -1;
        }
        int mid = (end+start)/2;

        if(arr[mid] == target)
            return mid;

        if(arr[start] <= arr[mid-1]){
            if(target == arr[start])
                return start;
            if(target == arr[mid-1])
                return mid-1;
            if(target < arr[start])
                return searchTarget(arr,mid,end,target);
            if(target < arr[mid-1])
                return searchTarget(arr,start,mid,target);
            return searchTarget(arr,mid,end,target);
        }
        else if (arr[mid] <= arr[end-1]){
            if(target == arr[mid])
                return mid;
            if(target == arr[end-1])
                return end-1;
            if(target < arr[mid])
                return searchTarget(arr,start,mid,target);
            if(target < arr[end-1])
                return searchTarget(arr,mid,end,target);
            return searchTarget(arr,start,mid,target);
        }

        return -1;
    }
}
