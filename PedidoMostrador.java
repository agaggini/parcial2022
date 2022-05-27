public class PedidoMostrador extends Pedido implements Retirable {

    PedidoMostrador(Usuario usuario, Local local, FormaPago formaPago) {

        super(usuario, local, formaPago);
    }

    @Override
    public StringBuilder entregarPedido() {

        super.setEntregado(true);

        StringBuilder salida = new StringBuilder();
        salida.append("=============================\n");
        salida.append("Pedido Entregado en Mostardor\n");
        salida.append("=============================\n");
        salida.append("Nombre: ").append(this.getUsuario().getNombre()).append("\n");
        salida.append("-----------------------------\n");
        for (Plato x : this.getPlatos()) {
            salida.append(x.getNombre()).append("  $").append(x.getPrecio()).append("\n");
        }
        salida.append("Sub Total:             $").append(super.getSubTotal()).append("\n");

        if(this.getFormaPago().getRecargo() > 0)
            salida.append("Recargo ")
                    .append((this.getFormaPago().getNombre()))
                    .append(" ")
                    .append(this.getFormaPago().getRecargo()).append("%")
                    .append("\n");

        if(this.getFormaPago().getRecargo() < 0)
            salida.append("Descuento ")
                    .append((this.getFormaPago().getNombre()))
                    .append(" ")
                    .append(this.getFormaPago().getRecargo()).append("%")
                    .append("\n");

        salida.append("TOTAL                  $").append(super.getTotal()).append("\n");
        salida.append("=============================\n");
        salida.append("\n");
        return salida;
    }
}
