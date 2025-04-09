package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        String url = "jdbc:sqlite:E:\\task-manager-java\\tasks.db"; // AJUSTA TU RUTA AQUÍ

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }
}


