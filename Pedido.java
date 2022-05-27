import java.util.ArrayList;

public class Pedido {

    private Usuario usuario;
    private Local local;
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private FormaPago formaPago;
    private boolean entregado = false;

    Pedido(Usuario usuario, Local local, FormaPago formaPago) {

        this.usuario = usuario;
        this.local = local;
        this.formaPago = formaPago;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public FormaPago getFormaPago() {

        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {

        this.formaPago = formaPago;
    }

    public void addPlato(Plato plato) {

        this.getPlatos().add(plato);
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public boolean isEntregado() {

        return entregado;
    }

    public void setEntregado(boolean entregado) {

        this.entregado = entregado;
    }

    public double getSubTotal() {
        double subtotal = 0;

        for (Plato x : this.getPlatos()) {
            subtotal += x.getPrecio();
        }
        return subtotal;
    }

    public double getTotal() {
        double subtotal = this.getSubTotal();
        double total = 0;

        total = subtotal + (subtotal * this.getFormaPago().getRecargo() / 100);
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "usuario=" + usuario +
                ", platos=" + getPlatos() +
                ", formaPago=" + formaPago +
                '}';
    }
}
