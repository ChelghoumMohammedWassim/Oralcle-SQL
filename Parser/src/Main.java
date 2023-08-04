import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "admin";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            System.out.println("All CLIENT:");

            String sqlQuery = "SELECT c.ID, c.NAME, a.STREET, a.ZIP_CODE, p.NUM\n" +
                    "FROM CLIENT c\n" +
                    "JOIN ADRESSE a ON c.ID = a.CLIENT_ID\n" +
                    "JOIN PHONE p ON c.ID = p.CLIENT_ID";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String street = resultSet.getString("STREET");
                String zipCode = resultSet.getString("ZIP_CODE");
                String num = resultSet.getString("NUM");

                System.out.println("ID: " + id+" Name: " + name+" Street: " + street+" ZIP Code: " + zipCode+" Number: " + num);

            }
            System.out.println("\n###########################################\n");

            System.out.println("All delivery:");

            sqlQuery = "SELECT c.NAME,o.ORDER_DATE, o.ADRESSE\n" +
                    "FROM ORDERS o\n" +
                    "JOIN CLIENT c ON o.client_id= c.id";

            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String ORDER_DATE = resultSet.getString("ORDER_DATE");
                String ADRESSE = resultSet.getString("ADRESSE");

                System.out.println(" Name: " + name+" Street: " + ORDER_DATE+" ZIP Code: " + ADRESSE);

            }

            System.out.println("\n###########################################\n");

            System.out.println("average_price:");

            sqlQuery = "SELECT AVG(PRICE) AS average_price\n" +
                    "FROM ARTICLE";

            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Float avg = resultSet.getFloat("average_price");

                System.out.println("AVG: " + avg);

            }
            

        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load Oracle JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}
