class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0, res = 0;
        for(int i = 0; i < piles.length; i++){
            if(max < piles[i]) max = piles[i];
        }
        
        int mid = (min + max) / 2;
        while(min != max){
            mid = (max + min) / 2;
            System.out.print(min + " " + max + " " + mid + " ");
            int day = 0;
            for(int i = 0; i < piles.length; i++){
                day += piles[i] / mid;
                if(piles[i] % mid != 0)
                    day += 1;
            }
            System.out.println(day);
            if(day > h){
                min = mid;
            }else if(day <= h){
                max = mid;
            }
            
            if(mid == (max + min) / 2){
                mid = max;
                break;
            }
        }
        return mid;
    }
}