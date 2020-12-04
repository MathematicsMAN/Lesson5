package ru.GeekBrains.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeHomeWork {
    static final int SIZE = 3;

    static final char DOT_EMPTY = 183; //точка
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';
    static final char HEADER_SYMBOL = '*';

    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static final char[][] map = new char[SIZE][SIZE];
    static int numberInLine;
    static int turnNumbers;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        turnNumbers = SIZE * SIZE;
        initializeNumberInRow();

        System.out.println("Игровое поле: " + SIZE + " X " + SIZE);
        System.out.println("Выиграет тот, кто первый выставит в ряд "
                           + numberInLine + " символов\n");

        fullingMap();
        printMap();
        runGame();
    }

    private static void initializeNumberInRow() {
        if(SIZE < 3){
            System.out.println("Поле должно быть размером не меньше, чем 3*3");
            System.exit(0);
        }
        numberInLine = switch (SIZE) {
            case 3, 4, 5 ->  3;
            case 6, 7, 8, 9 -> 4;
            default -> 5;
        };

    }

    private static void fullingMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeadMap();
        printBodyMap();
    }

    private static void printHeadMap() {
        System.out.printf("%2s",HEADER_SYMBOL);
        for (int i = 0; i < SIZE; i++) {
            printNumber(i + 1);
        }
        System.out.println();
    }

    private static void printNumber(int i) {
        System.out.printf("%2s",i);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printNumber(i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2s",map[i][j]);
            }
            System.out.println();
        }
    }

    private static void runGame() {
        while (true){
            humanTurn();
            printMap();
            checkEndGame(DOT_HUMAN);
            aiTurn();
            printMap();
            checkEndGame(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод человека:");
        do{
            rowNumber = -1;
            columnNumber = -1;
            System.out.print("Введите номер строки: ");
            if(in.hasNextInt()){
                rowNumber = in.nextInt() - 1;
            } else {
                in.next();
                System.out.println("Введённое значение должно быть числом!");
                continue;
            }
            System.out.print("Введите номер столбца: ");
            if(in.hasNextInt()){
                columnNumber = in.nextInt() - 1;
            } else {
                in.next();
                System.out.println("Введённое значение должно быть числом!");
            }
        }while(!(isRightValues(rowNumber,columnNumber) && isCellEmptyHuman(rowNumber,columnNumber)));

        map[rowNumber][columnNumber] = DOT_HUMAN;
        turnNumbers --;
    }

    private static boolean isRightValues(int rowNum, int colNum) {
        if(rowNum < 0 || rowNum >= SIZE || colNum < 0 || colNum >= SIZE){
            System.out.println("Введите правильные значения столбца и строки!");
            return false;
        }
        return true;
    }

    private static boolean isCellEmptyHuman(int rowNum, int colNum) {
        if(!isCellEmpty(rowNum,colNum)){
            System.out.println("Ячейка занята!");
            return false;
        }
        return true;
    }

    private static boolean isCellEmpty(int rowNum, int colNum) {
        return map[rowNum][colNum] == DOT_EMPTY;
    }

    private static void aiTurn() {
        System.out.println("\nХод компьютера:");
        turnNumbers --;
        if(checkAiWin()) return;
        if(checkHumanCanWin()) return;
        anyAiTurn();
    }

    private static boolean checkAiWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellEmpty(i,j)){
                    map[i][j] = DOT_AI;
                    if(isCheckWin(DOT_AI)){
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private static boolean checkHumanCanWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellEmpty(i,j)){
                    map[i][j] = DOT_HUMAN;
                    if(isCheckWin(DOT_HUMAN)){
                        map[i][j] = DOT_AI;
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private static void anyAiTurn() {
        int rowNum, colNum;
        do{
           rowNum = random.nextInt(SIZE);
           colNum = random.nextInt(SIZE);
        }while(!isCellEmpty(rowNum,colNum));
        map[rowNum][colNum] = DOT_AI;
    }

    private static void checkEndGame(char symbol) {
        boolean isEnd = false;
        //ничья
        if(turnNumbers == 0){
            System.out.println("Ходы закончились. Ничья!");
            isEnd = true;
        }
        //Победа человека
        if (isCheckWin(symbol)){
            isEnd = true;
            String message = symbol == DOT_HUMAN ? "Вы победили! Поздравляем!" : "В этот раз победил компьютер";
            System.out.println(message);
        }
        if(isEnd){
            System.exit(0);
        }
    }

    private static boolean isCheckWin(char symbol) {
        if (isCheckWinOnRows(symbol)) return true;

        if (isCheckWinOnColumns(symbol)) return true;

        if (isCheckWinOnMainDiagonals(symbol)) return true;

        return isCheckWinOnSideDiagonals(symbol);
    }

    private static boolean isCheckWinOnRows(char symbol) {
        int sumSymbols;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - numberInLine + 1; j++) {
                sumSymbols = 0;
                for (int k = 0; k < numberInLine; k++) {
                    if(map[i][j + k] == symbol) {
                        sumSymbols++;
                    } else {
                        break;
                    }
                }
                if(sumSymbols == numberInLine){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCheckWinOnColumns(char symbol) {
        int sumSymbols;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE - numberInLine + 1; i++) {
                sumSymbols = 0;
                for (int k = 0; k < numberInLine; k++) {
                    if(map[i + k][j] == symbol) {
                        sumSymbols++;
                    } else {
                        break;
                    }
                }
                if(sumSymbols == numberInLine){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCheckWinOnMainDiagonals(char symbol) {
        int sumSymbols;
        for (int i = 0; i < SIZE - numberInLine + 1; i++) {
            for (int j = 0; j < SIZE - numberInLine + 1; j++) {
                sumSymbols = 0;
                for (int k = 0; k < numberInLine; k++) {
                    if(map[i + k][j + k] == symbol) {
                        sumSymbols++;
                    } else {
                        break;
                    }
                }
                if(sumSymbols == numberInLine){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCheckWinOnSideDiagonals(char symbol) {
        int sumSymbols;
        for (int i = 0; i < SIZE - numberInLine + 1; i++) {
            for (int j = SIZE - 1; j >= numberInLine - 1; j--) {
                sumSymbols = 0;
                for (int k = 0; k < numberInLine; k++) {
                    if(map[i + k][j - k] == symbol) {
                        sumSymbols++;
                    } else {
                        break;
                    }
                }
                if(sumSymbols == numberInLine){
                    return true;
                }
            }
        }
        return false;
    }

}
