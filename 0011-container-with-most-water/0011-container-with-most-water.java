class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        
        int frontIdx = 0;
        int backIdx = height.length - 1;
        
        while(backIdx - frontIdx > 0){
            res = Math.max(res, Math.min(height[frontIdx], height[backIdx]) * (backIdx - frontIdx));
            
            int temp = height[frontIdx] > height[backIdx] ? backIdx-- : frontIdx++;
        }
        
        return res;
    }
}