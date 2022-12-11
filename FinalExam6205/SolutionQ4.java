package FinalExam6205;



class SolutionQ4 {
    //  time complexity O(m x n )  space: O(m x n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // init a 2d dp array
        int n= obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        //dp[i][j] means the ways to get position (i,j) from the beginning

        // int the first row, if we meet the obstacle, 
        // then after that j all dp[0][j] will be 0
        for(int i=0;i<n;i++){
            if(obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
         // int the first column, if we meet the obstacle, 
        // then after that i all dp[i][0] will be 0
        for(int j=0;j<m;j++){
            if(obstacleGrid[0][j]==1) break;
            dp[0][j]=1;
        }
        
        // for other element, if we meet obstacle dp[i][j] will be 0
        // otherwise it will be the sum of dp[i][j-1] and dp[i-1][j]
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
    
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {

        // test code
        SolutionQ4 obj = new SolutionQ4();
        int[][] board= new int[3][3];
        board[1][1]=1;

        
        int res= obj.uniquePathsWithObstacles(board);
        // the result should be 2
        System.out.println(res);

    }

}

