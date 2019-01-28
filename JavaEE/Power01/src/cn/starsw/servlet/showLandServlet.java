package cn.starsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.starsw.service.AirportService;

public class showLandServlet extends HttpServlet {
 private AirportService airservice = new AirportService();
        @Override
        	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        		req.setAttribute("lake", airservice.showLandPort());
        		req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
}
