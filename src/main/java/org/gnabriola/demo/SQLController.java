package org.gnabriola.demo;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;

public class SQLController {

    String url;
    String uname;
    String pass;

    public SQLController() {
        url = "jdbc:postgresql://localhost:5432/sqlcourse";
        uname = "postgres";
        pass = "postgressive56";
    }

    public ArrayList<String> getMembersAsList() throws SQLException {
        ArrayList<String> result = new ArrayList<>();
        String sql = "SELECT * FROM students_table;";

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            result.add(Integer.toString(rs.getInt(1)) + " - " +
                    rs.getString(2) + " - " +
                    Integer.toString(rs.getInt(3)));
        }

        return result;
    }

    public void deleteMember(int id) throws SQLException {
        String sql = "DELETE FROM students_table WHERE id = " + id + ";";

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();
        try {
            ResultSet rs = st.executeQuery(sql);
        } catch (PSQLException exc) {
            System.out.println(exc);
        }
    }

}
