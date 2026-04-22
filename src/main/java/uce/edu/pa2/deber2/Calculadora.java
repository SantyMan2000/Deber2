package uce.edu.pa2.deber2;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Calculadora {

    private static int contadorInstancias = 0;
    private int id;

    public Calculadora() {
        contadorInstancias++;
        id = contadorInstancias;
        System.out.println("Calculadora creada ID: " + id);
    }

    public int calcularSubtotal(int precio, int cantidad) {
        return precio * cantidad;
    }

    public int getId() {
        return id;
    }

    public static int getTotalInstancias() {
        return contadorInstancias;
    }
}