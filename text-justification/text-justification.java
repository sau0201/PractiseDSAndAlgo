class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<words.length){
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while(i<words.length && len<maxWidth){
                String word = words[i];
                if(len==0){
                    sb.append(word);
                    len+=word.length();
                    i++;
                }else{
                    if(len+word.length()+1<=maxWidth){
                        sb.append(" ").append(word);
                        len += word.length()+1;
                        i++;
                    }else{
                        break;
                    }
                }
            }
            result.add(sb.toString());
        }
        
        int size = result.size();
        for(int j=0;j<size-1;j++){
            result.set(j, processString(result.get(j), maxWidth));
        }
        
        result.set(size-1 , processLastString(result.get(size-1), maxWidth));
        return result;
    }
    
    
    String processString(String str, int maxWidth){
        int length = str.length();
        int diff = maxWidth-length;
        if(diff==0){
            return str;
        }
        
        String [] splittedString = str.split(" ");
        if(splittedString.length==1){
            return processLastString(str, maxWidth);
        }
        int spaceCount = diff/(splittedString.length-1); 
        int extraSpaceCount = diff%(splittedString.length-1);
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String splitString:splittedString){
            if(i==0){
                sb.append(splitString);
            }
            
            if(i!=0){
                sb.append(" ").append(splitString);
            }
            
            if(sb.length()<maxWidth){
                for(int k=0;k<spaceCount;k++){
                    sb.append(" ");
                }
                if(extraSpaceCount>0){
                    sb.append(" ");
                    extraSpaceCount--;
                }
            }
            
            i++;
        }
        
        return sb.toString();
    }
    
    
    String processLastString(String str, int maxWidth){
        int length = str.length();
        int diff = maxWidth-length;
        if(diff==0){
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<diff;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    
    
    
}