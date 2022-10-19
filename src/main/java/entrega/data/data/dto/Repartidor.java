package entrega.data.data.dto;

public class Repartidor {

    private int idrepartidor;
    private String nombre;
    private String telefono;
    private String placamoto;

    public Repartidor() {

    }

    public int getIdrepartidor() {
        return idrepartidor;
    }

    public void setIdrepartidor(int idrepartidor) {
        this.idrepartidor = idrepartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPlacamoto() {
        return placamoto;
    }

    public void setPlacamoto(String placamoto) {
        this.placamoto = placamoto;
    }
}
