package model;

public class Tour {

    private String nombre;
    private String tipo;
    private String destino;
    private int precio;

    public Tour(String nombre, String tipo, String destino, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.destino = destino;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tour: " + nombre
                + " | Tipo: " + tipo
                + " | Destino: " + destino
                + " | Precio: $" + precio;
    }
}
