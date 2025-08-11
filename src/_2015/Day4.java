package _2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    private String fileName;
    private File file;
    private Scanner scanner;
    private ArrayList<String> input = new ArrayList<>();
    private MessageDigest md = MessageDigest.getInstance("MD5");

    public Day4() throws NoSuchAlgorithmException {
        fileName = "Inputs/2015/Day4Input.txt";
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

        int count = 0;
        String secretKey = input.get(0);

        // Part 1
        String hash = computeHash(secretKey, count);
        while (verifyHash(hash, 5)) {
            count++;
            hash = computeHash(secretKey, count);
        }
        System.out.printf("Lowest number that gives MD5 hash with 5 leading 0's when added to the end of %s: %d\n%s\n", secretKey, count, hash);

        // Part 2
        count = 0;
        hash = computeHash(secretKey, count);
        while (verifyHash(hash, 6)) {
            count++;
            hash = computeHash(secretKey, count);
        }
        System.out.printf("Lowest number that gives MD5 hash with 6 leading 0's when added to the end of %s: %d\n%s\n", secretKey, count, hash);
    }

    private String computeHash(String secretKey, int count) {
        byte[] messageDigest = md.digest((secretKey+count).getBytes(StandardCharsets.UTF_8));
        BigInteger no = new BigInteger(1, messageDigest);
        String hash = no.toString(16);
        while (hash.length() < 32)
            hash = "0" + hash;
        return hash;
    }

    private boolean verifyHash(String hash, int numZeros) {
        if (numZeros == 5)
            return !hash.startsWith("00000");
        else if (numZeros == 6)
            return !hash.startsWith("000000");
        return true;
    }

}
