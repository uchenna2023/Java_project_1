import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProjectOne {


    public  static void createTable(String url, String userName, String passWord){

        try(Connection connection = DriverManager.getConnection(url, userName, passWord);
            Statement statement = connection.createStatement();)
        {
            String create = "CREATE TABLE IF NOT EXISTS student(Name Text, Email Text, Age int, Location Text, Designation Text)";
            statement.execute(create);

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public static int populateTable(){

    }

}

class App{
    public static void main(String[] args) {
        ProjectOne.createTable("jdbc:mysql://localhost:3306/october_cohort","root","1987uche...");
    }
}
