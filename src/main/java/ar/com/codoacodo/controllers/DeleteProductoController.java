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

@WebServlet("/DeleteProductoController")
public class DeleteProductoController extends BaseController{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("idProducto"));
		
		Producto pDb = null;
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		try {
			pDb = dao.getById(id);
			dao.delete(id);
			req.setAttribute("success", List.of("Se ha eliminado el producto con id " + id + "."));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("No se ha eliminado el producto: " + e.getMessage()));
		}
		
		if(pDb.getTipo().equals("PELICULA")) {
			super.irA("/FindAllPeliculaController", req, resp);
		}
		
		if(pDb.getTipo().equals("SERIE")) {
			super.irA("/FindAllSerieController", req, resp);
		}
		
		if(pDb.getTipo().equals("LIBRO")) {
			super.irA("/FindAllLibroController", req, resp);
		}
		
	}

}
