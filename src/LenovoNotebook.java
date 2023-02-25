import java.sql.*;

public class LenovoNotebook extends Lenovo{
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "12345";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    @Override
    public void characteristics() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from laptops order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Lenovo");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("rom") + " " +
                        result.getFloat("Display") + " " +
                        result.getString("color") + " " +
                        result.getInt("ram") + " " +
                        result.getString("os") + " " +
                        result.getString("Type of RAM") + " " +
                        result.getString("Chip") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
}
