class Solution {
    
    public class Point{
        int i;
        int j;
        int turn;
        
        Point(int i, int j, int turn){
            this.i = i;
            this.j = j;
            this.turn = turn;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Point> que = new LinkedList<>();
        boolean activated[][] = new boolean[grid.length][grid[0].length];
        int moves[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        int res = 0;
        int cnt = 0;
        
        int m = grid.length;        
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    que.add(new Point(i, j, 0));
                    activated[i][j] = true;
                }
                else if(grid[i][j] == 1){
                    cnt += 1;
                }
            }
        }
        
        while(!que.isEmpty()){
            
            int turn = que.peek().turn;
            int curI = que.peek().i;
            int curJ = que.poll().j;
            
            for(int i = 0; i < 4; i++){
                int nextI = curI + moves[i][0];
                int nextJ = curJ + moves[i][1];
                
                if(nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || grid[nextI][nextJ] != 1) continue;
                grid[nextI][nextJ] = 2;
                activated[nextI][nextJ] = true;
                que.add(new Point(nextI, nextJ, turn + 1));
                cnt -= 1;
            }
            res = Math.max(turn, res);
        }

        return cnt != 0 ? -1 : res;
    }
}