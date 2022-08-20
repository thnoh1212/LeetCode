class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean res = true;
        
        boolean visited[] = new boolean[rooms.size()];
        visited[0] = true;
        
        Queue<Integer> Inventory = new LinkedList<>();
        for(int i = 0; i < rooms.get(0).size(); i++){
            Inventory.add(rooms.get(0).get(i));
            visited[rooms.get(0).get(i)] = true;
        }
        
        while(!Inventory.isEmpty()){
            int curKey = Inventory.poll();
            for(int i = 0; i < rooms.get(curKey).size(); i++){
                if(!visited[rooms.get(curKey).get(i)]){
                    Inventory.add(rooms.get(curKey).get(i));
                    visited[rooms.get(curKey).get(i)] = true;
                }
            }
        }
        for(int i = 0; i < visited.length; i++){
            res = res && visited[i];
            if(!res) break;
        }
        return res;
    }
    
}