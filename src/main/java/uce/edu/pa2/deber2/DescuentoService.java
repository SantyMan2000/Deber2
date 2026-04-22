package uce.edu.pa2.deber2;

import jakarta.enterprise.context.Dependent;

@Dependent
public class DescuentoService {

    private static int contador = 0;
    private int id;

    public DescuentoService() {
        contador++;
        id = contador;
        System.out.println("DescuentoService creado ID: " + id);
    }

    public double aplicarDescuento(double total) {
        return total * 0.9;
    }

    public int getId() {
        return id;
    }
}