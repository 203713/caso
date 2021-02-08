public class Refresco{
    String marca;
    String presentacion;
    double precio;
    boolean descuento;

    public Refresco(String marca, String presentacion, double precio, boolean descuento){
        this.marca=marca;
        this.presentacion=presentacion;
        this.precio=precio;
        this.descuento=descuento;
    }
    public String getMarca(){
        return marca;
    }
    public String getPresentacion(){
        return presentacion;
    }
    public double getPrecio(){
        return precio;
    }
    public boolean Descuento(){
        return descuento;
    }
    public void setMarca(String marca) {
        this.marca=marca;
    }
    public void setPresentacion(String presentacion) {
        this.presentacion=presentacion;
    }
    public void setMPrecio(double precio) {
        this.precio=precio;
    }
    public void setDescuento(boolean descuento) {
        this.descuento=descuento;
    }
}