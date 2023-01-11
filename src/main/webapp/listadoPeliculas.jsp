<!DOCTYPE html>
<%@page import="ar.com.codoacodo.domain.Producto"%>
<%@page import="java.util.List"%>
<html lang="es">
<head>
	<jsp:include page="styles.jsp"/>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<div class="container d-flex justify-content-center">
		<div class="row w-100">
			<div class="d-flex justify-content-between align-items-end">
				<h1 class="mt-4" style="font-weight:600;">Pel&iacute;culas</h1>
				<a class="btn btn-add mb-3"
					role="button"
					href="<%=request.getContextPath()%>/nuevaPelicula.jsp">
					<i class="fas fa-plus"></i>
				</a>
			</div>
			<div class="col-12">
				<jsp:include page="mensajeria.jsp" />
			</div>
			<table class="table table-hover mt-3">
				<thead>
					<tr>
						<th scope="col">Tipo</th>
						<th scope="col">T&iacute;tulo</th>
						<th scope="col" style="width:120px">Fecha Alta</th>
						<th scope="col" style="width:130px">Puntuaci&oacute;n</th>
						<th scope="col">Comentario</th>
						<th scope="col">&nbsp;</th>
						<th scope="col">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<%
					//scriplet para escribir codigo java
					List<Producto> listado = (List<Producto>) request.getAttribute("peliculas");
					for (Producto p : listado) {
					%>
					<tr>
						<td><%=p.getTipo()%></td>
						<td><%=p.getTitulo()%></td>
						<td><%=p.getFechaAlta()%></td>
						<td>
							<%
								int i;
								for(i=0; i < p.getPuntuacion(); i++) {
									%>
										<i class="fas fa-star"></i>
									<%
								}
							%>
						</td>
						<td><%=p.getComentario()%></td>
						<td>
							<a class="btn btn-edit"
								role="button"
								href="<%=request.getContextPath()%>/EditarProductoController?id=<%=p.getId()%>">
								<i class="fas fa-edit"></i>
							</a>
						</td>
						<td>
							<button type="button" class="btn btn-delete" data-bs-toggle="modal"
								data-bs-target="#exampleModal"
								onclick="setProductoId(<%=p.getId()%>)">
								<i class="fas fa-trash"></i>
							</button>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="script.jsp"/>
	<jsp:include page="modalDelete.jsp"/>
	<script>
		function setProductoId(id) {
			document.getElementById('idProducto').value=id;
		}
	</script>
</body>
</html>