import service.EquipoService;
import model.Equipo;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EquipoService servicio = new EquipoService();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Equipos ---");
            System.out.println("1. Crear equipo");
            System.out.println("2. Listar equipos");
            System.out.println("3. Actualizar equipo");
            System.out.println("4. Eliminar equipo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> crearEquipo();
                case 2 -> listarEquipos();
                case 3 -> actualizarEquipo();
                case 4 -> eliminarEquipo();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    private static void crearEquipo() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        servicio.crearEquipo(id, nombre, ciudad);
        System.out.println("Equipo creado.");
    }

    private static void listarEquipos() {
        System.out.println("Lista de Equipos:");
        for (Equipo e : servicio.listarEquipos()) {
            System.out.println(e);
        }
    }

    private static void actualizarEquipo() {
        System.out.print("ID del equipo a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva ciudad: ");
        String ciudad = scanner.nextLine();
        if (servicio.actualizarEquipo(id, nombre, ciudad)) {
            System.out.println("Equipo actualizado.");
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }

    private static void eliminarEquipo() {
        System.out.print("ID del equipo a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (servicio.eliminarEquipo(id)) {
            System.out.println("Equipo eliminado.");
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }
}
