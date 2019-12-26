import java.util.*;
class MergeKSortedArraysHeapBased {

    public static void main(String[] args) {
        int [][] arr = {{7,7,7,7},{2,6,6,8},{6,10,10, 11}};
        int length = arr.length;
        int breadth = arr[0].length;
        int [] mArray = new int [length*breadth];
        mArray = mergeArrays(arr);
        for (int i = 0; i < mArray.length; i++)
                System.out.println(mArray[i]);
    }

    static int[] mergeArrays(int[][] arr) {
        int length = arr.length;
        int breadth = arr[0].length;
        int [] mArray = new int [length*breadth];
        if(length==0) return mArray;
        if(length==1) return arr[0];
        
        int order = 0;
        for(int k=0;k<length && order==0;k++){
            int j=0;
            while(j+1<breadth && order == 0){
                if( arr[k][j+1] > arr[k][j]) order=1;
                else if (arr[k][j+1]<arr[k][j]) order=-1;
                j++;
            }
        }
        
        PriorityQueue<ArrayEntry> queue = new PriorityQueue<ArrayEntry>(length, new Comparator<ArrayEntry>(){
            public int compare(ArrayEntry a1, ArrayEntry a2){
                return a1.order*Integer.compare(a1.value, a2.value);
            }
        });
        
        for(int i=0;i<length;i++){
            if(arr[i].length>0){
                ArrayEntry ae = new ArrayEntry(i,arr[i][0],0, order);
                queue.add(ae);
            }
        }

        int index=0;
        while(!queue.isEmpty()){
            ArrayEntry ae = queue.poll();
            mArray[index++]=ae.value;
    
            int arrayIndex = ae.arrayIndex;
            int valueIndex = ae.valueIndex;
            if(valueIndex+1<arr[arrayIndex].length){
                ArrayEntry ae2 = new ArrayEntry(arrayIndex, arr[arrayIndex][valueIndex+1], valueIndex+1,order);
                queue.add(ae2);
            }
            
        }
        
        return mArray;
    }
    
    static class ArrayEntry{
        int value;
        int arrayIndex;
        int valueIndex;
        int order;
        
        ArrayEntry(int arrayIndex,int value, int valueIndex, int order){
            this.arrayIndex = arrayIndex;
            this.value=value;
            this.valueIndex=valueIndex;
            this.order=order;
        }
    }
}

