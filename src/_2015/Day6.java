package _2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day6 {
    private int startX, startY, endX, endY;
    private String instruction;
    private boolean[][] lightGrid = new boolean[1000][1000];
    private int[][] lightGrid2 = new int[1000][1000];

    public Day6() {
        String fileName = "Inputs/2015/Day6Input.txt";
        File file = new File(fileName);
        ArrayList<String> input = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                input.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String s : input) {
            StringTokenizer st = new StringTokenizer(s, " ");
            ArrayList<String> tokens = new ArrayList<>();
            while (st.hasMoreTokens())
                tokens.add(st.nextToken());

            StringTokenizer coords = new StringTokenizer(tokens.get(tokens.size() - 1), ",");
            endX = Integer.parseInt(coords.nextToken());
            endY = Integer.parseInt(coords.nextToken());

            coords = new StringTokenizer(tokens.get(tokens.size() - 3), ",");
            startX = Integer.parseInt(coords.nextToken());
            startY = Integer.parseInt(coords.nextToken());

            instruction = "";
            for (int j = tokens.size() - 4; j >= 0; j--)
                instruction = tokens.get(j) + " " + instruction;

            setupLights();
        }
        countLights();
    }

    private void setupLights() {
        switch (instruction) {
            case "turn on ":
                for (int x = startX; x <= endX; x++)
                    for (int y = startY; y <= endY; y++) {
                        lightGrid[x][y] = true;
                        lightGrid2[x][y]++;
                    }
                break;
            case "turn off ":
                for (int x = startX; x <= endX; x++)
                    for (int y = startY; y <= endY; y++) {
                        lightGrid[x][y] = false;
                        if (lightGrid2[x][y] != 0)
                            lightGrid2[x][y]--;
                    }
                break;
            case "toggle ":
                for (int x = startX; x <= endX; x++)
                    for (int y = startY; y <= endY; y++) {
                        lightGrid[x][y] = !lightGrid[x][y];
                        lightGrid2[x][y] += 2;
                    }
                break;
        }
    }

    private void countLights() {
        int count = 0;
        int totalBrightness = 0;
        for (int i = 0; i < lightGrid.length; i++)
            for (int j = 0; j < lightGrid.length; j++) {
                if (lightGrid[i][j])
                    count++;
                totalBrightness += lightGrid2[i][j];
            }
        System.out.printf("There are %d lights on\n", count);
        System.out.printf("Total Brightness %d\n", totalBrightness);
    }
}
