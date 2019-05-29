package main.java.part01.lesson12.task01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SettingsDB {

    public SettingsDB() {
    }

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/inno";
    public static final String USER = "postgres";
    public static final String PASS = "root";

    public static void checkConnectDB(){
        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
}
