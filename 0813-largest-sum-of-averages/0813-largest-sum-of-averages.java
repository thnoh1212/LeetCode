class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        // 풀이참조
        
        double[][] dp = new double[k + 1][nums.length + 1];
        double[] sum = new double[nums.length + 1];
        
        // 우선 전체 sum값 및 나누지 않은 값 (dp[1]) 에 대한 값 갱신
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
            dp[1][i] = sum[i] / i;
        }
            
        
        for(int i = 2; i <= k; i++){
            for(int j = i; j <= nums.length; j++){
                for(int l = i - 1; l < j; l++){
                    dp[i][j] = Math.max(dp[i - 1][l] + (sum[j] - sum[l]) / (j - l), dp[i][j]);
                }
            }
        }
        
        return dp[k][nums.length];
        
    }
}