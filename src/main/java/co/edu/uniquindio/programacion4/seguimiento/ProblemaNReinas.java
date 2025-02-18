package co.edu.uniquindio.programacion4.seguimiento;

public class ProblemaNReinas {
    static int count = 0;
    public static void main(String[] args) {
        int n = 8;
        nReinas(n);
    }

    public static void nReinas(int n) {
        char[][] tablero = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = '□';
            }
        }

        solucion(tablero, 0);
    }

    private static boolean solucion(char[][] tablero, int fila) {
        boolean seEncontroSolucion = false; // Variable para indicar si se encontró alguna solución

        // Si se han colocado todas las reinas, se ha encontrado una solución
        if (fila == tablero.length) {
            if (esSolucion(tablero)) {
                count++;
                System.out.println("Solución correcta: " + count);
                imprimirTablero(tablero);
                seEncontroSolucion = true; // Se encontró una solución
            } else {
                System.out.println("Aún no es solución:");
                imprimirTablero(tablero);
            }
            return seEncontroSolucion; // Se encontró o no una solución, pero se retorna para seguir buscando
        }

        // Probar cada columna de la fila actual
        for (int columna = 0; columna < tablero.length; columna++) {
            // Comprobar si la posición es segura
            if (esSegura(tablero, fila, columna)) {
                // Colocar la reina en la posición segura
                tablero[fila][columna] = 'R';

                // Llamar recursivamente para la siguiente fila
                if (solucion(tablero, fila + 1)) {
                    seEncontroSolucion = true; // Se encontró una solución en la rama actual
                }

                // Si no se encuentra una solución, retroceder y quitar la reina
                tablero[fila][columna] = '□';
            }
        }
        return seEncontroSolucion; // Retornar si se encontró o no alguna solución en esta rama
    }

    private static boolean esSegura(char[][] tablero, int fila, int columna) {
        // Comprobar si hay reinas en la misma columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 'R') {
                return false;
            }
        }

        // Comprobar diagonales superiores
        for (int i = fila - 1, j = columna - 1; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 'R') {
                return false;
            }
        }

        for (int i = fila - 1, j = columna + 1; i >= 0 && j < tablero.length; i--, j++) {
            if (tablero[i][j] == 'R') {
                return false;
            }
        }

        return true;
    }

    private static boolean esSolucion(char[][] tablero) {
        // Comprobar si hay N reinas en el tablero
        int cantidadReinas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 'R') {
                    cantidadReinas++;
                }
            }
        }
        if (cantidadReinas != tablero.length) {
            return false;
        }

        // Comprobar si las reinas no se atacan entre sí
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 'R') {
                    if (!esSegura(tablero, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}