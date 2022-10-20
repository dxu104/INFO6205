package WordSearch;

import java.util.LinkedList;
import java.util.List;






    public class Solution {
        static boolean[][] visited;
        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];
            //Note: This for have two functions
            //1st: find the location to start dfs
            //2nd: if the dfs do not return true Then by changing x and y to
            // find the second chance to start dfs, etc
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean search(char[][]board, String word, int i, int j, int index){
            if(index == word.length()){
            }

            if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
                return false;
            }

            visited[i][j] = true;
            if(search(board, word, i-1, j, index+1) ||
                    search(board, word, i+1, j, index+1) ||
                    search(board, word, i, j-1, index+1) ||
                    search(board, word, i, j+1, index+1)){
                return true;
            }
            visited[i][j] = false;
            return false;
        }
    }


