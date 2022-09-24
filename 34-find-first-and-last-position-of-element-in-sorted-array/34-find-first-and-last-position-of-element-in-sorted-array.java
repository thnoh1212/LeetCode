class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx[] = {-1, -1};
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                idx[0] = i;
                break;
            }
        }
        if(idx[0] == -1){
            return idx;
        }
        
        for(int i = idx[0] + 1; i < nums.length; i++){
            if(nums[i] != target){
                idx[1] = i - 1;
                break;
            }
        }
        if(idx[1] == -1){
            idx[1] = nums.length - 1;
        }
        
        return idx;
    }
}