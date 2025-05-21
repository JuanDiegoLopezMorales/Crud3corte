package model;

import java.io.Serializable;

public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;
    private String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}
