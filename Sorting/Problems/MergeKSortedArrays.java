import java.util.*;
class MergeKSortedArrays {

    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},{5,6,6,7},{8,10,10, 11}};
        int length = arr.length;
        int breadth = arr[0].length;
        int [] mArray = new int [length*breadth];
        mArray = mergeArrays(arr);
        for (int i = 0; i < mArray.length; i++)
                System.out.println(mArray[i]);
    }
    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arr) {
        int length = arr.length;
        int breadth = arr[0].length;
        int [] mArray = new int [length*breadth];
        for(int i=0;i<breadth;i++){
            mArray[i] = arr[0][i];
        }

        //if sorting order is not known. Make this order ==1 if increasing or -1 if decreasing 
        int order = 0;
        for(int k=0;k<length && order==0;k++){
            int j=0;
            while(j+1<breadth && order == 0){
                if( arr[k][j+1] > arr[k][j]) order=1;
                else if (arr[k][j+1]<arr[k][j]) order=-1;
                j++;
            }
        }
        for(int i=1;i<length;i++){
            int b=breadth-1;
            int a = i*breadth-1 ; int n=a+breadth;
            while(b>=0 && a>=0){
                if(order*mArray[a]>=order*arr[i][b]){
                    mArray[n] = mArray[a];
                    a--;n--;
                }else{
                    mArray[n]= arr[i][b];
                    b--;n--;
                }
            }
            while(a>=0){
                mArray[n] = mArray[a];
                a--;n--;
            }
            while(b>=0){
                mArray[n]= arr[i][b];
                b--;n--;
            }
        }
        return mArray;
    }
}
