package dao;

import java.sql.*;
import model.Task;

public class TaskDAO {

    // Método para insertar tareas
    public void insertar(Task task) {
        String sql = "INSERT INTO tasks(title, description, due_date, completed) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getDueDate());
            pstmt.setBoolean(4, task.isCompleted());

            pstmt.executeUpdate();
            System.out.println("✅ Tarea guardada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar tarea: " + e.getMessage());
        }
    }

    // NUEVO: Método para listar tareas
    public void listarTareas() {
        String sql = "SELECT id, title, description, due_date, completed FROM tasks ORDER BY due_date";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("📋 Tareas registradas:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String dueDate = rs.getString("due_date");
                boolean completed = rs.getBoolean("completed");

                String status = completed ? "COMPLETADA" : "PENDIENTE";
                System.out.println(id + " | " + title + " | " + dueDate + " | " + status);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar tareas: " + e.getMessage());
        }
    }

public void eliminarTarea(int id) {
    String sql = "DELETE FROM tasks WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        int filasAfectadas = pstmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("🗑️ Tarea eliminada correctamente.");
        } else {
            System.out.println("⚠️ No se encontró ninguna tarea con ese ID.");
        }

    } catch (SQLException e) {
        System.out.println("❌ Error al eliminar la tarea: " + e.getMessage());
    }
}
public void marcarComoCompletada(int id) {
    String sql = "UPDATE tasks SET completed = 1 WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        int filasAfectadas = pstmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("✅ Tarea marcada como completada.");
        } else {
            System.out.println("⚠️ No se encontró ninguna tarea con ese ID.");
        }

    } catch (SQLException e) {
        System.out.println("❌ Error al actualizar tarea: " + e.getMessage());
    }
}
public void listarPorEstado(boolean completadas) {
    String sql = "SELECT id, title, due_date, completed FROM tasks WHERE completed = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setBoolean(1, completadas);
        ResultSet rs = pstmt.executeQuery();

        System.out.println(completadas ? "✅ Tareas completadas:" : "🕓 Tareas pendientes:");
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String dueDate = rs.getString("due_date");
            boolean completed = rs.getBoolean("completed");

            String status = completed ? "COMPLETADA" : "PENDIENTE";
            System.out.println(id + " | " + title + " | " + dueDate + " | " + status);
        }

    } catch (SQLException e) {
        System.out.println("❌ Error al filtrar tareas: " + e.getMessage());
    }
}
public void editarTarea(int id, String nuevoTitulo, String nuevaDesc, String nuevaFecha) {
    String sql = "UPDATE tasks SET title = ?, description = ?, due_date = ? WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, nuevoTitulo);
        pstmt.setString(2, nuevaDesc);
        pstmt.setString(3, nuevaFecha);
        pstmt.setInt(4, id);

        int filas = pstmt.executeUpdate();

        if (filas > 0) {
            System.out.println("✏️ Tarea actualizada correctamente.");
        } else {
            System.out.println("⚠️ No se encontró ninguna tarea con ese ID.");
        }

    } catch (SQLException e) {
        System.out.println("❌ Error al editar tarea: " + e.getMessage());
    }
}

}
