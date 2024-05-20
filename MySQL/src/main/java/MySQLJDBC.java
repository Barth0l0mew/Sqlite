import java.sql.*;

public class MySQLJDBC {
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","")) {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            update();
            delete();
            readAll();
            //add();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void readAll() throws SQLException {
        //Список всех служащих
        ResultSet rs = statement.executeQuery("select * from student");
        while (rs.next())
            System.out.printf("name: %s%n", rs.getString("name"));

    }
    public static void add() throws SQLException {
        //Список всех служащих
        String sql = "INSERT INTO student(name) VALUES ('Zara')";
        statement.executeUpdate(sql);

    }
    public static void update() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        String sql = "UPDATE student SET surname='Ivanov', univ_id = 2 WHERE name='Zara'";
        statement.executeUpdate(sql);
    }
    public static void delete() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        String sql = "delete from student  WHERE name='Zara'";
        statement.executeUpdate(sql);
    }

}