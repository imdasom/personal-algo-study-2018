package com.algospot.quadtree;

import java.io.*;

public class Main2 {

    private static int cursor = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\AlgoSpot\\src\\com\\algospot\\quadtree\\input.txt")));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            cursor = 0;
            System.out.println(reversePixel(br.readLine()));
        }

    }

    private static String reversePixel(String compressedData) {

        char currentPixel = compressedData.charAt(cursor);
        cursor++;
        if(currentPixel == 'b' || currentPixel == 'w') {
            return String.valueOf(currentPixel);
        }

        String upperLeft = reversePixel(compressedData);
        String upperRight = reversePixel(compressedData);
        String lowerLeft = reversePixel(compressedData);
        String lowerRight = reversePixel(compressedData);

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }
}
