package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        char[] alphabets = {' ', '0', '1', 'a', 'b', 'c', '2', 'd', 'e', 'f', '3', 'g', 'h', 'i', '4', 'j', 'k', 'l', '5',
                'm', 'n', 'o', '6', 'p', 'q', 'r', 's', '7', 't', 'u', 'v', '8', 'w', 'x', 'y', 'z', '9'};
        String[] codes = {"01", "02", "11", "21", "22", "23", "24", "31", "32", "33", "34", "41", "42", "43", "44",
                "51", "52", "53", "54", "61", "62", "63", "64", "71", "72", "73", "74", "75",
                "81", "82", "83", "84", "91", "92", "93", "94", "95"};

        System.out.println("Welcome to Message Decoder!!!");
        while (true) {
            System.out.println("1. Encode");
            System.out.println("2. Decode");
            System.out.println("0. Exit");
            System.out.print("Choose an option to continue: ");
            int option = scannerNum.nextInt();
            switch (option) {
                case 0 -> {
                    System.out.println("Bye");
                    return;
                }
                case 1 -> {
                    System.out.print("Enter your sms message: ");
                    String str = scannerStr.nextLine().toLowerCase();
                    String result = "";
                    for (int i = 0; i < str.length(); i++) {
                        result += codes[findIndex(alphabets, str.charAt(i))];
                    }
                    System.out.printf("Your encrypted text: %s\n", result);
                }
                case 2 -> {
                    System.out.print("Enter the encrypted text: ");
                    String str = scannerStr.nextLine().toLowerCase();
                    String[] twoSegments = str.split("(?<=\\G.{2})");
                    String result = "";
                    for (int i = 0; i < twoSegments.length; i++) {
                        result += alphabets[findIndexStr(codes, twoSegments[i])];
                    }
                    System.out.printf("Your sms message: %s\n", result);
                }
                default -> {
                    System.out.println("You have chosen invalid option");
                }
            }
        }
    }

    public static int findIndex(char[] alphabets, char letter) {
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == letter) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexStr(String[] alphabets, String letter) {
        for (int i = 0; i < alphabets.length; i++) {
            if (Objects.equals(alphabets[i], letter)) {
                return i;
            }
        }
        return -1;
    }
}
