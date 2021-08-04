class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    int maxNum = 0;
    int currNum = 0;
    Set<Integer> set;
    public PhoneDirectory(int maxNumbers) {
        maxNum = maxNumbers;
        set = new HashSet<>();
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(currNum==maxNum){
            if(set.size()>0){
                int key = set.iterator().next();
                set.remove(key);
                return key;
            }else return -1;
        }else{
            return currNum++;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number>=maxNum) return false;
        return number>=currNum || set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!check(number)){
            set.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */