package service;

import model.Equipo;
import repository.EquipoRepository;

import java.util.ArrayList;
import java.util.List;

public class EquipoService {
    private final EquipoRepository repository;
    private List<Equipo> equipos;

    public EquipoService() {
        this.repository = new EquipoRepository();
        this.equipos = repository.cargarEquipos();
    }

    public void crearEquipo(int id, String nombre, String ciudad) {
        equipos.add(new Equipo(id, nombre, ciudad));
        repository.guardarEquipos(equipos);
    }

    public List<Equipo> listarEquipos() {
        return new ArrayList<>(equipos);
    }

    public boolean actualizarEquipo(int id, String nuevoNombre, String nuevaCiudad) {
        for (Equipo e : equipos) {
            if (e.getId() == id) {
                e.setNombre(nuevoNombre);
                e.setCiudad(nuevaCiudad);
                repository.guardarEquipos(equipos);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEquipo(int id) {
        boolean removed = equipos.removeIf(e -> e.getId() == id);
        if (removed) repository.guardarEquipos(equipos);
        return removed;
    }
}
