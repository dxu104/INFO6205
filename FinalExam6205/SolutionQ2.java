package FinalExam6205;

class SolutionQ2 {

    //time complexity is O（mxn）;
    // space complexity is O（mxn）;
    public int numIslands(char[][] grid) {
        int count=0;
        // iterate over the entire 2d array 
        for(int i =0; i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                // if there is a "1", we find one island
                if (grid[i][j]=='1'){
                    count+=1;
                    // depth-fist search for all the nearby ones
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid,int i, int j){
        // if we go out of the bound, or reach the "0"(water), stop the dfs
         if(i<0 || i>=grid.length ||j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        // change the place we have gone through to ”0“；
        grid[i][j]='0';
        // continue to go through other four directions
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    public static void main(String[] args) {

        //test code
        SolutionQ2 obj  = new SolutionQ2 ();
        char[][] input1 = new char[4][5];
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                input1[i][j]= '0';
            }
        }
        //1st row;
        input1[0][0]='1';
        input1[0][1]='1';
        input1[0][2]='1';
        input1[0][3]='1';

        //2nd row;
        input1[1][0]='1';
        input1[1][1]='1';
        input1[1][3]='1';

        //3rd row;
        input1[2][0]='1';
        input1[2][1]='1';

        //4th row;



        int res1= obj.numIslands(input1);
        // the correct answer should be 2 island;
        System.out.println(res1);


        //test code

        char[][] input2 = new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                input2[i][j]= '0';
            }
        }
        input2[0][0]='1';
        input2[0][1]='1';
        input2[2][2]='1';
        int res2= obj.numIslands(input2);
        // the correct answer should be 2 island;
        System.out.println(res2);
    }
}


