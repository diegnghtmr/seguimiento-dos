package co.edu.uniquindio.programacion4.seguimiento;

public class SumaRecursiva {

    public static void main(String[] args) {
        int[] miLista = {1, 2, 3, 4, 5};
        int resultado = sumaRecursiva(miLista);
        System.out.println("suma = " + resultado);
    }

    public static int sumaRecursiva(int[] lista) {
        // Caso base: Lista vacía
        if (lista.length == 0) {
            return 0;
        }

        // Caso base: Lista con un solo elemento
        if (lista.length == 1) {
            System.out.println("return " + lista[0]);
            return lista[0];
        }

        // Divide: Calcular el punto medio
        int medio = lista.length / 2;

        imprimirArreglo(lista, 0);
        System.out.println();

        // Vence (Recursión): Crear sub-arreglos y sumar cada mitad
        int[] izquierda = new int[medio];
        System.arraycopy(lista, 0, izquierda, 0, medio);

        int[] derecha = new int[lista.length - medio];
        System.arraycopy(lista, medio, derecha, 0, lista.length - medio);

        int sumaIzquierda = sumaRecursiva(izquierda);
        int sumaDerecha = sumaRecursiva(derecha);

        // Conquista (Combina): Sumar los resultados
        int suma = sumaIzquierda + sumaDerecha;
        System.out.println("return " + suma);
        return suma;
    }

    private static void imprimirArreglo(int[] arreglo, int indice) {
        if (indice < arreglo.length) {
            System.out.print(arreglo[indice] + " ");
            imprimirArreglo(arreglo, indice + 1);
        }
    }

}
