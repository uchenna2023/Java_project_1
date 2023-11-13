import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ProjectOne {
    private  int count;

    public int getCount() {
        return count;
    }

    public static void createTable(String url, String userName, String passWord){

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

    public int populateTable(String url, String userName, String passWord){

        try(Connection connection = DriverManager.getConnection(url, userName, passWord);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student(Name, Email, Age, Location, Designation) VALUES(?,?,?,?,?)");
            Scanner scanner = new Scanner(System.in)){

            int i = 0;
            while(i < 10){
                System.out.println("Please enter your name");
                String nameCol = scanner.nextLine();
                preparedStatement.setString(1,nameCol);
                System.out.println("Please enter your email");
                String email = scanner.nextLine();
                preparedStatement.setString(2,email);
                System.out.println("Please enter your Age");
                int age = scanner.nextInt();
                scanner.nextLine();
                preparedStatement.setInt(3,age);
                System.out.println("Please enter your Location");
                String userLoc = scanner.nextLine();
                preparedStatement.setString(4,userLoc);
                System.out.println("Please enter your Designation");
                String desg = scanner.nextLine();
                preparedStatement.setString(5,desg);
                preparedStatement.execute();
                i++;
                count++;

            }
            System.out.println("Row Count: "+ getCount());

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return count;
    }
}

class App{
    public static void main(String[] args) {
        ProjectOne projectOne = new ProjectOne();
        ProjectOne.createTable("jdbc:mysql://localhost:3306/project_one","root","1987uche...");
        projectOne.populateTable("jdbc:mysql://localhost:3306/project_one","root","1987uche...");

    }
}
