package main.java.part01.lesson12.task01;


import java.sql.*;

import static main.java.part01.lesson12.task01.SettingsDB.*;
import static main.java.part01.lesson12.task01.SettingsDB.checkConnectDB;

public class Main {

    public static void main(String[] args) {
        checkConnectDB();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String sql = "insert into \"user\"(name, birthday, login_id, city, email, description)" +
                    " values ('Name 1', TO_DATE('17/12/2015', 'DD/MM/YYYY')," +
                    " 'login1', 'city1', 'email1', 'desc1')";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String tableName = "\"user\"";
            String fieldsToInsertUser = "name, birthday, login_id, city, email, description";
            String valueToInsertUser = "'Name 2', TO_DATE('18/12/2005', 'DD/MM/YYYY')," +
            " 'login2', 'city2', 'email2', 'desc2'";
            String sql = String.format("insert into %s(%s) values (%s)",
                    tableName, fieldsToInsertUser, valueToInsertUser);
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        String [] queries = {
                "insert into \"user\"(name, birthday, login_id, city, email, description)" +
                        " values ('Name Br1', TO_DATE('17/12/2005', 'DD/MM/YYYY')," +
                        " 'loginBr1', 'cityBr1', 'emailBr1', 'descBr1')",
                "insert into \"user\"(name, birthday, login_id, city, email, description)" +
                        " values ('Name Br2', TO_DATE('17/12/2010', 'DD/MM/YYYY')," +
                        " 'loginBr2', 'cityBr2', 'emailBr2', 'descBr2')",
                "insert into \"user\"(name, birthday, login_id, city, email, description)" +
                        " values ('Name Br3', TO_DATE('17/12/2015', 'DD/MM/YYYY')," +
                        " 'loginBr3', 'cityBr3', 'emailBr3', 'descBr3')"
        };
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();

            for (String query : queries) {
                statement.addBatch(query);
            }
            statement.executeBatch();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String tableName = "\"user\"";

            String sql = String.format("select * from %s where login_ID=%s and name=%s",
                    tableName, "'login1'", "'Name 1'");
            ResultSet result  = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.toString());
            }

            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
