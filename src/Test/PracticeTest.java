package Test;

import java.util.*;

public class PracticeTest {
    public static void main(String[] args) {
        String str = "AABCCCDEEFF";
        char[] characters = str.toCharArray();
        boolean[] visited = new boolean[str.length()];


        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) continue;
            int count = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (characters[i] == characters[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            System.out.println(characters[i] + " " + count);
        }
    }
}


