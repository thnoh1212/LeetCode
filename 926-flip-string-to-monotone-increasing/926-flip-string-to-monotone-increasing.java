class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCnt = 0, flipCnt = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                oneCnt += 1;
            }
            else{
                if(oneCnt >= 1){
                    flipCnt += 1;
                }
            }
            flipCnt = Math.min(oneCnt, flipCnt);
        }
        return flipCnt;
    }
}