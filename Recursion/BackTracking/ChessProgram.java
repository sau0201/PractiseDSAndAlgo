package BackTracking;

public class ChessProgram {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3 };
        checkIfChessExist(nums, "", 4);
    }

    static void checkIfChessExist(int[] nums, String slate, int target) {
        if (slate.length() == target) {
            System.out.println(slate);
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                checkIfChessExist(nums, slate + "" + nums[i], target);
            }
        }
    }

    static boolean checkIfValid(String str, int target) {
        for (int i = 1; i < str.length(); i++) {
            int column = i;
            int row = Integer.valueOf(str.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
                int column1 = j;
                int row1 = Integer.valueOf(str.charAt(j));

                while (column1 >= 0 && row1 >= 0) {
                    if (column1-- == column && row1-- == row) {
                        return false;
                    }
                }
                while (column1 < target && row1 < target) {
                    if (column1-- == column && row1++ == row) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}