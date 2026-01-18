/*

* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template

 */
package main;

/**
 *
 * @author ignac
 */

public class RelojDigital {

    public static void main(String[] args) {
        int[] reloj = new int[4];
        int opc;
        iniciarReloj(reloj);
        do {
            mostrarReloj(reloj);
            opc = menu();
            switch (opc) {
                case 1:
                    adelantarHora(reloj);
                    break;
                case 2:
                    retrasarHora(reloj);
                    break;
                case 3:
                    adelantarMinuto(reloj);
                    break;
                case 4:
                    retrasarMinuto(reloj);
                    break;
            }
        } while (opc != 0);
    }

    public static void mostrarReloj(int[] reloj) {
        System.out.println(reloj[0] + "" + reloj[1] + ":" + reloj[2] + reloj[3]);
    }

    public static void iniciarReloj(int[] reloj) {
        reloj[0] = 0;
        reloj[1] = 0;
        reloj[2] = 0;
        reloj[3] = 0;
    }

    public static void adelantarHora(int[] reloj) {
        if (reloj[1] < 9) {
            reloj[1]++;
            if (reloj[0] == 2 && reloj[1] > 3) {
                reloj[0] = 0;
                reloj[1] = 0;
            }
        } else {
            reloj[1] = 0;
            if (reloj[0] < 2) {
                reloj[0]++;
            } else {
                reloj[0] = 0;
                reloj[1] = 0;
            }
        }
    }

    public static void retrasarHora(int[] reloj) {
        if (reloj[1] > 0) {
            reloj[1]--;
        } else {
            reloj[1] = 9;
            if (reloj[0] > 0) {
                reloj[0]--;
                if (reloj[0] == 2 && reloj[1] > 3) {
                    reloj[0] = 1;
                    reloj[1] = 9;
                }
            } else {
                reloj[0] = 2;
                reloj[1] = 3;
            }
        }
    }

    public static void adelantarMinuto(int[] reloj) {
        if (reloj[3] < 9) {
            reloj[3]++;
        } else {
            reloj[3] = 0;
            if (reloj[2] < 5) {
                reloj[2]++;
            } else {
                reloj[2] = 0;
                adelantarHora(reloj);
            }
        }
    }

   
    public static void retrasarMinuto(int[] reloj) {
        if (reloj[3] > 0) {
            reloj[3]--;
        } else {
            reloj[3] = 9;
            if (reloj[2] > 0) {
                reloj[2]--;
            } else {
                reloj[2] = 5;
                retrasarHora(reloj);
            }
        }
    }

    public static int menu() {
        System.out.println("1. Adelantar hora");
        System.out.println("2. Retrasar hora");
        System.out.println("3. Adelantar minuto");
        System.out.println("4. Retrasar minuto");
        System.out.println("0. Salir");
        return new java.util.Scanner(System.in).nextInt();
    }
}
