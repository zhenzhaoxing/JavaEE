package cn.starsw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.starsw.pojo.Airport;
import cn.starsw.service.AirportService;

public class AirServlet extends HttpServlet {
	private AirportService airservice = new AirportService();
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Airport> showTakePort = airservice.showTakePort();
	req.setAttribute("takeport", showTakePort);
	
	req.getRequestDispatcher("index.jsp").forward(req, resp);
}
}
