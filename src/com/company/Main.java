package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, y = 0, x = 0, count=0;
        boolean EndGame = true, xod = true;
        char fild[][] = new char[3][3];
        
        System.out.println("Выберите режим игры: " + "\n1) Против второго игрока" + "\n2) Против компьютера");
        a = scanner.nextInt()-1;
        if (a == 1) {
            while (!checkVictory(fild)) {
                xod = true;
                System.out.println("Ход игрока X" + "\nВведите координаты, с начала строку потом столбец");
                x = scanner.nextInt()-1;
                y = scanner.nextInt()-1;
                while (xod) {
                    if (x < 3 && y < 3 && x >= 0 && y >= 0 ) {
                        if (fild[x][y] == 0) {
                            fild[x][y] = 'X';
                            xod = false;
                        } else {
                            System.out.println("Поле занято!!!" + "\nПопробуй еще" + "\nВведите координаты, с начала строку потом столбец");
                            x = scanner.nextInt()-1;
                            y = scanner.nextInt()-1;
                        }
                    } else {
                        System.out.println("Это не являеться координатой" + "\nПопробуй еще" + "\nВведите координаты, с начала строку потом столбец");
                        x = scanner.nextInt()-1;
                        y = scanner.nextInt()-1;
                    }
                    vuvod(fild);
                    count++;
                }
                if (checkVictory(fild)) break;
                if (count==9)break;
                xod = true;
                System.out.println("Ход игрока O" + "\nВведите координаты, с начала строку потом столбец");
                x = scanner.nextInt()-1;
                y = scanner.nextInt()-1;
                while (xod) {
                    if (x < 3 && y < 3  && x >= 0 && y >= 0) {
                        if (fild[x][y] == 0) {
                            fild[x][y] = 'O';
                            xod = false;
                        } else {
                            System.out.println("Поле занято!!!" + "\nПопробуй еще" + "\nВведите координаты, с начала строку потом столбец");
                            x = scanner.nextInt()-1;
                            y = scanner.nextInt()-1;
                        }
                    } else {
                        System.out.println("Это не являеться координатой" + "\nПопробуй еще" + "\nВведите координаты, с начала строку потом столбец");
                        x = scanner.nextInt()-1;
                        y = scanner.nextInt()-1;
                    }
                    vuvod(fild);
                    count++;
                }
               if (count==9)break;
            }

           if (count==9){
               for (int i = 0; i < 50; ++i) System.out.println();
               vuvod(fild);
               System.out.println("Ничья)))");
           }
        }

        if (a == 2) {
            Random random = new Random();
            while (!checkVictory(fild)) {
                xod = true;
                System.out.println("Ход игрока X" + "\nВведите координаты, с начала строку потом столбец");
                x = scanner.nextInt()-1;
                y = scanner.nextInt()-1;
                while (xod) {
                    if (x < 3 && y < 3 && x >= 0 && y >= 0) {
                        if (fild[x][y] == 0) {
                            fild[x][y] = 'X';
                            xod = false;
                        } else {
                            System.out.println("Поле занято!!!" + "\nПопробуй еще" + "\nВведите координаты, с начала строку потом столбец");
                            x = scanner.nextInt()-1;
                            y = scanner.nextInt()-1;
                        }
                    } else {
                        System.out.println("Это не являеться координатой" + "\nПопробуй еще" + "\nВведите координаты, с начала строку потом столбец");
                        x = scanner.nextInt()-1;
                        y = scanner.nextInt()-1;
                    }

                }
                vuvod(fild);
                if(checkVictory(fild))break;
                xod = true;
                System.out.println("     Ход компьютера   ");
                while (xod) {
                    x = random.nextInt(3);
                    y = random.nextInt(3);
                    if (fild[x][y]==0){
                        fild[x][y]='O';
                        xod = false;
                    }

                }

            }
            vuvod(fild);
        }
    }


    private static void vuvod(char[][] fild) {
        for (int i = 0; i < fild.length; i++) {
            System.out.println(Arrays.toString(fild[i]));
        }
    }

    public static boolean checkVictory(char[][] fild) {
        boolean Win = false;
        int win = 0;
        int s = 0, ss = 0, w = 0, ww = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][0] == 'X' && fild[j][1] == 'X' && fild[j][2] == 'X') {
                Win = true;
                win = 1;
            }
            if (fild[j][0] == 'O' && fild[j][1] == 'O' && fild[j][2] == 'O') {
                Win = true;
                win = 2;
            }
            if (fild[0][j] == 'X' && fild[1][j] == 'X' && fild[2][j] == 'X') {
                Win = true;
                win = 1;
            }
            if (fild[0][j] == 'O' && fild[1][j] == 'O' && fild[2][j] == 'O') {
                Win = true;
                win = 2;
            }
        }
        if (fild[0][0]=='X' && fild[1][1]=='X' && fild[2][2]=='X'){
            Win = true;
            win = 1;
        }
        if (fild[0][0]=='O' && fild[1][1]=='O' && fild[2][2]=='O'){
            Win = true;
            win = 2;
        }
        if (fild[0][2]=='X' && fild[1][1]=='X' && fild[2][0]=='X'){
            Win = true;
            win = 1;
        }
        if (fild[0][2]=='O' && fild[1][1]=='O' && fild[2][0]=='O'){
            Win = true;
            win = 2;
        }
        if(Win){
            for (int i = 0; i < 50; ++i) System.out.println();
            vuvod(fild);
        }
            if (Win && win==1) System.out.println("The Winnnnner is X!!!");
            if (Win && win==2) System.out.println("The Winnnnner is O!!!");

            return Win;
        }
    }




