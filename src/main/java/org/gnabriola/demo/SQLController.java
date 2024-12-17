package org.gnabriola.demo;
import org.postgresql.util.OSUtil;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        String sql = "SELECT * FROM students_table ORDER BY id;";

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

    public void save(String id, String name, String grades) throws SQLException {

        String sql = "INSERT INTO students_table VALUES(" + id + ", '" + name + "', " + grades + ");";
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();
        try {
            ResultSet rs = st.executeQuery(sql);
        } catch (PSQLException e) {
            System.out.println("lol");
        }
    }

    public Map<Integer, Object> searchMember(int id) throws SQLException {

        String sql = "SELECT * FROM students_table WHERE id = " + id + ";";

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        rs.next();

        Map<Integer, Object> result = new HashMap<>();
        result.put(1, rs.getInt(1));
        result.put(2, rs.getString(2));
        result.put(3, rs.getInt(3));

        return result;
    }

    public void editMember(int id, int memberId, String memberName, int memberGrades) throws SQLException {

        String sql = "UPDATE students_table SET id = ?, name = ?, grades = ? WHERE id = ?;";

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, memberId);
        st.setString(2, memberName);
        st.setInt(3, memberGrades);
        st.setInt(4, id);
        st.executeUpdate();

    }

}
