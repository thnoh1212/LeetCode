class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int digitCount[] = new int[10];
        StringBuffer res = new StringBuffer();
        boolean haveZero = false;
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            digitCount[digits[i]]++;
            sum += digits[i];
            if(digits[i] == 0) haveZero = true;
        }
        if(sum < 3) return haveZero ? "0" : "";
        
        
        while(sum >= 3){
            if(sum % 3 == 0) break;
            
            // 1. mod연산
            int idx = sum % 3;
            
            // 2. 나머지와 일치하는 숫자를 가장 작은 수부터 탐색
            for(int i = idx; i < 10; i += 3){
                if(digitCount[i] != 0){
                    sum -= i;
                    digitCount[i] -= 1;
                    break;
                }
            }
            if(sum % 3 == 0) break;
            
            // 3. 2에서 탈출하지 못한경우
            idx = 3 ^ idx;
            for(int i = idx; i < 10; i += 3){
                if(digitCount[i] != 0){
                    sum -= i;
                    digitCount[i] -= 1;
                    break;
                }
            }
        }
        if(sum < 3) return haveZero ? "0" : "";
        
        int idx = 9;
        while(idx != -1){
            if(digitCount[idx] != 0){
                res.append(String.valueOf(idx));
                digitCount[idx]--;
            }
            else{
                idx -= 1;
            }
        }
        
        return res.toString();
    }
}