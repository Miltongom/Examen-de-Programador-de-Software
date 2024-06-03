package com.umg;

import java.util.Scanner;

public class Factorial {

    public static int calcularFactorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * calcularFactorial(numero - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;

        while (repetir) {
            System.out.print("Ingrese un número entero para calcular su factorial: ");

            try {
                int num = scanner.nextInt();
                if (num < 0) {
                    System.out.println("El factorial no está definido para números negativos.");
                } else {
                    int resultado = calcularFactorial(num);
                    System.out.print(num + "! = ");
                    for (int i = num; i > 0; i--) {
                        System.out.print(i);
                        if (i != 1) {
                            System.out.print(" * ");
                        }
                    }

                    System.out.println(" = " + resultado);
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                scanner.next();
            }

            System.out.print("¿Desea calcular otro factorial? (si/no): ");
            String respuesta = scanner.next();
            repetir = respuesta.equalsIgnoreCase("si");
        }

        scanner.close();
        System.out.println("¡Gracias por usar nuestro programa de Cooperativa Guayacan!");
    }
}
