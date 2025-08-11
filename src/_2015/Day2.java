package _2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day2 {
    private String fileName;
    private File file;
    private Scanner scanner;
    private ArrayList<String> input = new ArrayList<>();
    private StringTokenizer st;
    private int sqftTotal;
    private int ftRibbon;

    public Day2(){
        fileName = "Inputs/2015/Day2Input.txt";
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

        for (int i = 0; i < input.size(); i++) {
            st = new StringTokenizer(input.get(i), "x");

            int l = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int volume = l * w * h;

            int lw = l * w;
            int wh = w * h;
            int hl = h * l;

            int smallestArea = 0;
            int perimeter = 0;

            if ((lw <= wh && wh <= hl) || (lw <= hl && hl <= wh)) {
                smallestArea = lw;
                perimeter = (2 * l) + (2 * w);
            }
            if ((wh <= lw && lw <= hl) || (wh <= hl && hl <= lw)) {
                smallestArea = wh;
                perimeter = (2 * w) + (2 * h);
            }
            if ((hl <= lw && lw <= wh) || (hl <= wh && wh <= lw)) {
                smallestArea = hl;
                perimeter = (2 * h) + (2 * l);
            }

            ftRibbon += perimeter + volume;
            sqftTotal += (2 * lw) + (2 * wh) + (2 * hl) + smallestArea;
        }

        System.out.println(sqftTotal + " sqft of wrapping paper should be ordered");
        System.out.println(ftRibbon + " ft of ribbon should be ordered");
    }
}
