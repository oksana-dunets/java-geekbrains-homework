package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GameXO {

    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Human win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            printMap();
            aiTurn();
            printMap();
            if (checkWin(AI_DOT)) {
                System.out.println("AI win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        SCANNER.close();
    }

    public static void initMap() {
        sizeMapX = 3;
        sizeMapY = 3;
        map = new char[sizeMapY][sizeMapX];
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты хода X, Y (от 1 до 3) через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        map[y][x] = HUMAN_DOT;
    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            x = RANDOM.nextInt(sizeMapX);
            y = RANDOM.nextInt(sizeMapY);
        } while (!isEmptyCell(y, x));
        map[y][x] = AI_DOT;
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < sizeMapX && y >= 0 && y < sizeMapY;
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean checkWin(char symbol) {
        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}