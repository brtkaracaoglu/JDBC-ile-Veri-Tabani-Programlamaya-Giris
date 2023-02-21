import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement
                    ("insert into city (Name,CountryCode,District,Population) values('Düzce','TUR','Düzce','45000')");
            statement.executeUpdate();
            System.out.println("Kayıt Eklendi.");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }
}