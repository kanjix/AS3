import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.*;
import java.util.Scanner;
import java.util.Stack;
public class AppleTablet extends Apple{
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "12345";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    @Override
    public void characteristics() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from tablets order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Apple");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("rom") + " " +
                        result.getFloat("display") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
}
