class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int needCapacity[] = new int[1001];
        
        for(int i = 0; i < trips.length; i++){
            for(int j = trips[i][1]; j < trips[i][2]; j++){
                needCapacity[j] += trips[i][0];
            }
        }
        
        for(int i = 0; i  < 1001; i++){
            if(needCapacity[i] > capacity){
                return false;
            }
        }
        return true;
    }
}