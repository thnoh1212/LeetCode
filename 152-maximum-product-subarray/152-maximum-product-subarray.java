class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            res = Math.max(res, temp);
            for(int j = i + 1; j < nums.length; j++){
                temp *= nums[j];
                res = Math.max(res, temp);
                if(temp == 0) break;
            }
        }
        
        return res;
    }
}