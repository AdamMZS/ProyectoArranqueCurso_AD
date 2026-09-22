package org.example;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = pedirEntero(scanner, "Selecciona una opción: ");

            switch (opcion) {
                case 1 -> listarTareas(gestor);
                case 2 -> agregarTarea(scanner, gestor);
                case 3 -> completarTarea(scanner, gestor);
                case 4 -> eliminarTarea(scanner, gestor);
                case 5->filtrarTareasPorPrioridad(scanner,gestor);
                case 6 -> {
                    System.out.println("\nCerrando aplicación. ¡Hasta la próxima!");
                    salir = true;
                }
                default -> System.out.println("Opción inválida. Elige un número del 1 al 5.");
            }

            if (!salir) {
                pausar(scanner);
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n========== GESTOR DE TAREAS ==========");
        System.out.println("1. Ver todas las tareas");
        System.out.println("2. Añadir nueva tarea");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Mostrar tarea por prioridad");
        System.out.println("6. Salir");
        System.out.println("======================================");
    }

    private static int pedirEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            }
        }
    }

    private static void listarTareas(GestorTareas gestor) {
        System.out.println("\n--- LISTA DE TAREAS ---");
        List<Tarea> tareas = gestor.obtenerTareas();

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas por el momento.");
            return;
        }

        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    private static void agregarTarea(Scanner scanner, GestorTareas gestor) {
        System.out.println("\n--- AÑADIR TAREA ---");
        System.out.print("Descripción de la tarea: ");
        String descripcion = scanner.nextLine().trim();
        System.out.println("Prioridad de la tarea");
        String prioridadInput=scanner.nextLine().trim().toLowerCase();
        Prioridad prioridad;
        try{
        prioridad=Prioridad.valueOf(prioridadInput);
        }catch (IllegalArgumentException e){
            System.out.println("Prioridad no válida. Debe ser alta, media o baja.");
            return;
        }
        if (descripcion.isBlank()) {
            System.out.println("Error: La descripción no puede estar vacía.");
            return;
        }
        gestor.agregarTarea(prioridad,descripcion);
        System.out.println("✓ Tarea añadida con éxito.");
    }

    private static void completarTarea(Scanner scanner, GestorTareas gestor) {
        System.out.println("\n--- COMPLETAR TAREA ---");
        if (gestor.obtenerTareas().isEmpty()) {
            System.out.println("No hay tareas disponibles para completar.");
            return;
        }

        int id = pedirEntero(scanner, "Introduce el ID de la tarea a completar: ");
        boolean exito = gestor.marcarComoCompletada(id);

        if (exito) {
            System.out.println("✓ Tarea #" + id + " marcada como completada.");
        } else {
            System.out.println("Error: No se encontró ninguna tarea con el ID " + id + ".");
        }
    }

    private static void eliminarTarea(Scanner scanner, GestorTareas gestor) {
        System.out.println("\n--- ELIMINAR TAREA ---");
        if (gestor.obtenerTareas().isEmpty()) {
            System.out.println("No hay tareas disponibles para eliminar.");
            return;
        }

        int id = pedirEntero(scanner, "Introduce el ID de la tarea a eliminar: ");
        boolean exito = gestor.eliminarTarea(id);

        if (exito) {
            System.out.println("✓ Tarea #" + id + " eliminada correctamente.");
        } else {
            System.out.println("Error: No se encontró ninguna tarea con el ID " + id + ".");
        }
    }

    private static void pausar(Scanner scanner) {
        System.out.print("\nPresiona ENTER para volver al menú...");
        scanner.nextLine();
    }
    private static void filtrarTareasPorPrioridad(Scanner scanner,GestorTareas gestor){
        System.out.println("Que tipo de prioridad quieres filtrar");
        String prioridadInput=scanner.nextLine().trim().toLowerCase();
        Prioridad prioridad;
        try{
            prioridad=Prioridad.valueOf(prioridadInput);
        }catch (IllegalArgumentException e){
            System.out.println("Prioridad no válida. Debe ser alta, media o baja.");
            return;
            }
        List<Tarea> tareas = gestor.buscarPorPrioridad(prioridad);
        System.out.println("----LISTA DE TAREAS POR PRIORIDAD----");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas con esa prioridad2.");
            return;
        }
        for (Tarea t:tareas) {
            System.out.println(t);
        }
    }
}