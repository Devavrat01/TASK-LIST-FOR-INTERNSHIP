import java.sql.*;

public class DBConnection {
    static Connection con;

    public static Connection CreateDBConnection() throws ClassNotFoundException, SQLException {
        // Load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Get Connection
        String url = "jdbc:mysql://localhost:3306/Employee_Management?useSSL=false";
        String user = "root";
        String password = "8112671726";
        con = DriverManager.getConnection(url, user, password);

        return con;
    }
}
