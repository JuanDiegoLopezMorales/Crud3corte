package repository;

import model.Equipo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoRepository {
    private final String archivo = "equipos.dat";

    public List<Equipo> cargarEquipos() {
        File file = new File(archivo);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Equipo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void guardarEquipos(List<Equipo> equipos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(equipos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
