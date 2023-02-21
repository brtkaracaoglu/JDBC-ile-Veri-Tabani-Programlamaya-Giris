import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        insertData();
        selectDemo();
        deleteDemo();
        updateDemo();
    }

    public static void insertData() throws SQLException {
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

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country ");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }

    }

    public static void updateDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement
                    ("update city set population = 80000 where id = 4082");
            statement.executeUpdate();
            System.out.println("Kayıt Güncellendi.");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void deleteDemo() throws SQLException {
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