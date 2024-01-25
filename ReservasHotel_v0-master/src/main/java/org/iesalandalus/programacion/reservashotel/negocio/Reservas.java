package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Reserva;

import javax.naming.OperationNotSupportedException;


//Buscar ejemplos todo
public class Reservas {

    private Reserva[] coleccionReservas;
    private int capacidad;
    private int tamano;

    public Reservas(int capacidad){
        if (capacidad<=0)
            throw new IllegalArgumentException("capacidad no puede ser negativa");
        this.coleccionReservas= new Reserva[capacidad];
        this.capacidad=capacidad;
        this.tamano=0;
    }
    public Reserva[] get(){
        return copiaProfundaReservas();
    }

    private Reserva[] copiaProfundaReservas(){
        Reserva[] copia = new Reserva[getCapacidad()];

        for (int i=0; i<getCapacidad(); i++)
            copia[i] = new Reserva(coleccionReservas[i]);

        return copia;
    }

    //Pedir ayuda
    public void insertar(Reserva reserva) throws OperationNotSupportedException {
        if (reserva==null)
            throw new NullPointerException("reserva != null");
        if (tamano>=getCapacidad())
            throw new OperationNotSupportedException("El array esta lleno");
        //TODO: ya está

        coleccionReservas[tamano] = new Reserva(reserva);
        tamano++;
    }

    private int buscarIndice(Reserva reserva){
        if (reserva==null)
            throw new NullPointerException("busca reserva =!null");

        int indice = -1;

        for (int i=0; i < getTamano() ; i++)
            if (reserva.equals(coleccionReservas[i]))
                indice = i;

        return indice;
    }

    //CORREGIR CUANDO ESTÉ TERMINADO TODO
    private boolean tamanoSuperado(int indice){
        if (indice > tamano)
            return true;

        return false;
    }

    private boolean capacidadSuperada(int indice){
        if (indice>capacidad)
            return true;

        return false;
    }

    public Reserva buscar(Reserva reserva){
        if (reserva == null)
            throw new NullPointerException("no nulo");

        int busqueda = buscarIndice(reserva);

        if (busqueda == -1)
            return null;

        return reserva;
    }

    //Debería ser algo parecido todo
    public void borrar(Reserva reserva)throws OperationNotSupportedException{
        if (reserva==null)
            throw new NullPointerException("reserva nulo borrar");
        if (buscar(reserva) == null)
            throw new IllegalArgumentException("el reserva no está en el array");

        int indiceBorrado = buscarIndice(reserva);
        coleccionReservas[indiceBorrado] = null;
        desplazarUnaPosicionHaciaIzquierda(indiceBorrado);
        tamano--;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice)throws OperationNotSupportedExceptionn{
        if (indice<0 || indice > capacidad)
            throw new OperationNotSupportedException("No se puede, fuera array");

        for (int i = indice; i<getTamano() ; i++)
            coleccionReservas[i] = new Reserva(coleccionReservas[i+1]);

        coleccionReservas[getTamano()] = null;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTamano() {
        return tamano;
    }
}







}
