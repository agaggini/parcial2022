import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

        Usuario user1 = new Usuario("username1");
        user1.setNombre("Juan de los Palotes");

        Usuario user2 = new Usuario("username2");
        user2.setNombre("Maria de los Dolores");

        Local local1 = new Local("Local 1");
        Local local2 = new Local("Local 2");

        local1.addFormaPago(new FormaPago("Contado", 0));
        local1.addFormaPago(new FormaPago("Tarjeta", 10));

        local2.addFormaPago(new FormaPago("Contado", -5));
        local2.addFormaPago(new FormaPago("Tarjeta", 5));

        local1.addPlato(new Plato("Ravioles", 120));
        local1.addPlato(new Plato("Carne", 230));
        local1.addPlato(new Plato("Milanesa", 150));

        local2.addPlato(new Plato("Tarta JyQ", 150));
        local2.addPlato(new Plato("Tortilla Verduras", 90));
        local2.addPlato(new Plato("Flan", 150));

        Pedido pedido1 = new PedidoDomicilio(user1, local1, local1.getFormaPago(1), "Calle Cangrejos 321");
        Plato plato1Pedido1 = local1.getPlato(1);
        if(plato1Pedido1 != null)
            pedido1.addPlato(plato1Pedido1);
        Plato plato2Pedido1 = local1.getPlato(2);
        if(plato2Pedido1 != null)
            pedido1.addPlato(plato2Pedido1);
        pedidos.add(pedido1);

        Pedido pedido2 = new PedidoMostrador(user2, local2, local2.getFormaPago(0));
        Plato plato1Pedido2 = local2.getPlato(1);
        if(plato1Pedido2 != null)
            pedido2.addPlato(plato1Pedido2);
        Plato plato2Pedido2 = local2.getPlato(0);
        if(plato2Pedido2 != null)
            pedido2.addPlato(plato2Pedido2);
        pedidos.add(pedido2);

        System.out.println(pedido1.toString());
        System.out.println(pedido2.toString());

        for (Pedido x : pedidos) {
            if(x instanceof PedidoDomicilio) {
                PedidoDomicilio pedido = (PedidoDomicilio) x;
                System.out.println(pedido.entregarPedido());
            }

            if(x instanceof PedidoMostrador) {
                PedidoMostrador pedido = (PedidoMostrador) x;
                System.out.println(pedido.entregarPedido());
            }
        }
    }
}
