package com.algospot.clocksync;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Math.min;

public class Main {
    private static final int INF = 99999;
    private static final int SWITCH_NO = 10;
    private static int[] clocks;
    private static String linked[] = {
            "xxx.............",
            "...x...x.x.x....",
            "....x.....x...xx",
            "x...xxxx........",
            "......xxx.x.x...",
            "x.x...........xx",
            "...x..........xx",
            "....xx.x......xx",
            ".xxxxx..........",
            "...xxx...x...x.."
    };


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(".\\AlgoSpot\\src\\com\\algospot\\clocksync\\input.txt")));
        System.out.println(br.readLine());


    }

    private static int solve(int switchNo) {
        if(switchNo == SWITCH_NO) {
            return areAligned(clocks) ? 0 : INF;
        }

        int ret = INF;
        for (int cnt = 0; cnt < 4; cnt++) {
            ret = min(ret, cnt + solve(switchNo + 1));
            push(switchNo);
        }

        return ret;
    }

    private static void push(int switchNo) {
        for (int i = 0; i < clocks.length; i++) {
            if(linked[switchNo].charAt(i) == 'x') {
                clocks[i] += 3;
                if(clocks[i] == 15) clocks[i] = 3;
            }
        }
    }

    private static boolean areAligned(int[] clocks) {
        for (int clock : clocks) {
            if(clock != 12) {
                return false;
            }
        }
        return true;
    }
}
