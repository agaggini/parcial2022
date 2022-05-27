import java.util.ArrayList;

public class Local {

    private String nombre;
    private ArrayList<FormaPago> formasPago = new ArrayList<FormaPago>();
    private ArrayList<Plato> platos = new ArrayList<Plato>();

    Local(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void addFormaPago(FormaPago formaPago) {

        this.formasPago.add(formaPago);
    }

    public void addPlato(Plato plato) {

        this.platos.add(plato);
    }

    public Plato getPlato(int index) {

        if(index < this.platos.size()) {
            return this.platos.get(index);
        }
        return null;
    }

    public Plato getPlato(String nombre) {

        Plato retorno = null;
        for (Plato x : this.platos) {
            if (x.getNombre().equals(nombre))
                retorno = x;
        }
        return retorno;
    }

    public FormaPago getFormaPago(int index) {

        if(index < this.formasPago.size()) {
            return this.formasPago.get(index);
        }
        return null;
    }

    public FormaPago getFormaPago(String nombre) {

        FormaPago retorno = null;
        for (FormaPago x : this.formasPago) {
            if (x.getNombre().equals(nombre))
                retorno = x;
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "Local{" +
                "nombre='" + nombre + '\'' +
                ", formasPago=" + formasPago +
                ", platos=" + platos +
                '}';
    }
}
