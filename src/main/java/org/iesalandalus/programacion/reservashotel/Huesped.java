package org.iesalandalus.programacion.reservashotel;


import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {
    String ER_TELEFONO;
    String ER_CORREO;
    String ER_iDNI;
    String FORMATO_FECHA;
    String nombre;
    String telefono;
    String correo;
    String dni;
    LocalDate fechaNacimiento;

    public Huesped(String nombre,String telefono, String correo, String dni, LocalDate fechaNacimiento) {
         this.nombre = nombre;
         this.telefono = telefono;
         this.dni = dni;
         this.fechaNacimiento = fechaNacimiento;
    }

    public Huesped(Huesped huesped) {
    }

    public Huesped() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String formateaNombre(String nombre){

        nombre = nombre.trim();
        String aux = String.valueOf(nombre.toUpperCase().charAt(0));
        for (int i=1; i< nombre.length(); i++){
            if (nombre.charAt(i) == ' '){
                aux+= nombre.charAt(i);
                i++;
                aux+= String.valueOf(nombre.toUpperCase().charAt(i));
            }
            else{
                aux+= String.valueOf(nombre.toLowerCase().charAt(i));
            }
        }

        return aux;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

   public boolean comprobarLetraDni (String dni){
        int num;
        char letra_dni;
       Pattern num_dni = Pattern.compile("([0-9]{8}[A-Z,a-z])");
       Matcher num_dni2 = num_dni.matcher(dni);
       if (num_dni2.find()){
           num= Integer.parseInt(dni.substring(0,8));
           int resto;
           resto = num % 23;

           String letras= "TRWAGMYFPDXBNJZSQVHLCKE";
String aux = dni.toUpperCase();
           letra_dni = letras.charAt(resto);
           if (letra_dni==aux.charAt(8)) {
              return true;
           }
        }
       return false;
   }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


  //  public String getIniciales (){}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
