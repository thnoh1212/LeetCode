class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums.length < 3) return 0;
        
        int sumArray[] = new int[5001];
        int res = 0;
        
        for(int i = 1; i < 5001; i++){
            sumArray[i] = sumArray[i-1] + i;
        }
        
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        boolean flag = nums[0] <= nums[1] ? true : false;
        int sub = nums[1] - nums[0];
        for(int i = 1; i < nums.length; i++){
            if(flag){
                if((nums[i] - nums[i-1]) == sub){
                    cnt += 1;
                }
                else{
                    if(cnt >= 3) list.add(cnt);
                    cnt = 2;
                    if(i != nums.length - 1) flag = nums[i] <= nums[i+1] ? true : false;
                    sub = nums[i] - nums[i-1];
                }
            }
            else{
                if((nums[i] - nums[i-1]) == sub){
                    cnt += 1;
                }
                else{
                    if(cnt >= 3) list.add(cnt);
                    cnt = 2;
                    if(i != nums.length - 1) flag = nums[i] <= nums[i+1] ? true : false;
                    sub = nums[i] - nums[i-1];
                }
            }
            
        }
        if(cnt >= 3) list.add(cnt);
        
        
        for(int i = 0; i < list.size(); i++){
            res += sumArray[list.get(i) - 2];
        }
        
        return res;
    }
}