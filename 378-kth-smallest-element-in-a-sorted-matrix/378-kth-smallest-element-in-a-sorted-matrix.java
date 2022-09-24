class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        Map<Integer, Integer> map = new TreeMap<>(comparator);
        int res = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(map.containsKey(matrix[i][j])){
                    int val = map.get(matrix[i][j]);
                    map.put(matrix[i][j], val + 1);
                }
                else{
                    map.put(matrix[i][j], 1);
                }
            }
        }
        
        for(int key : map.keySet()){
            k -= map.get(key);
            if(k <= 0){
                res = key;
                break;
            }
        }
        
        return res;
    }
}