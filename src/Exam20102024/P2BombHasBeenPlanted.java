package Exam20102024;

import java.util.Scanner;

public class P2BombHasBeenPlanted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dimensions = sc.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] map = new char[rows][cols];
        int counterTerrRow = -1, counterTerrCol = -1;
        int bombRow = -1, bombCol = -1;

        for (int r = 0; r < rows; r++) {
            map[r] = sc.nextLine().toCharArray();
            for (int c = 0; c < cols; c++) {
                if (map[r][c] == 'C') {
                    counterTerrRow = r;
                    counterTerrCol = c;
                } else if (map[r][c] == 'B') {
                    bombRow = r;
                    bombCol = c;
                }
            }
        }

        // 16 seconds to defuse the bomb
        int remainingTime = 16;
        boolean bombDefused = false;
        boolean counterTerrKilled = false;
        boolean bombExploded = false;
        int neededTimeForDefuse = 0;

        label:
        while (true) {
            remainingTime--;
            String command = sc.nextLine();
            switch (command) {
                case "up" -> {
                    if (counterTerrRow > 0) {
                        counterTerrRow--;
                    }
                }
                case "down" -> {
                    if (counterTerrRow < rows - 1) {
                        counterTerrRow++;
                    }
                }
                case "left" -> {
                    if (counterTerrCol > 0) {
                        counterTerrCol--;
                    }
                }
                case "right" -> {
                    if (counterTerrCol < cols - 1) {
                        counterTerrCol++;
                    }
                }
                case "defuse" -> {
                    if (counterTerrRow == bombRow && counterTerrCol == bombCol) {
                        remainingTime -= 3;
                        if (remainingTime >= 0) {
                            bombDefused = true;
                            map[bombRow][bombCol] = 'D';
                            break label;
                        } else {
                            bombExploded = true;
                            map[bombRow][bombCol] = 'X';
                            neededTimeForDefuse = Math.abs(remainingTime);
                            remainingTime = 0;
                            break label;
                        }
                    } else {
                        remainingTime--;
                    }
                }
            }

            if (map[counterTerrRow][counterTerrCol] == 'T') {
                counterTerrKilled = true;
                map[counterTerrRow][counterTerrCol] = '*';
                break;
            }

            if (remainingTime <= 0) {
                bombExploded = true;
                break;
            }
        }

        if (counterTerrKilled) {
            System.out.println("Terrorists win!");
        } else if (bombExploded) {
            System.out.println("Terrorists win!");
            System.out.println("Bomb was not defused successfully!");
            System.out.printf("Time needed: %d second/s.\n", neededTimeForDefuse);
        } else if (bombDefused) {
            System.out.println("Counter-terrorist wins!");
            System.out.printf("Bomb has been defused: %d second/s remaining.\n", remainingTime);
        }

        for (char[] row : map) {
            System.out.println(new String(row));
        }
    }
}

