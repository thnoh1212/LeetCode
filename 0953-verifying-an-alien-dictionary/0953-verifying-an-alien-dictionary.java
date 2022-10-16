class Solution {
    static Map<Character, Integer> dict;
    public boolean isAlienSorted(String[] words, String order) {
        
        dict = new HashMap<>();
         
        for(int i = 0; i < order.length(); i++){
            dict.put(order.charAt(i), i);
        }
        
        for(int i = 0; i < words.length - 1; i++){
            if(!compareByDict(words[i], words[i+1])){
                return false;
            }
        }
        return true;
    }
    
    public boolean compareByDict(String front, String back){
        int minLen = Math.min(front.length(), back.length());
        
        for(int i = 0; i < minLen; i++){
            if(dict.get(front.charAt(i)) == dict.get(back.charAt(i))){
                continue;
            }
            else if(dict.get(front.charAt(i)) < dict.get(back.charAt(i))){
                return true;
            }
            else{
                return false;
            }
        }
        return front.length() <= back.length() ? true : false;
    }
}