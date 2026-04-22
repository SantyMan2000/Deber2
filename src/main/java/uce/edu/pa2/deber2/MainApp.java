package uce.edu.pa2.deber2;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain; 
import jakarta.inject.Inject;
@jakarta.inject.Singleton
@QuarkusMain 
public class MainApp implements QuarkusApplication {

    @Inject
    PedidoService pedidoService;

    @Inject
    LoggerService logger;

    @Inject
    Calculadora calculadora1;

    @Inject
    Calculadora calculadora2;

    @Inject
    DescuentoService descuento1;

    @Inject
    DescuentoService descuento2;

    @Override
    public int run(String... args) {

        System.out.println("\n===== INICIO SIMULACIÓN =====");

        Producto p1 = new Producto("Laptop", 1000, 1);
        Producto p2 = new Producto("Mouse", 50, 2);

        int subtotal1 = calculadora1.calcularSubtotal(p1.getPrecio(), p1.getCantidad());
        int subtotal2 = calculadora2.calcularSubtotal(p2.getPrecio(), p2.getCantidad());

        int total = subtotal1 + subtotal2;

        double totalConDescuento = descuento1.aplicarDescuento(total);

        int idPedido = pedidoService.generarPedido();

        pedidoService.guardarPedido("Pedido #" + idPedido + " Total: " + totalConDescuento);

        logger.log("Pedido procesado correctamente");

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Pedido ID: " + idPedido);
        System.out.println("Total original: " + total);
        System.out.println("Total con descuento: " + totalConDescuento);

        System.out.println("\n--- SCOPES (EXPLICACIÓN) ---");
        // ApplicationScoped: Mantiene el estado en toda la app
        System.out.println("PedidoService contador: " + pedidoService.getContador());
        // Singleton: Una sola instancia para todos
        System.out.println("Logger total logs: " + logger.getTotalLogs());

        // Dependent: Crea una instancia NUEVA para cada @Inject
        System.out.println("Calculadora1 ID: " + calculadora1.getId());
        System.out.println("Calculadora2 ID: " + calculadora2.getId());

        System.out.println("Descuento1 ID: " + descuento1.getId());
        System.out.println("Descuento2 ID: " + descuento2.getId());

        System.out.println("\n===== FIN SIMULACIÓN =====");

        Quarkus.asyncExit(); 
        return 0;
    }
}