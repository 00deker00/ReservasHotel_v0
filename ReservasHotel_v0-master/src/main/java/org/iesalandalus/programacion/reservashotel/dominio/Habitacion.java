package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

    // ATRIBUTOS
    public static final double MIN_PRECIO_HABITACION = 40;
    public static final double MAX_PRECIO_HABITACION = 150;
    public static final int MIN_NUMERO_PUERTA = 0;
    public static final int MAX_NUMERO_PUERTA = 14;
    public static final int MIN_NUMERO_PLANTA = 1;
    public static final int MAX_NUMERO_PLANTA = 3;
    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;

    //CONSTRUCTORES
    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setIdentificador(String.valueOf(planta)+puerta);

        //String.valueOf Concatena la planta y la puerta para generar el identificador
    }

    public Habitacion(Habitacion habitacion){
        if(habitacion==null) {
            throw new NullPointerException("ERROR: No es posible copiar una habitación nula.");
        }

        setPlanta(habitacion.planta);
        setPuerta(habitacion.puerta);
        setPrecio(habitacion.precio);
        setTipoHabitacion(habitacion.tipoHabitacion);
        setIdentificador(String.valueOf(habitacion.planta)+habitacion.puerta);
    }

    //Métodos de acceso y modificación
    public String getIdentificador() {
        return identificador;
    }




    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        if (planta < MIN_NUMERO_PLANTA || planta > MAX_NUMERO_PLANTA) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que " + MIN_NUMERO_PLANTA + " ni mayor que " + MAX_NUMERO_PLANTA + ".");
        } else {
            this.planta = planta;
        }
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        if (puerta < MIN_NUMERO_PUERTA || puerta > MAX_NUMERO_PUERTA) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que " + MIN_NUMERO_PUERTA + " ni mayor que " + MAX_NUMERO_PUERTA + ".");
        } else {
            this.puerta = puerta;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < MIN_PRECIO_HABITACION || precio > MAX_PRECIO_HABITACION) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que " + MIN_PRECIO_HABITACION + " ni mayor que " + MAX_PRECIO_HABITACION + ".");
        } else {
            this.precio = precio;
        }
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
            Objects.requireNonNull(tipoHabitacion,
                  "ERROR: No se puede establecer un tipo de habitación nula.");
            this.tipoHabitacion = tipoHabitacion;
    }




    //SOBRESCRIBIR EL MÉTODO EQUALS
    @Override
    public boolean equals(Object room) {
        if (this == room) return true;
        if (!(room instanceof Habitacion habitacion2)) return false;
        return identificador.equals(habitacion2.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return String.format("identificador=%s (%d-%d), precio habitación=%s, tipo habitación=%s",
                this.identificador, this.planta, this.puerta, this.precio, this.tipoHabitacion);
    }

    /*
    public static final double MIN_PRECIO_HABITACION=40.0;
    public static final double MAX_PRECIO_HABITACION=150.0;

    public static final int MIN_NUMERO_PUERTA=0;
    public static final int MAX_NUMERO_PUERTA=14;

    public static final int MIN_NUMERO_PLANTA=1;
    public static final int MAX_NUMERO_PLANTA=3;

    private String identificador;
    private int planta=1;
    private int puerta=0;
    private double precio=50.0;
    private TipoHabitacion tipoHabitacion;

    //Constructor con parámetros
    public Habitacion(int planta, int puerta, double precio){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
    }

    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion ){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
    }

    //Constructor copia
    public Habitacion(Habitacion habitacion) {
        if(habitacion==null) {
            throw new NullPointerException("ERROR: No es posible copiar una habitación nula.");
        }
        setPlanta(habitacion.getPlanta());
        setPuerta(habitacion.getPuerta());
        setPrecio(habitacion.getPrecio());
        setTipoHabitacion(habitacion.getTipoHabitacion());
    }

    //Getter & Setter
    public String getIdentificador() {
        return identificador;
    }
    private void setIdentificador() {
        if(identificador==null)
            throw new NullPointerException("ERROR: No es posible copiar un identificador nulo");
    }

    public int getPlanta() {
        return planta;
    }
    private void setPlanta(int planta) {
        if(planta<MIN_NUMERO_PLANTA || planta>MAX_NUMERO_PLANTA)
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        this.planta = planta;
    }

    public int getPuerta() {
        return puerta;
    }
    private void setPuerta(int puerta) {
        if(puerta<MIN_NUMERO_PUERTA||puerta>MAX_NUMERO_PUERTA)
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 0 ni mayor que 14.");
        this.puerta = puerta;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if(precio < MIN_PRECIO_HABITACION || precio > MAX_PRECIO_HABITACION)
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150.0.");
        this.precio = precio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if(tipoHabitacion==null){
            throw new NullPointerException("ERROR: No se puede establecer un tipo de habitación nula.");
        }
        this.tipoHabitacion = tipoHabitacion;
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion habitacion)) return false;
        return Objects.equals(getIdentificador(), habitacion.getIdentificador());
    }

    //HashCode
    @Override
    public int hashCode() {
        return Objects.hash(getIdentificador());
    }

    //ToString
    @Override
    public String toString() {
        return "identificador=" + identificador+" (" + planta +"-" + puerta +")" +
                ", precio habitación=" + precio +
                ", tipo habitación=" + tipoHabitacion;
    }*/
}
