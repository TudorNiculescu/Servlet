package servlet.car;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.CarService;

public class GETAllCarsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {


//
        //reading from DB the result set
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            CarService.fetchCarsFromDB();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        for (Car car : CarService.carList) {
//            writer.append(
//                    "The cars are: " + car.getBrand() + " " + car.getType() + " produced in " + car.getYear()
//                            + " with " + car.getKilometers() + " km was added to DB named cars" + "\r\n");
//        }
    }
}
