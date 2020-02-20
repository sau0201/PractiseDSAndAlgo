import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class PizzaProblem {
    static int max;
    static List<Integer> output;
    static int input[];
    static int num;
    static int score = 0;

    public static void main(String[] args) throws FileNotFoundException {

        String folderName = "C:\\Users\\Saurabh Sharma\\Documents\\personal\\GoogleHashCode\\PracticeProblem\\";
        String[] fileNames = { "a_example","b_small","c_medium"};
        for (int i = 0; i < fileNames.length; i++) {
            getInputFromFile(folderName, fileNames[i]);
            getMaxSlices(input, max);
            writeIntoFile(folderName,fileNames[i]);
            System.out.println("\nSCORE : " + score);
        }

    }

    static void getInputFromFile(String folderName, String fileName){
        try {
            BufferedReader fr = new BufferedReader(new FileReader(folderName + fileName + ".in"));
            String line, firstLine;
            firstLine = fr.readLine();
            String[] vars;
            vars = firstLine.split(" ");
            max = Integer.valueOf(vars[0]); // Maximum Pizza slices requires
            num = Integer.valueOf(vars[1]); // Number of Pizzas available
            input=new int [num];
            // Create the pizza list by reading the file
            System.out.println("-------input of " + fileName);
            System.out.println(max + " " + num);
            while ((line = fr.readLine()) != null) {
                String letters[] = line.split(" ");
                for (int i = 0; i < letters.length; i++) {
                    input[i] = Integer.valueOf(letters[i]);
                    System.out.print(letters[i] + " ");
                }
            }
            fr.close();
        } catch (IOException ex) {
            System.out.println("Exception while reading input " + ex);
        }
    }

    static void writeIntoFile(String folderName, String fileName) {
        try {
            System.out.println("\n------- output " + fileName);
            PrintWriter outputFile = new PrintWriter(folderName + fileName + ".out", "UTF-8");
            outputFile.println(output.size());
            System.out.println(output.size());
            for (int i = 0; i < output.size(); i++) {
                outputFile.print(output.get(i) + " ");
                System.out.print(output.get(i) + " ");
            }
            outputFile.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }

    public static void getMaxSlices(int[] input, int max) {
         subSetSum(input, max, 0, 0, new ArrayList<Integer>());
    }

    private static void subSetSum(int[] input, int max, int sum, int i, List<Integer> slate) {
        if(sum>score && sum<=max){
            output = new ArrayList<Integer>(slate);
            score=sum;
            if(sum==max) return;
        }
        if(sum>max) return;
        if(i==input.length) return;
        if(sum<max){
            subSetSum(input, max, sum, i+1, slate);
        }
        if(sum<max){
            slate.add(i);
            subSetSum(input, max, sum+input[i], i+1, slate);
            slate.remove(slate.size()-1);
        }
    }
}