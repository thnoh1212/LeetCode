class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
        
        String samePattern = "";
        int point = 2;
        Map<Character, String> savePattern = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char val = pattern.charAt(i);
            if(savePattern.containsKey(val)){
                samePattern += savePattern.get(val);
            }
            else{
                String temp = Integer.toString(point);
                point *= 2;
                savePattern.put(val, temp);
                samePattern += temp;
            }
        }
        
        
        for(int i = 0; i < words.length; i++){
            Map<Character, String> map = new HashMap<>();
            String tempPattern = "";
            int tempPoint = 2;
            for(int j = 0; j < words[i].length(); j++){
                char val = words[i].charAt(j);
                if(map.containsKey(val)){
                    tempPattern += map.get(val);
                }
                else{
                    String temp = Integer.toString(tempPoint);
                    tempPoint *= 2;
                    map.put(val, temp);
                    tempPattern += temp;
                }
            }
            if(tempPattern.equals(samePattern)){
                res.add(words[i]);
            }
        }
        
        return res;
    }
}