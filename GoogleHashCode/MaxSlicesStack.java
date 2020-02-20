import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MaxSlicesStack {

    static int max;
    static int [] inputArr;
    static int num;
    static int score = 0;

    class SliceVO {
        int index;
        int max;

        public SliceVO(int index, int max) {
            this.index = index;
            this.max = max;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            SliceVO sliceVO = (SliceVO) o;
            return index == sliceVO.index && max == sliceVO.max;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, max);
        }

        @Override
        public String toString() {
            return "SliceVO{" + "index=" + index + ", max=" + max + '}';
        }
    }

    public void getMaxSlices(int[] input, int max) {
        Stack<SliceVO> stack = new Stack<>();
        Map<SliceVO, Integer> cache = new HashMap<>();
        SliceVO initialSliceVO = new SliceVO(0, max);
        stack.push(initialSliceVO);
        while (!stack.isEmpty()) {
            SliceVO sliceVO = stack.pop();
            int sIndex = sliceVO.index;
            int sMax = sliceVO.max;
            if (cache.containsKey(sliceVO)) continue;
            if (sIndex == input.length - 1) {
                cache.put(sliceVO, compute(input[sIndex], sMax));
            } else if (sMax < input[sIndex]) {
                cache.put(sliceVO, sMax);
            } else if (sMax == input[sIndex]) {
                cache.put(sliceVO, 0);
            } else {
                SliceVO sliceVO1 = new SliceVO(sIndex + 1, sMax - input[sIndex]);
                SliceVO sliceVO2 = new SliceVO(sIndex + 1, sMax);

                if (cache.containsKey(sliceVO1)) {
                    Integer max1 = cache.get(sliceVO1);
                    Integer max2 = cache.get(sliceVO2);

                    max1 = max1 == null ? Integer.MAX_VALUE : max1;
                    max2 = max2 == null ? Integer.MAX_VALUE : max2;

                    cache.put(sliceVO, Math.min(max1, max2));
                } else {
                    stack.push(sliceVO);
                    stack.push(sliceVO1);
                    stack.push(sliceVO2);
                }
            }
        }

        System.out.println("Answer = " + cache.get(initialSliceVO));

        // Get the Path

        List<Integer> path = new ArrayList<>();
        SliceVO sliceVO = initialSliceVO;
        while (cache.containsKey(sliceVO)) {
            int maxSoFar = cache.get(sliceVO);
            int sIndex = sliceVO.index;
            int sMax = sliceVO.max;
            if (sIndex == input.length - 1 || sMax < input[sIndex]) {
                path.add(input[sliceVO.index]);
                break;
            } else {
                SliceVO sliceVO1 = new SliceVO(sliceVO.index + 1, sMax - input[sliceVO.index]);
                SliceVO sliceVO2 = new SliceVO(sliceVO.index + 1, sMax);
                if (maxSoFar == cache.get(sliceVO1)) {
                    path.add(input[sliceVO.index]);
                    sliceVO = sliceVO1;
                } else {
                    sliceVO = sliceVO2;
                }
            }
        }
        System.out.println("Path = " + path);
    }

    private int compute(int input, int max) {
        return max < input ? max : max - input;
    }

    public static void main(String args[]) {
        String folderName = "C:\\Users\\Saurabh Sharma\\Documents\\personal\\GoogleHashCode\\PracticeProblem\\";
        String[] fileNames = {"e_also_big" };
        for (int i = 0; i < fileNames.length; i++) {
            getInputFromFile(folderName, fileNames[i]);
            MaxSlicesStack maxSlicesStack = new MaxSlicesStack();
            maxSlicesStack.getMaxSlices(inputArr, max);
            //Collections.reverse(Output);

            //writeIntoFile(folderName, fileNames[i]);
           // System.out.println("\nSCORE : " + score);
        }

    }

    static void getInputFromFile(String folderName, String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(folderName + fileName + ".in"));
            String line, firstLine;
            firstLine = br.readLine();
            String[] vars;
            vars = firstLine.split(" ");

            max = Integer.valueOf(vars[0]); // Maximum Pizza slices requires
            num = Integer.valueOf(vars[1]); // Number of Pizzas available
            inputArr = new int [num];
            // Create the pizza list by reading the file
            //System.out.println("-------input of " + fileName);
            //System.out.println(MAX + " " + Num);
            while ((line = br.readLine()) != null) {
                String letters[] = line.split(" ");
                for (int i = 0; i < letters.length; i++) {
                    inputArr[i] = Integer.valueOf(letters[i]);
                    //System.out.print(letters[i] + " ");
                }
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Exception while reading input " + ex);
        }
    }

    /*static void writeIntoFile(String folderName, String fileName) {
        try {
            System.out.println("\n------- output " + fileName);
            PrintWriter outputFile = new PrintWriter(folderName + fileName + ".out", "UTF-8");
            outputFile.println(Output.size());
            System.out.println(Output.size());
            for (int i = 0; i < Output.size(); i++) {
                outputFile.print(Output.get(i) + " ");
                System.out.print(Output.get(i) + " ");
            }
            outputFile.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }*/
}