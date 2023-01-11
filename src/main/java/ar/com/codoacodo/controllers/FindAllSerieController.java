package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/FindAllSerieController")
public class FindAllSerieController extends BaseController{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		List<Producto> productos = new ArrayList<>();
		
		try {
			productos = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Producto> series = new ArrayList<>();
		
		for(Producto p : productos) {
			if(p.getTipo().equals("SERIE")) {
				series.add(p);
			}
		}
		
		req.setAttribute("series", series);
		
		//getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		
		super.irA("/listadoSeries.jsp", req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
