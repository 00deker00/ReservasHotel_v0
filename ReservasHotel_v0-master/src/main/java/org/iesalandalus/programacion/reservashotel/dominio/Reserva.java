package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reserva {

    private final int MAX_NUMERO_MESES_RESERVA=15;
    private final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public final String FORMATO_FECHA_RESERVA="dd/MM/yyyy";
    public final String FORMATO_FECHA_HORA_RESERVA="dd/MM/yyyy hh:mm";

    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private double precio;
    private int numeroPersonas;

    //HACER LOS NULOS

    public Reserva(Huesped huesped, Habitacion habitacion, Regimen regimen, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, int numeroPersonas){
        setHuesped(huesped);
        setHabitacion(habitacion);
        setRegimen(regimen);
        setFechaInicioReserva(fechaInicioReserva);
        setFechaFinReserva(fechaFinReserva);
        this.checkIn=null;
        this.checkOut=null;
        setNumeroPersonas(numeroPersonas);
        this.precio=0.0;



    }
    //REVISAR ALGO HICE MAL   ;( Primera versión es la de abajo
/*
    public Reserva(Reserva reserva){
        setHuesped(reserva.getHuesped());
        setHabitacion(reserva.getHabitacion);
        setRegimen(reserva.getRegimen);
        setFechaInicioReserva(reserva.getFechaInicioReserva);
        setFechaFinReserva(reserva.getFechaFinReserva);
        setCheckIn(reserva.getCheckIn);
        setCheckOut(reserva.getCheckOut);
        setNumeroPersonas(reserva.getNumeroPersonas);
        setPrecio(reserva.getPrecio);

    */
    public Reserva(Reserva reserva){
        setHuesped(reserva.getHuesped);
        setHabitacion(reserva.getHabitacion);
        setRegimen(reserva.getRegimen);
        setFechaInicioReserva(reserva.getFechaInicioReserva);
        setFechaFinReserva(reserva.getFechaFinReserva);
        setCheckIn(reserva.getCheckIn);
        setCheckOut(reserva.getCheckOut);
        setNumeroPersonas(reserva.getNumeroPersonas);
        setPrecio(reserva.getPrecio);

    }


    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        if (regimen== null)
            throw new NullPointerException("aaaaa");
        this.regimen = regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
        if (fechaInicioReserva==null)
            throw new NullPointerException("Fecha inicio null");

        if (fechaInicioReserva.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("fecha no puede ser anterior");

        if (fechaInicioReserva.isAfter(LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA)))
            throw new IllegalArgumentException("La fecha se sale del rango");


        this.fechaInicioReserva = fechaInicioReserva;
    }

    public Localdate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(Localdate fechaFinReserva) {

        if (fechaFinReserva==null)
            throw new NullPointerException("nulofinreserva");
        if (fechaFinReserva.isBefore(fechaInicioReserva))
            throw new IllegalArgumentException("kaka");

        this.fechaFinReserva = fechaFinReserva;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        //HACER NULO if null
        if (checkIn.isBefore(fechaInicioReserva.atTime(00,01)))
            throw new IllegalArgumentException("Fail");
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        //COMPROBAR NULOif null
        if (checkOut.isBefore(checkIn))
            throw new IllegalArgumentException("checkout mal");
        if (checkOut.isAfter(fechaFinReserva.atStartOfDay().plusHours(MAX_HORAS_POSTERIOR_CHECKOUT)))
            throw new IllegalArgumentException("Vaya con los tests");


        this.checkOut = checkOut;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        int diasReservados = Period.between(fechaInicioReserva, fechaFinReserva).getDays();
        this.precio = (habitacion.getPrecio() * diasReservados) + (getNumeroPersonas() * regimen.getIncrementoPrecio() * diasReservados);
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {

        if (numeroPersonas<0 || numeroPersonas>habitacion.getTipoHabitacion().getNumeroMaximoPersonas())
            throw new IllegalArgumentException("askjdnaskj");
        if (numeroPersonas>habitacion.getTipoHabitacion().getNumeroMaximoPersonas())
            throw new IllegalArgumentException("no pueden entrar más gente que sitio");


        this.numeroPersonas = numeroPersonas;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(habitacion, reserva.habitacion) && Objects.equals(fechaInicioReserva, reserva.fechaInicioReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, fechaInicioReserva);
    }


    @Override
    public String toString() {
        return String.format("Huesped: %s %s Habitacion:%s - Fecha Inicio Reserva: %s Fecha Fin Reserva: %s Checkin: %s Checkout: %s Precio: %.2f Personas: %d",
                getHuesped().getNombre(), getHuesped().getDni(),
                getHabitacion().getIdentificador(),getHabitacion().getTipoHabitacion(),
                getFechaInicioReserva().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA)),
                getFechaFinReserva().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA)),
                getCheckIn() != null ? getCheckIn().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA_RESERVA)) : "No registrado",
                getCheckOut() != null ? getCheckOut().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA_RESERVA)) : "No registrado",
                getPrecio(),
                getNumeroPersonas());
    }







}
