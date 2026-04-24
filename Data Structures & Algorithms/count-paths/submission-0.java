class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i],-1);
        }
        return numberOfUniquePaths(0,0, m, n, dp);
    }

    public int numberOfUniquePaths(int i, int j, int m, int n, int arr[][]) {
        if(i==m-1 && j==n-1) {
            return 1;
        }
        if(i==m || j==n) {
            return 0;
        }
        if(arr[i][j]!=-1) {
            return arr[i][j];
        }
        int result = numberOfUniquePaths(i+1, j, m, n, arr) + numberOfUniquePaths(i,j+1,m,n, arr);
        arr[i][j] = result;
        return result;
    }
}
