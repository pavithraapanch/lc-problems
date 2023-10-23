package mediumLC.graph;

import java.util.LinkedList;
import java.util.*;

public class shortestPathInBinaryMatrix {

    public static void main(String ars[]){
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int dist = shortestPathBinaryMatrix_WithDistanceInQ(grid);
        System.out.println("Distance:: " + dist);

        dist = shortestPathBinaryMatrix_WithDistance(grid);
        System.out.println("Distance:: " + dist);
    }

    public static final int[][] directions = new int[][]{{-1,-1}, {-1,0}, {0,-1}, {1,1}, {1,0}, {0,1}, {1,-1}, {-1,1}};

    /*
    BFS = Shortest Path;
    Becoz, The first to reach the end will always be the fastest/shortest path.
    1. Queue - To keep track of the nodes in level
    2. Have a visited set, so that we don't keep visiting the same node again
    3. Maintain 3D array, for row,col, distance tuple
     */
    public static int shortestPathBinaryMatrix_WithDistanceInQ(int[][] grid) {
        if( grid[0][0] != 0 || grid[grid.length-1][grid.length-1] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cell = q.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];

            if(row == grid.length-1 && col == grid[0].length-1)
                return distance;

            for(int[] neighbors: getNeighbors(row, col, grid)){
                int neighborRow = neighbors[0];
                int neighborCol = neighbors[1];
                if(visited[neighborRow][neighborCol])
                    continue;
                visited[neighborRow][neighborCol] = true;
                q.add(new int[]{neighborRow, neighborCol, distance+1});
            }
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix_WithDistance(int[][] grid){
        if( grid[0][0] != 0 || grid[grid.length-1][grid.length-1] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        int distance = 1;

        while(!q.isEmpty()){
            int nodesAtCurrDistance = q.size();
            for(int i=0; i<nodesAtCurrDistance; i++){
                int[] cell = q.remove();
                int row = cell[0];
                int col = cell[1];

                if(row == grid.length-1 && col == grid[0].length-1)
                    return distance;

                for(int[] neighbors: getNeighbors(row, col, grid)){
                    int neighborRow = neighbors[0];
                    int neighborCol = neighbors[1];
                    if(visited[neighborRow][neighborCol])
                        continue;
                    visited[neighborRow][neighborCol] = true;
                    q.add(new int[]{neighborRow, neighborCol});
                }
            }
            distance++;
        }
        return distance;
    }

    public static List<int[]> getNeighbors(int row, int col, int[][] grid){
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol <  0 || newRow > grid.length - 1 || newCol > grid[0].length - 1 || grid[newRow][newCol] != 0)
                continue;
            neighbors.add(new int[]{newRow, newCol});
        }
        return neighbors;
    }
}
