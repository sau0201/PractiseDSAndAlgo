class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0; int right = m*n-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            int value = getMatrixValue(mid, m, n, matrix);
            if(value==target) return true;
            if(value<target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
    
    int getMatrixValue(int mid, int rows, int cols, int [][] matrix){
        int rowIndex = mid/cols;
        int colIndex = mid%cols;
        return matrix [rowIndex][colIndex];
    }
}