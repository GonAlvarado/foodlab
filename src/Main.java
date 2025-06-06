import com.foodlab.servicios.PedidoService;
import com.foodlab.servicios.ProductoService;

import java.util.Scanner;

public class Main {
    private static final ProductoService prods = new ProductoService();
    private static final PedidoService peds = new PedidoService(prods);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                
                >>>>>>>>>> ¡Bienvenida/o a FoodLab! <<<<<<<<<<""");

        while(opcion != 7){
            System.out.println("""
                
                Ingrese una de las opciones para continuar:
                
                1 - Agregar producto
                2 - Listar productos
                3 - Buscar/Actualizar producto
                4 _ Eliminar producto
                5 - Crear pedido
                6 - Listar pedidos
                7 - Salir
                """);

            System.out.print("Opción: ");
            String entrada = scanner.nextLine().trim();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                continue;
            }

            switch (opcion) {
                case 1 -> prods.agregarProducto();
                case 2 -> prods.listarProductos();
                case 3 -> prods.buscarProducto();
                case 4 -> prods.eliminarProducto();
                case 5 -> peds.crearPedido();
                case 6 -> peds.listarPedidos();
                case 7 -> System.out.println("\nGracias por utilizar nuestro sistema. ¡Hasta luego!\n");
                default -> System.out.println("⚠️ Opción no válida. Por favor, elija entre 1 y 7.");
            }
        }
    }
}
