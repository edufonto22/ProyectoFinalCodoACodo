<%@page import="ar.com.codoacodo.domain.Producto"%>
<%
	Producto p = (Producto) request.getAttribute("producto");
%>

<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="styles.jsp" />
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		<div class="container">
			<h1 class="mt-5" style="font-weight:600;">Editar Producto</h1>
			<div class="row mt-3">
				<div class="col-12">
					<form class="row g-3 needs-validation" novalidate
						action="<%=request.getContextPath()%>/EditarProductoController"
						method="POST">
						<div class="col-md-4">
							<input type="hidden"
								name="id"
								value="<%=p.getId()%>">
							<label for="validationCustom01" class="form-label">
								Tipo
							</label>
							<input type="text"
								readonly="readonly"
								name="tipo"
								class="form-control"
								id="validationCustom01"
								value="<%=p.getTipo()%>" required>
							<div class="valid-feedback">
							Looks good!
							</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom01" class="form-label">
								T&iacute;tulo
							</label>
							<input type="text"
								name="titulo"
								class="form-control"
								id="validationCustom01"
								value="<%=p.getTitulo()%>" required>
							<div class="valid-feedback">
							Looks good!
							</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom03" class="form-label">
								Fecha Alta
							</label>
							<input type="date"
								readonly="readonly"
								name="fechaAlta"
								class="form-control"
								id="validationCustom03" 
								value="<%=p.getFechaAlta()%>" required>
							<div class="invalid-feedback">
							Please provide a valid date.
							</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom01" class="form-label">
							Puntuaci&oacute;n
							</label>
							<div class="rating d-flex flex-row-reverse justify-content-evenly">
								<input type="radio" name="puntuacion" value="5" id="5"><label for="5">&#9734;</label>
								<input type="radio" name="puntuacion" value="4" id="4"><label for="4">&#9734;</label>
								<input type="radio" name="puntuacion" value="3" id="3"><label for="3">&#9734;</label>
								<input type="radio" name="puntuacion" value="2" id="2"><label for="2">&#9734;</label>
								<input type="radio" name="puntuacion" value="1" id="1"><label for="1">&#9734;</label>
							</div>
						</div>
						<div class="col-md-8">
							<label for="validationCustom01" class="form-label">
								Comentario
							</label>
							<input type="text"
								name="comentario"
								class="form-control"
								id="validationCustom01"
								value="<%=p.getComentario()%>" required>
							<div class="valid-feedback">
							Looks good!
							</div>
						</div>
						<div class="col-12 d-flex justify-content-end">
							<button class="btn btn-edit" type="submit">Editar</button>
						</div>
					</form>
				</div>
			</div>
			<jsp:include page="script.jsp" />
		</div>
	</body>
</html>