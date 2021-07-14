class Solution {
    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, 0,points.length-1,K-1);
        int [][] resultArray = new int [K][2];
        for(int i=0;i<K;i++){
            resultArray[i] = points[i];
        }
        return resultArray;
    }
    
    void quickSort(int [][] points, int lo, int hi, int k){
        if(lo>=hi){
            return;
        }
        int pivot = partition(points, lo, hi);
        if(pivot==k) return;
        if(pivot<k)
            quickSort(points, pivot+1, hi, k);
        else quickSort(points, lo, pivot-1, k);
    }
    
    int partition(int [][] points, int lo, int hi){
        setPivot(lo, hi, points);
        int pivotIndex = lo;
        int pivotValue = getDistance(points[lo]);
        int or=lo; int gr=lo+1;
        while(gr<=hi){
            if(getDistance(points[gr]) <= pivotValue){
                or++; 
                swap(points, or, gr);
            }
            gr++;
        }
        swap(points, or, pivotIndex);
        return or;   
    }
    
    int getDistance(int [] distance){
        return (distance[0]*distance[0]) + (distance[1]*distance[1]);
    }
    
    void setPivot(int lo, int hi, int [][] points){
        int random = new Random().nextInt(hi-lo)+lo;
        swap(points, lo, random);
    }
    
    void swap(int [][] points, int a, int b){
        if(a!=b){
            int [] temp = points[a];
            points[a]= points[b];
            points[b]=temp;
        }
    }
}