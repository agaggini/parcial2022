public class PedidoDomicilio extends Pedido implements Entregable {

    private String domicilio;

    PedidoDomicilio(Usuario usuario, Local local, FormaPago formaPago, String domicilio) {

        super(usuario, local, formaPago);
        this.setDomicilio(domicilio);
    }

    public String getDomicilio() {

        return domicilio;
    }

    public void setDomicilio(String domicilio) {

        this.domicilio = domicilio;
    }

    @Override
    public StringBuilder entregarPedido() {

        super.setEntregado(true);

        StringBuilder salida = new StringBuilder();
        salida.append("=============================\n");
        salida.append("Pedido Entregado en Domicilio\n");
        salida.append("=============================\n");
        salida.append("Nombre: ").append(this.getUsuario().getNombre()).append("\n");
        salida.append("Domicilio: ").append(this.getDomicilio()).append("\n");
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
