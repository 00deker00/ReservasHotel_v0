package org.iesalandalus.programacion.reservashotel;

public class TipoHabitacionClase {

    String cadenaAMostrar;
    int numeroMaximoPersonas;

    public TipoHabitacionClase(String cadenaAMostrar, int numeroMaximoPersonas) {
        this.cadenaAMostrar = cadenaAMostrar;
        this.numeroMaximoPersonas = numeroMaximoPersonas;
    }

    public int getNumeroMaximoPersonas() {
        return numeroMaximoPersonas;
    }

    @Override
    public String toString() {
        return "TipoHabitacionClase{" +
                "cadenaAMostrar='" + cadenaAMostrar + '\'' +
                ", numeroMaximoPersonas=" + numeroMaximoPersonas +
                '}';
    }
}
