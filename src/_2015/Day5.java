package _2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    private String fileName;
    private File file;
    private Scanner scanner;
    private ArrayList<String> input = new ArrayList<>();

    public Day5() {
        fileName = "Inputs/2015/Day5Input.txt";
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

        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < input.size(); i++) {
            String tmp = input.get(i);
            if(isNice1(vowelCount(tmp), doubleLetter(tmp), noContain(tmp)))
                count1++;
            if(isNice2(twoLetterPair(tmp), spaceRepeat(tmp)))
                count2++;
        }
        System.out.printf("There are %d nice strings\n", count1);

        System.out.printf("There are %d nice strings\n", count2);
    }

    private boolean isNice1(boolean vowelCount, boolean doubleLetter, boolean noContains) {
        return vowelCount && doubleLetter && noContains;
    }

    private boolean isNice2(boolean twoLetterPair, boolean spaceRepeat) {
        return twoLetterPair && spaceRepeat;
    }

    private boolean vowelCount(String in) {
        int count = 0;
        in = in.toLowerCase();
        char[] inChar = in.toCharArray();
        for (int i = 0; i < inChar.length; i++) {
            if (inChar[i] == 'a' || inChar[i] == 'e' || inChar[i] == 'i' || inChar[i] == 'o' || inChar[i] == 'u')
                count++;
            if (count >= 3)
                return true;
        }
        return false;
    }

    private boolean doubleLetter(String in) {
        in = in.toLowerCase();
        char[] inChar = in.toCharArray();
        for (int i = 0; i < inChar.length - 1; i++) {
            if (inChar[i] == inChar[i + 1])
                return true;
        }
        return false;
    }

    private boolean noContain(String in) {
        return !in.contains("ab") && !in.contains("cd") && !in.contains("pq") && !in.contains("xy");
    }

    private boolean twoLetterPair(String in) {
        for (int i = 0; i < in.length() - 2; i++) {
            String tmp = in.substring(i, i+2);
            String newIn = in.substring(i+2, in.length());

            if (newIn.contains(tmp))
                return true;
        }
        return false;
    }

    private boolean spaceRepeat(String in) {
        char[] inChar = in.toCharArray();
        for (int i = 0; i < inChar.length - 2; i++) {
            if (inChar[i] == inChar[i+2])
                return true;
        }
        return false;
    }
}
