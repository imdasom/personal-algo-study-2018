package com.algospot.quadtree;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(".\\AlgoSpot\\src\\com\\algospot\\quadtree\\input.txt")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            System.out.println(quadtree(br.readLine(), 0));
        }

    }

    private static String quadtree(String compressedData, int cursor) {
        String[] pixelInfos = new String[] {"", "", "", ""};
        int[] order = new int[] {2, 3, 0, 1};

        for (int i = 0; i < 4; i++) {
            if(cursor == compressedData.length()) {
                break;
            }

            switch (compressedData.charAt(cursor)) {
                case 'x':
                    String quadtreeResult = "x" + quadtree(compressedData, cursor+1);
                    pixelInfos[order[i]] = quadtreeResult;
                    cursor += quadtreeResult.length();
                    break;
                case 'b':
                case 'w':
                    pixelInfos[order[i]] = String.valueOf(compressedData.charAt(cursor));
                    cursor++;
                    break;
            }
        }

        return String.join("", pixelInfos);
    }

}