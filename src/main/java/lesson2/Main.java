package lesson2;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        connection();

//        findAllStudents();
//        findStudentsByAge(27, 31);

/*        System.out.println(getUsernameByLoginAndPassword("martin", "2233"));
        System.out.println(getUsernameByLoginAndPassword("martin", "1111"));
        System.out.println(getUsernameByLoginAndPassword("gena", "2222"));
        System.out.println(getUsernameByLoginAndPassword("timofei", "1q2w3e"));*/

//        updateUsernameByLogin("batman", "I am Batman!");

//        saveStudent(new StudentDTO("Андрей", 18));

        deleteUsersLikeLogin("user");

//        createUsers();
        createUsersPrepareStatement();

        disconnect();
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/db/mainDB.db");

        stmt = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }



    //execute
    //executeQuery - SELECT
    //executeUpdate - UPDATE, DELETE, INSERT

    private static void findAllStudents() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * from students");
        Map<Long, StudentDTO> students = new HashMap<>();

        while (rs.next()) {
            students.put(rs.getLong("id"), new StudentDTO(rs.getString("name"), rs.getInt("age")));
        }

        students.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
    private static void findStudentsByAge(int minAge, int maxAge) throws SQLException {
        ResultSet rs = stmt.executeQuery(String.format("SELECT * from students WHERE age BETWEEN '%s' AND '%s'", minAge,
                maxAge));
        Map<Long, StudentDTO> students = new HashMap<>();

        while (rs.next()) {
            students.put(rs.getLong("id"), new StudentDTO(rs.getString("name"), rs.getInt("age")));
        }

        students.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static String getUsernameByLoginAndPassword(String login, String password) throws SQLException {
        ResultSet rs = stmt.executeQuery(String.format("SELECT * from auth WHERE login = '%s'", login));

        if (rs.isClosed()) {
            return null;
        }

        String usernameDB = rs.getString("username");
        String passwordDB = rs.getString("password");


        return ((passwordDB != null) && (passwordDB.equals(password))) ? usernameDB : null;

    }
    private static void updateUsernameByLogin(String login, String newUsername) throws SQLException {
        stmt.executeUpdate(String.format("UPDATE auth SET username = '%s' WHERE login = '%s'", newUsername, login));
    }

    private static void saveStudent(StudentDTO studentDTO) throws SQLException {
        stmt.executeUpdate(String.format("INSERT INTO students (name, age) VALUES ('%s', '%s')", studentDTO.getName()
                , studentDTO.getAge()));
    }


    private static void createUsers() throws SQLException {
        long startTime = System.currentTimeMillis();

        connection.setAutoCommit(false);
        for (int i = 0; i < 3000; i++) {
            stmt.addBatch(String.format("INSERT INTO auth (login, password, username) VALUES ('user%s', '%s', " +
                            "'username%s')",
                    i, i*i*i, i ));
        }
        stmt.executeBatch();
        connection.setAutoCommit(true);

        System.out.println(System.currentTimeMillis() - startTime);
    }

    private static void createUsersPrepareStatement() throws SQLException {
        long startTime = System.currentTimeMillis();

        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO auth (login, password, username) VALUES (?, ?, ?)");

        connection.setAutoCommit(false);
        for (int i = 0; i < 3000; i++) {
            pstmt.setString(1, "user" + i);
            pstmt.setString(2, String.valueOf(i * i * i));
            pstmt.setString(3, "username" + i);

            pstmt.addBatch();
        }
        pstmt.executeBatch();
        connection.setAutoCommit(true);

        System.out.println(System.currentTimeMillis() - startTime);
    }


    private static void deleteUsersLikeLogin(String loginParts) throws SQLException {
        stmt.executeUpdate("DELETE FROM auth WHERE login LIKE '" + loginParts + "%'");
    }



}
