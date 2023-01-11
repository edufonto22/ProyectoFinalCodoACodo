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

@WebServlet("/FindAllProductoController")
public class FindAllProductoController extends BaseController{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		List<Producto> productos = new ArrayList<>();
		
		try {
			productos = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("productos", productos);
		
		//getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		
		super.irA("/listado.jsp", req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
