package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Hotel {

    private String nombre, descripcion, pais, ubicacion, url;
    private int id_Hotel, habitaciones, puntuacion;

    public Hotel(String nombre, String descripcion, String pais, String ubicacion, String url, int id_Hotel, int habitaciones, int puntuacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pais = pais;
        this.ubicacion = ubicacion;
        this.url = url;
        this.id_Hotel = id_Hotel;
        this.habitaciones = habitaciones;
        this.puntuacion = puntuacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Hotel() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_Hotel() {
        return id_Hotel;
    }

    public void setId_Hotel(int id_Hotel) {
        this.id_Hotel = id_Hotel;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Hotel{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", pais=" + pais + ", ubicacion=" + ubicacion + ", url=" + url + ", id_Hotel=" + id_Hotel + ", habitaciones=" + habitaciones + ", puntuacion=" + puntuacion + '}';
    }

    public static String toCadena(Hotel hotel) {
        return "Hotel{"
                + "nombre=" + hotel.getNombre() + ", "
                + "descripcion=" + hotel.getDescripcion() + ","
                + "pais=" + hotel.getPais() + ", "
                + "ubicacion=" + hotel.getUbicacion() + ", "
                + "url=" + hotel.getUrl() + ", "
                + "id_Hotel=" + hotel.getId_Hotel() + ", "
                + "habitaciones=" + hotel.getHabitaciones() + ", "
                + "puntuacion=" + hotel.getPuntuacion() + ", precio=" + '}';
    }

    public static String toArrayJSon(ArrayList<Hotel> hoteles) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(hoteles);

        return resp;
    }
}
