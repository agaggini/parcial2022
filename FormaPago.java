public class FormaPago {

    private String nombre;
    private double recargo;

    FormaPago(String nombre, double recargo) {

        this.nombre = nombre;
        this.recargo = recargo;
    }
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public double getRecargo() {

        return recargo;
    }

    public void setRecargo(double recargo) {

        this.recargo = recargo;
    }

    @Override
    public String toString() {
        return "FormaPago{" +
                "nombre='" + nombre + '\'' +
                ", recargo=" + recargo +
                '}';
    }
}
