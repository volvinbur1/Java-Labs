package com.company;

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Scanner;
import java.util.Vector;

public class Task {
    private String[] words;
    private int[] countDifferentChars;

    Task() {
        Scanner stream = new Scanner(System.in);
        String inputLine = stream.nextLine();
        words = inputLine.split(" ");
    }

    Task(String[] _words) {
        words = _words;
    }

    public void CountDifferentChars() {
        countDifferentChars = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            Vector charsInWord = new Vector();
            for (int j = 0; j < words[i].length(); j++)
                if (!charsInWord.contains(words[i].charAt(j))) {
                    countDifferentChars[i]++;
                    charsInWord.add(words[i].charAt(j));
                }
        }
    }

    public String GetMinValue() {
        int min = Integer.MAX_VALUE, min_index = 0;
        for (int i = 0; i < countDifferentChars.length; i++)
            if (countDifferentChars[i] < min) {
                min = countDifferentChars[i];
                min_index = i;
            }
        return words[min_index];
    }
}