class Solution {
    
    static boolean findAnswer = false;
    static boolean[] visited;

    public boolean canJump(int[] nums) {
        findAnswer = false;
        visited = new boolean[10001];
        if(nums.length == 1) return true;
        dfs(nums, 0);
        return findAnswer;
    }
    
    public void dfs(int[] nums, int curIdx){
        int jumpLength = nums[curIdx];
        if(visited[curIdx] || jumpLength == 0) return;
        
        visited[curIdx] = true;
        if(findAnswer || curIdx + jumpLength >= nums.length - 1){
            findAnswer = true;
            return;
        }
        
        for(int i = 1; i <= jumpLength; i++){
            dfs(nums, curIdx + i);
        }
    }
}