package servlet.car;

import beans.Car;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.CarService;


public class PutCarServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType( "text/html" );
        PrintWriter writer = response.getWriter();

        String brand = req.getParameter( "brand" );
        String type = req.getParameter( "type" );
        Integer year = Integer.parseInt( req.getParameter( "year" ) );
        Double kilometers = Double.parseDouble( req.getParameter( "kilometers" ) );

        Car car = new Car( brand, type, year, kilometers );

        System.out.println( car.toString() );

        //carSave
        try {
            CarService.saveCar( car );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //confirmation of DB adition of car
        response.setContentType( "text/html" );

        writer.append( "The car " + car.getBrand() + " " + car.getType() + " produced in " + year
                + " with " + kilometers + " km was added to DB named cars" );
    }
}
