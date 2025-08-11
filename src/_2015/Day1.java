package _2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    private String input;
    private String fileName;
    private Scanner scanner;
    private File file;
    private int result = 0;
    private boolean flag = false;

    public Day1(){
        fileName = "Inputs/2015/Day1Input.txt";
        file = new File(fileName);
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                input = scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                result++;
            if (input.charAt(i) == ')')
                result--;

            if (result < 0 && !flag){
                System.out.println("The position of the basement character is: " + (i+1) );
                flag = !flag;
            }
        }
        System.out.println("The result for Day1 is: " + result);
    }
}
