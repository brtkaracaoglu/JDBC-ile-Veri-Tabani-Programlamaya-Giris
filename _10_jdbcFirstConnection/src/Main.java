import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            System.out.println("Bağlantı oluştu..");
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }finally {
            connection.close();
        }

    }
}