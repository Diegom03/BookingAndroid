package com.diego.bookingproyect.model;

public class Hotel {

    public String nombre;
    public String imagen;
    public String ubicacion;
    public int posicion;
    public int precio;
    public int habitaciones;

    public Hotel(){}

    public Hotel(String nombre, String imagen, String ubicacion, int posicion, int precio, int habitaciones) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.ubicacion = ubicacion;
        this.posicion = posicion;
        this.precio = precio;
        this.habitaciones = habitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
