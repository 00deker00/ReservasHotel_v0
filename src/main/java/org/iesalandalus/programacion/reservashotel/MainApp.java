package org.iesalandalus.programacion.reservashotel;


import java.time.LocalDate;

public class MainApp {
    
    public static void main(String[] args) {
        System.out.println("Hasta luego!!!!");
String dni = "76634995f";
        Huesped h1 = new Huesped("Juan canton","656324247","skjnada@gmaskl.com","75724485k", LocalDate.of(1993,12,3));
        System.out.println(h1.toString());

        System.out.println(h1.formateaNombre("pepe luis       "));
        System.out.println(h1.comprobarLetraDni("76634995F"));
        System.out.println(h1.comprobarLetraDni("76634995f"));
        System.out.println(h1.comprobarLetraDni("76634995p"));
        System.out.println(dni.toUpperCase().charAt(8));
    }
}
