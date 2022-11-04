class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int firstMax[] = new int[nums.length];
        int secondMax[] = new int[nums.length];
        
        int res = 0;
        
        int temp1 = 0, temp2 = 0;
        for(int i = 0; i < firstLen; i++){
            temp1 += nums[i];
        }
        for(int i = 0; i < secondLen; i++){
            temp2 += nums[i];
        }
        
        firstMax[firstLen - 1] = temp1;
        secondMax[secondLen - 1] = temp2;
        
        for(int i = firstLen; i < nums.length; i++){
            firstMax[i] = firstMax[i - 1] + nums[i] - nums[i - firstLen];
        }        

        
        for(int i = secondLen; i < nums.length; i++){
            secondMax[i] = secondMax[i - 1] + nums[i] - nums[i - secondLen];
        }
        
        for(int i = 0; i < nums.length - secondLen; i++){
            for(int j = i + secondLen; j < nums.length; j++){
                res = Math.max(res, firstMax[i] + secondMax[j]);
            }
        }
        
        for(int i = 0; i < nums.length - firstLen; i++){
            for(int j = i + firstLen; j < nums.length; j++){
                res = Math.max(res, secondMax[i] + firstMax[j]);
            }
        }
        
        return res;
    }
}