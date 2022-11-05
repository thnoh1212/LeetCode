class Solution {
    
    public class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[][] moved = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[][] visited = new int[m][n];
        
        for(int i = 0; i < m; i++){
            
            if(visited[i][0] == 1) continue;
            
            visited[i][0] = 1;
            
            Queue<Point> que = new LinkedList<>();
            
            que.add(new Point(i, 0));
            
            while(!que.isEmpty()){
                int x = que.peek().x;
                int y = que.poll().y;
                                
                for(int j = 0; j < 4; j++){
                    int nextX = x + moved[j][0];
                    int nextY = y + moved[j][1];
                    
                    if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY] == 1 || heights[x][y] > heights[nextX][nextY]) continue;
                    
                    visited[nextX][nextY] = 1;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
        
        
        for(int i = 0; i < n; i++){
            if(visited[0][i] == 1) continue;
            
            visited[0][i] = 1;
            
            Queue<Point> que = new LinkedList<>();
            
            que.add(new Point(0, i));
            
            while(!que.isEmpty()){
                int x = que.peek().x;
                int y = que.poll().y;
                                
                for(int j = 0; j < 4; j++){
                    int nextX = x + moved[j][0];
                    int nextY = y + moved[j][1];
                    
                    if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY] == 1 || heights[x][y] > heights[nextX][nextY]) continue;
                    
                    visited[nextX][nextY] = 1;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
        
        
        
        for(int i = 0; i < m; i++){
            
            if(visited[i][n - 1] == 2 || visited[i][n - 1] == 3) continue;
            
            visited[i][n - 1] += 2;
            
            Queue<Point> que = new LinkedList<>();
            
            que.add(new Point(i, n - 1));
            
            while(!que.isEmpty()){
                int x = que.peek().x;
                int y = que.poll().y;
                                
                for(int j = 0; j < 4; j++){
                    int nextX = x + moved[j][0];
                    int nextY = y + moved[j][1];
                    
                    if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY] == 2 || visited[nextX][nextY] == 3 || heights[x][y] > heights[nextX][nextY]) continue;
                    
                    visited[nextX][nextY] += 2;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(visited[m - 1][i] == 2 || visited[m - 1][i] == 3) continue;
            
            visited[m - 1][i] += 2;
            
            Queue<Point> que = new LinkedList<>();
            
            que.add(new Point(m - 1, i));
            
            while(!que.isEmpty()){
                int x = que.peek().x;
                int y = que.poll().y;
                                
                for(int j = 0; j < 4; j++){
                    int nextX = x + moved[j][0];
                    int nextY = y + moved[j][1];
                    
                    if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY] == 2 || visited[nextX][nextY] == 3 || heights[x][y] > heights[nextX][nextY]) continue;
                    
                    visited[nextX][nextY] += 2;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
        
        for(int k = 0; k < m; k++){
            for(int l = 0; l < n; l++){
                if(visited[k][l] == 3){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(k);
                    temp.add(l);
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
}