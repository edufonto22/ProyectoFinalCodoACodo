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

@WebServlet("/EditarProductoController")
public class EditarProductoController extends BaseController{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		String titulo = req.getParameter("titulo");
		String puntuacion = req.getParameter("puntuacion");
		String comentario = req.getParameter("comentario");
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto pDb = null;
		
		try {
			pDb = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			req.setAttribute("errors", List.of("Error actualizando producto. " + e.getMessage()));
		}
		
		if(pDb == null) {
			super.irA("/FindAllProductoController", req, resp);
			return;
		}
		
		try {
			pDb.setTitulo(titulo);
			pDb.setPuntuacion(Integer.parseInt(puntuacion));
			pDb.setComentario(comentario);
			
			dao.update(pDb);
			req.setAttribute("success", List.of("Se ha actualizado el producto con id " + id + "."));
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Error actualizando producto. " + e.getMessage()));
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
		
		//super.irA("/FindAllProductoController", req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto p = null;
		
		try {
			p = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("producto", p);
		
		super.irA("/editar.jsp", req, resp);
		
	}

}
