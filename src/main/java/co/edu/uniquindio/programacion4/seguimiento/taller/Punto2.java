package co.edu.uniquindio.programacion4.seguimiento.taller;

import java.util.Arrays;

public class Punto2 {
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4,5,6,7,8,9,10};
        int numero = 3;
        int resultado = busquedaBinaria(arreglo, 0, arreglo.length - 1, numero);
        System.out.println("El numero a encontrar " + numero + " en la busqueda binaria, esta en la pocision de este arreglo" +
                Arrays.toString(arreglo) + " y esta en la pocision " + resultado);
        System.out.println(resultado);
    }
    public static int busquedaBinaria(int[] arreglo, int izquierda, int derecha, int numero) {
        if (izquierda == derecha) {
            return arreglo[derecha];
        }
        int medio = (izquierda + derecha) / 2;
        if (arreglo[medio] == numero) {
            return medio;
        }
        if (arreglo[medio] > numero) {
            return busquedaBinaria(arreglo, izquierda, medio, numero);
        }else {
            return busquedaBinaria(arreglo, medio + 1, derecha, numero);
        }
    }
}
