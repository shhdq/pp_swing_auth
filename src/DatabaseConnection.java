import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/swing_auth";
        String user = "root";
        String password = "biskviits";

        Class.forName("com.mysql.cj.jdbc.Driver");


        return DriverManager.getConnection(url, user, password);

    }

}
