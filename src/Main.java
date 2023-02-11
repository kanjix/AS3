import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "12345";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    int a;

    public static void main(String[] args) throws Exception{
        boolean menu = true;
        Scanner sc = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        while(menu){
            System.out.println("Choose category: ");
            System.out.println("1. TV");
            System.out.println("2. Phone");
            System.out.println("3. Accessory");
            System.out.println("4. Tablet");
            System.out.println("5. Laptop");
            System.out.println("0. Exit");
            int num = sc.nextInt();
            if (num == 0){
                menu = false;
            }
            else if(num == 1){
                boolean TVMenu = true;
                while (TVMenu){
                    TVMenu = TVMenu();
                }
            }
            else if(num == 2) {
                boolean phMenu = true;
                while (phMenu){
                    phMenu = phonesMenu();
                }
            }
            else if(num == 3){
                boolean accessoryMenu = true;
                while (accessoryMenu){
                    accessoryMenu = accessoryChargerMenu();
                }
            }
            else if(num == 4){
                boolean tabMenu = true;
                while (tabMenu){
                    tabMenu = tabletElectronicMenu();
                }
            }
            else if(num == 5){
                boolean lapMenu = true;
                while (lapMenu){
                    lapMenu = laptopsMenu();
                }
            }
            else{
                System.out.println("Incorrect option!");
            }
        }

    }
    public static boolean TVMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Select brand: ");
        System.out.println("1. Samsung");
        System.out.println("2. Sony");
        System.out.println("3. LG");
        System.out.println("0. Exit");
        int num = sc.nextInt();
        if(num == 0){
            return false;
        }
        else if(num == 1){
            tvSamsungMenu();
        }
        else if(num == 2){
            tvSonyMenu();
        }
        else if(num == 3){
            tvLGMenu();
        }
        else{
            System.err.println("Incorrect option!");
        }
        return true;
    }
    public static void tvSamsungMenu() throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from tv_tv order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Samsung");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("resolution") + " " +
                        result.getString("type of display") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static void tvSonyMenu() throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from tv_tv order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Sony");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("resolution") + " " +
                        result.getString("type of display") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static void tvLGMenu() throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from tv_tv order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("LG");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("resolution") + " " +
                        result.getString("type of display") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static boolean phonesMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Select brand:");
        System.out.println("1. Samsung");
        System.out.println("2. Apple");
        System.out.println("3. Xiaomi");
        System.out.println("0. Exit");
        int num = sc.nextInt();
        if(num == 0){
            return false;
        }
        else if(num == 1){
            phoneSamsungMenu();
        }
        else if(num == 2){
            phoneAppleMenu();
        }
        else if(num == 3){
            phoneXiaomiMenu();
        }
        else{
            System.out.println("Incorrect option!");
        }
        return true;
    }
    public static boolean accessoryChargerMenu()throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Select type:");
        System.out.println("1. Type C");
        System.out.println("2. Lightning");
        System.out.println("3. Micro USB");
        System.out.println("0. Exit");
        int num = sc.nextInt();
        if(num == 0){
            return false;
        }
        else if(num == 1){
            TypeC();
        }
        else if(num == 2){
            lightning();
        }
        else if(num == 3){
            microUSB();
        }
        else{
            System.out.println("Incorrect option!");
        }
        return true;
    }
    public static void lightning() throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from accessories order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("type").compareTo("Lightning");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("name") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static void microUSB()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from accessories order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("type").compareTo("microUSB");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("name") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static void TypeC()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from accessories order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("type").compareTo("Adapter");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("name") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static boolean tabletElectronicMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Select brand:");
        System.out.println("1. Huawei");
        System.out.println("2. Apple");
        System.out.println("3. Xiaomi");
        System.out.println("0. Exit");
        int num = sc.nextInt();
        if(num == 0){
            return false;
        }
        else if(num == 1){
            tabletHuaweiMenu();
        }
        else if(num == 2){
            tabletAppleMenu();
        }
        else if(num == 3){
            tabletXiaomiMenu();
        }
        else{
            System.out.println("Incorrect option!");
        }
        return true;
    }
    public static void tabletHuaweiMenu() throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from tablets order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Huawei");
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
    public static void tabletAppleMenu()throws Exception{
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
    public static void tabletXiaomiMenu()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from tablets order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Xiaomi");
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
    public static void phoneSamsungMenu() throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from phones order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Samsung");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("rom") + " " +
                        result.getString("color") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static void phoneAppleMenu()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from phones order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("IPhone");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("rom") + " " +
                        result.getString("color") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static void phoneXiaomiMenu()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from phones order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("Xiaomi");
            if(num == 0){
                //System.out.println(result.getString("brand") + " " + result.getString("model") + " " + result.getInt("rom") + " " + result.getFloat("Display") + " " + result.getString("color") + " " + result.getInt("price") + " " + result.getInt("RAM"));
                System.out.println(result.getString("brand") + " " +
                        result.getString("model") + " " +
                        result.getInt("rom") + " " +
                        result.getString("color") + " " +
                        result.getInt("price") + " tenge");
            }
        }
    }
    public static boolean laptopsMenu()throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Select brand:");
        System.out.println("1. MacBook");
        System.out.println("2. ASUS");
        System.out.println("3. Lenovo");
        System.out.println("0. Exit");
        int num = sc.nextInt();
        if (num == 0){
            return false;
        }
        else if(num == 1){
            macbookMenu();
        }
        else if(num == 2){
            asusMenu();
        }
        else if(num == 3){
            lenovoMenu();
        }
        else{
            System.err.println("Incorrect option!");
        }
        return true;
    }
    public static void macbookMenu()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from laptops order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("MacBook");
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
    public static void asusMenu()throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASKS = "select * from laptops order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
        while(result.next()){
            int num = -1000;
            num = result.getString("brand").compareTo("ASUS");
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
    public static void lenovoMenu()throws Exception{
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