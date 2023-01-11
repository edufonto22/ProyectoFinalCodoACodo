package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/CreateProductoController")
public class CreateProductoController extends BaseController{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// capturo los parametros que vienen en el request enviado por el form:
		String tipo = req.getParameter("tipo"); //name del input
		String titulo = req.getParameter("titulo");
		String fechaAlta = req.getParameter("fechaAlta");
		String puntuacion = req.getParameter("puntuacion");
		String comentario = req.getParameter("comentario");
		
		List<String> errores = new ArrayList<>();
		
		if(tipo == null || "".equals(tipo)) {
			errores.add("Tipo vac&iacute;o");
		}
		
		if(titulo == null || "".equals(titulo)) {
			errores.add("T&iacute;tulo vac&iacute;o");
		}
		
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			super.irA("/nuevo.jsp", req, resp);
			return;
		}
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = new Date();;
		
		try {
			fecha = formato.parse(fechaAlta);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Producto newProducto = new Producto(tipo, titulo, fecha, Integer.parseInt(puntuacion), comentario);
		
		try {
			dao.create(newProducto);
			req.setAttribute("success", List.of("Producto agregado exitosamente."));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(newProducto.getTipo().equals("PELICULA")) {
			super.irA("/FindAllPeliculaController", req, resp);
		}
		
		if(newProducto.getTipo().equals("SERIE")) {
			super.irA("/FindAllSerieController", req, resp);
		}
		
		if(newProducto.getTipo().equals("LIBRO")) {
			super.irA("/FindAllLibroController", req, resp);
		}
		
		//getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
		
		
	}

}
