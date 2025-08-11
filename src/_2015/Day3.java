package _2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    // Might need to make a weighted graph
    private String fileName;
    private File file;
    private Scanner scanner;
    private ArrayList<String> input = new ArrayList<>();

    private ArrayList[][] visitCount = new ArrayList[2][2];

    public Day3(){
        fileName = "Inputs/2015/Day3Input.txt";
        file = new File(fileName);
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                input.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        visitCount[0][0] = new ArrayList();
        visitCount[0][1] = new ArrayList();
        visitCount[1][0] = new ArrayList();
        visitCount[1][1] = new ArrayList();
        visitCount[0][0].add(5);
        visitCount[0][0].add(10);
        visitCount[0][1].add(3);
        visitCount[1][0].add(53);
        visitCount[1][1].add(0);
        printGrid(visitCount);

    }

    private void printGrid(ArrayList[][] visitCount) {
        for (int i = 0; i < visitCount.length; i++) {
            for (int j = 0; j < visitCount.length; j++) {
                System.out.print(visitCount[i][j] + " ");
            }
            System.out.println();
        }
    }
}
