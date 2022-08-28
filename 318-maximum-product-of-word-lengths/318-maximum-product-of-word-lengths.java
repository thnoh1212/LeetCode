class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int bitMasks[] = new int[words.length];
        for(int i = 0; i < words.length; i++){
            int bitMask = 0;
            for(int j = 0; j < words[i].length(); j++){
                int temp = 1 << (words[i].charAt(j) - 'a');
                bitMask |= temp;
            }
            bitMasks[i] = bitMask;
        }
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if((bitMasks[i] & bitMasks[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}