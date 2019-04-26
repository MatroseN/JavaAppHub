package Database;

import java.sql.*;
public class DatabaseConnect {
    public DatabaseConnect(){
        try {
            connection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connection() throws SQLException, ClassNotFoundException {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_system?serverTimezone=CET", "root", "Schecterhellraisersolo6");
            statement = con.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getCon(){
        return con;
    }

    private Connection con;

    private Statement statement;

}
