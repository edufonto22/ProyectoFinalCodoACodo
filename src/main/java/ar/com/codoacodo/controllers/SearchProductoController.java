package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/SearchProductoController")
public class SearchProductoController extends BaseController{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		String clave = req.getParameter("claveBusqueda");
		
		req.setAttribute("busqueda", clave);
		
		List<Producto> productos;
		
		try {
			productos = dao.search(clave);
		} catch (Exception e) {
			productos = List.of();
			e.printStackTrace();
		}
		
		req.setAttribute("productos", productos);
		
		//getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		super.irA("/listadoResultados.jsp", req, resp);
		
	}
	
}
