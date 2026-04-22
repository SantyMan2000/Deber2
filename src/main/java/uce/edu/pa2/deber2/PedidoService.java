package uce.edu.pa2.deber2;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PedidoService {

    private int contador = 1000;
    private List<String> historial = new ArrayList<>();

    public int generarPedido() {
        contador++;
        return contador;
    }

    public void guardarPedido(String pedido) {
        historial.add(pedido);
    }

    public List<String> getHistorial() {
        return historial;
    }

    public int getContador() {
        return contador;
    }
}