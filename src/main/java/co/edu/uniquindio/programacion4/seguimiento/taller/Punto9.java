package co.edu.uniquindio.programacion4.seguimiento.taller;

public class Punto9 {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int resultado = sumaMatriz(matriz, 0, 0);
        System.out.println(resultado);
    }

    public static int sumaMatriz(int[][] matriz, int fila, int columna) {
        if (fila == matriz.length) {
            return 0;
        }
        return matriz[fila][columna] + sumaMatriz(matriz, fila + 1, columna + 1);
    }
}
