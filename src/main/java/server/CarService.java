package server;

import beans.Car;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CarService {

    private static String user = "root";
    private static String password = "mindgame";
    private static String url = "jdbc:mysql://localhost:3306/cars?useSSL=false";
    public static List<Car> carList = null;

    public static void saveCar(Car car) throws SQLException, IOException, ClassNotFoundException {

        //variables declaration:
        String brand = car.getBrand();
        String type = car.getType();
        int year = Integer.valueOf( car.getYear() );
        double kilometers = Double.valueOf( car.getKilometers() );

        //SQL command to be pushed to server
        String sqlString =
                "INSERT INTO cars(brand, type, year, kilometers) VALUES('" + brand + "', '" + type
                        + "', '" + year + "', '" + kilometers + "'" + ")";

        //to select the appropriate JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //establishing the connection
        try (Connection conn = DriverManager.getConnection( url, user, password );
                Statement statement = conn.createStatement()) {

            //setting the behaviour
            conn.setAutoCommit( false );

            //no of rows affected
            int res = statement.executeUpdate( sqlString );

            //commitment of transaction
            conn.commit();
        }
    }

    public static List<Car> fetchCarsFromDB() throws SQLException, ClassNotFoundException {
        String sqlString = "SELECT * FROM cars";

        //to select the appropriate JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection( url, user, password );
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery( sqlString );

            while (rs.next()) {
                Integer id = rs.getInt( "id" );
                String brand = rs.getString( "brand" );
                String type = rs.getString( "type" );
                Integer year = rs.getInt( "year" );
                Double kilometers = rs.getDouble( "kilometers" );
                System.out.println( "Car :: " + id + " / " + brand + " / " + type + " / " + year + " / " + kilometers);
                carList.add( new Car( brand, type, year, kilometers ) );
            }
        }
        return carList;
    }
}
