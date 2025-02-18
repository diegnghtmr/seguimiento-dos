package co.edu.uniquindio.programacion4.seguimiento.taller;

public class Punto11 {
    public static void main(String[] args) {
        int resultado = potencia(2, 3);
        System.out.println(resultado);
    }
    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potencia(base, exponente - 1);
    }
}
