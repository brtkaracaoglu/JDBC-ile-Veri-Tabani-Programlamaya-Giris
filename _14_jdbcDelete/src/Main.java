import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement
                    ("delete from city where id = 4082");
            statement.executeUpdate();
            System.out.println("Kayıt Silindi.");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }
}