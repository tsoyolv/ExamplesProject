package ru.sgu.acm.solutions;


import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mas[] = new int[n],
                tempMas[],
                res[];
        for (int i = 0; i < n; i++) {
            mas[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tempMas = new int[0];
            for (int j = i; j < n; j++) {
                tempMas = appendEl(tempMas, mas[j]);
                int s = n % tempMas.length;
                if (s == 0) {
                    s = n / tempMas.length;
                    res = new int[0];
                    while (s-- > 0) {
                        res = appendMas(res, tempMas);
                    }
                    if (Arrays.equals(res, mas)) {
                        System.out.println(tempMas.length);
                        return;
                    }
                }
            }
        }
    }

    public static int[] appendEl(int mas[], int n) {
        int newMas[] = new int[mas.length + 1];
        for (int i = 0; i < mas.length; i++) {
            newMas[i] = mas[i];
        }
        newMas[mas.length] = n;
        return newMas;
    }

    public static int[] appendMas(int targetMas[], int appendMas[]) {
        int newMas[] = new int[targetMas.length + appendMas.length];
        for (int i = 0; i < targetMas.length; i++) {
            newMas[i] = targetMas[i];
        }
        for (int i = 0; i < appendMas.length; i++) {
            newMas[targetMas.length + i] = appendMas[i];
        }
        return newMas;
    }
}
