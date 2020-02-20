package BackTracking;
import java.util.*;

public class ChessProgram {
    public static void main(String[] args) {
        String[][] str = find_all_arrangements(6) ;
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str[0].length;j++){
                System.out.println(str[i][j]);
            }
        }
    }

    
    /*
     * Complete the function below.
     */
    static String[][] find_all_arrangements(int n) {
        List<String[]> parentList = new ArrayList<String []>();
        for(int i=0;i<n;i++){
            List<String> list = new ArrayList<String>();
            char [][] board = new char [n][n];
            board[0][i] = 'q';
            getAllArrangements(n, board, list, 1 );
            if(list.size()>0) parentList.add(list.toArray(new String [list.size()]));
        }
        
        return parentList.toArray(new String [parentList.size()][4]);
    }
        
    static void getAllArrangements(int n, char [][] board, List<String> list, int row ){
        if(row==n){
            convertBoardToList(board, list);
            return;
        }
        for(int i=0;i<n;i++){
            System.out.println("row " + row);
            System.out.println("column " + i);
            boolean valid = isValid(board, row, i);
            System.out.println(valid);
            if(row==3){
                for(int a=0;a<board.length;a++){
                    System.out.println("");
                    for(int b=0;b<board[0].length;b++){
                        System.out.print(board[a][b] + ",");
                    }
                }
            }
            if(valid){
                board[row][i] = 'q';
                getAllArrangements(n, board, list, row+1 );
            }
        }
    }
    
    static boolean isValid(char [][] board, int row, int column){
        //checking for same column
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0;i<rows;i++){
            if(board[i][column]=='q'){
                return false;
            }
        }
        //checking upper left diagonal
        int i=row-1;int j=column-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='q') return false;
            i--;j--;
        }
        //checking upper right diagonal
        int l=row-1;int m=column+1;
        while(l>=0 && m<columns){
            if(board[l][m]=='q') return false;
            l--;m++;
        }
        
        return true;
    }
    
    static void convertBoardToList(char [][] board, List<String> list){
        for(int i=0;i<board.length;i++){
            StringBuilder sb  = new StringBuilder();
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j]=='q'?'q':'-';
                sb.append(c);
            }
            list.add(sb.toString());
        }
    }
}