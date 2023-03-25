package com.diego.bookingproyect.model;

public class Hotel {

    public String name;
    public String imagen;
    public String ublicacion;
    public int posicion;
    public int precio;
    public int habitaciones;

    public Hotel(){}

    public Hotel(String name, String imagen, String ublicacion, int posicion, int precio, int habitaciones) {
        this.name = name;
        this.imagen = imagen;
        this.ublicacion = ublicacion;
        this.posicion = posicion;
        this.precio = precio;
        this.habitaciones = habitaciones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUblicacion() {
        return ublicacion;
    }

    public void setUblicacion(String ublicacion) {
        this.ublicacion = ublicacion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }
}
