package com.example.lab3;
import java.lang.Math;
public class FuncionEncriptar {

    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;

    public static String encrypt(String input) throws Exception {
        return customEncrypt(input);
    }

    public static String decrypt(String input) throws Exception {
        return customDecrypt(input);
    }

    private static String customEncrypt(String input) { //Funcion que toma el char y lo transforma en ascii
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            int x = (int) c;
            int y = A * x * x + B * x + C; // Aplicar la función polinomial
            encrypted.append((char) (y % 65536)); // Asegurarse de que el valor esté dentro del rango de los caracteres
        }
        return encrypted.toString();
    }

    private static String customDecrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            int y = (int) c;
            int x = solveQuadraticEquation(A, B, C - y); // Resolver la ecuación cuadrática para obtener el valor original
            decrypted.append((char) x);
        }
        return decrypted.toString();
    }

    private static int solveQuadraticEquation(int a, int b, int c) {
        // Resolver la ecuación cuadrática ax^2 + bx + c = 0
        double discriminant = Math.sqrt(b * b - 4 * a * c);
        double root1 = (-b + discriminant) / (2 * a);
        double root2 = (-b - discriminant) / (2 * a);

        // Devolver la raíz que sea un número entero y esté dentro del rango de caracteres válidos
        if (root1 >= 0 && root1 <= 65535 && root1 == Math.floor(root1)) {
            return (int) root1;
        } else {
            return (int) root2;
        }
    }

    public static String generateKey() {
        // Generar una clave personalizada, si es necesario
        // Aquí podrías generar una clave segura o utilizar una clave predefinida
        return "customKey";
    }
}
