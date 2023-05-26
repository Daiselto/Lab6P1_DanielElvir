/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_danielelvir;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Lab6P1_DanielElvir {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {
            System.out.println("Menu");
            System.out.println("1. ¿Cuantos primos tienes?");
            System.out.println("2. Frecuencia de letras");
            System.out.println("3. Para salir");
            System.out.println("Ingrese una opción");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el tamaño del arreglo");
                    int arreglo = leer.nextInt();

                    boolean masque = true;
                    while (masque) {
                        if (arreglo <= 1) {
                            System.out.println("ERROR");
                            System.out.println("El tamaño del arreglo tiene que ser mayor que 1");
                            System.out.println("");
                            System.out.println("Ingrese el tamaño del arreglo");
                            arreglo = leer.nextInt();
                        } else {
                            masque = false;
                        }
                    }

                    System.out.println("Ingrese el limite inferior");
                    int lim_inf = leer.nextInt();
                    System.out.println("Ingrese el limite superior");
                    int lim_sup = leer.nextInt();

                    boolean mayor = true;
                    while (mayor) {
                        if (lim_inf > lim_sup) {
                            System.out.println("ERROR");
                            System.out.println("El limite inferior debe ser menor al superior");
                            System.out.println("");
                            System.out.println("Ingrese el limite inferior");
                            lim_inf = leer.nextInt();
                            System.out.println("Ingrese el limite superior");
                            lim_sup = leer.nextInt();
                        } else {
                            mayor = false;
                        }
                    }

                    System.out.println("Arreglo generado:");
                    int[] generado = genRandArray(arreglo, lim_inf, lim_sup);
                    Imprimir(generado);
                    System.out.println("");
                    System.out.println("No. Divisores Primos");
                    Imprimir(getTotalPrimeCount(generado));
                    System.out.println("");
                    break;
                }
                case 2: {
                    boolean minuscula = true;
                    System.out.println("Ingrese una palabra");
                    String palabra = leer.next().toLowerCase();
                    
                    

                   Imprimir(extraerFrecuencias(palabra));
                    System.out.println("");
                    System.out.println("[a] [b] [c] [d] [e] [f] [g] [h] [i] [j] [k] [l] [m] [n] [o] [p] [q] [r] [s] [t] [u] [v] [w] [x] [y] [z] [otro]");

                    break;
                }

                case 3: {
                    System.out.println("Gracias por usar el programa");
                    seguir = false;
                }
            }
        }
    }

    public static void Imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]" + " ");
        }
    }

    public static int[] genRandArray(int array, int inf, int sup) {

        int[] temporal = new int[array];
        for (int i = 0; i < array; i++) {
            temporal[i] = inf + ran.nextInt(sup);

        }
        return temporal;
    }

    public static boolean isPrime(int numero) {
        int contador_ciclo = 1;
        int contador_cero = 0;
        boolean primo = false;
        while (contador_ciclo <= numero) {
            if (numero % contador_ciclo == 0) {
                contador_cero++;
            }
            contador_ciclo++;
        }

        if (contador_cero == 2) {
            primo = true;
        } else {
            primo = false;
        }
        return primo;
    }

    public static int countPrimeFactors(int contar) {
        int cont_prim = 0;
        for (int i = 1; i <= contar; i++) {
            if (isPrime(i) == true) {
                if (contar % i == 0) {
                    cont_prim++;
                }
            }
        }
        return cont_prim;
    }

    public static int[] getTotalPrimeCount(int[] enteros) {
        int[] temporal = new int[enteros.length];

        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = countPrimeFactors(enteros[i]);
        }
        return temporal;
    }

    public static int[] extraerFrecuencias(String palabra) {
        int[] temporal = new int[27];
        String letras = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            int index = letras.indexOf(c);
            if (index != -1) {
                temporal[index]++;
            }else{
                temporal[26]++;
            }
        }
  
        return temporal;
        }
    }
