package main;

import dao.TaskDAO;
import java.util.Scanner;
import model.Task;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskDAO dao = new TaskDAO();

        int opcion;

        do {
            System.out.println("\n===== GESTOR DE TAREAS =====");
            System.out.println("1. Añadir nueva tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Marcar tarea como completada");
            System.out.println("5. Ver solo tareas pendientes");
            System.out.println("6. Ver solo tareas completadas");
            System.out.println("7. Editar una tarea existente");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // Limpiar salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String title = sc.nextLine();

                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();

                    System.out.print("Fecha límite (YYYY-MM-DD): ");
                    String due = sc.nextLine();

                    Task nueva = new Task(0, title, desc, due, false);
                    dao.insertar(nueva);
                    break;

                case 2:
                    dao.listarTareas();
                    break;
                
                case 3:
                    System.out.println("\n📋 Tareas actuales:");
                    dao.listarTareas(); // Mostrar las tareas primero
                
                    System.out.print("🗑️ Ingrese el ID de la tarea a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();  // limpiar buffer
                
                    dao.eliminarTarea(idEliminar); // Llamada al nuevo método
                    break;
                case 4:
                    System.out.println("\n📋 Tareas actuales:");
                    dao.listarTareas(); // Mostrar tareas antes
                
                    System.out.print("✅ Ingrese el ID de la tarea a marcar como completada: ");
                    int idCompletar = sc.nextInt();
                    sc.nextLine();  // limpiar buffer
                
                    dao.marcarComoCompletada(idCompletar);
                    break;
                case 5:
                    dao.listarPorEstado(false); // pendientes
                    break;
                
                case 6:
                    dao.listarPorEstado(true); // completadas
                    break;
                
                case 7:
                    dao.listarTareas(); // mostrar tareas antes
                    System.out.print("✏️ Ingrese el ID de la tarea a editar: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();
                
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = sc.nextLine();
                
                    System.out.print("Nueva descripción: ");
                    String nuevaDescripcion = sc.nextLine();
                
                    System.out.print("Nueva fecha límite (YYYY-MM-DD): ");
                    String nuevaFecha = sc.nextLine();
                
                    dao.editarTarea(idEditar, nuevoTitulo, nuevaDescripcion, nuevaFecha);
                    break;
                
                case 0:
                    System.out.println("👋 Saliendo...");
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
