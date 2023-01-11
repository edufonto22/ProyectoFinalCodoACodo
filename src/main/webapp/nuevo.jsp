<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="styles.jsp" />
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		<div class="container">
			<h1 class="mt-5" style="font-weight:600;">Nuevo Producto</h1>
			<jsp:include page="mensajeria.jsp" />
			<div class="row mt-3">
				<div class="col-12">
					<form class="row g-3 needs-validation" novalidate
						action="<%=request.getContextPath()%>/CreateProductoController"
						method="POST">
						<div class="col-md-4">
							<label for="validationCustom01" class="form-label">
								Tipo
							</label>
							<!--<input type="text"
								name="tipo"
								class="form-control"
								id="validationCustom01"
								value="" required>-->
							<select class="form-select"
								name="tipo"
								aria-label="Default example">
							  	<option value="PELICULA">PELICULA</option>
							  	<option value="SERIE">SERIE</option>
							  	<option value="LIBRO">LIBRO</option>
							</select>
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
								autocomplete="off"
								value="" required>
							<div class="valid-feedback">
							Looks good!
							</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom03" class="form-label">
								Fecha Alta
							</label>
							<input type="date"
								name="fechaAlta"
								class="form-control"
								id="validationCustom03" required>
							<div class="invalid-feedback">
							Please provide a valid date.
							</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom01" class="form-label">
							Puntuaci&oacute;n
							</label>
							<input type="number"
								name="puntuacion"
								class="form-control"
								id="validationCustom01"
								autocomplete="off"
								value="" required>
							<div class="valid-feedback">
							Looks good!
							</div>
						</div>
						<div class="col-md-4">
							<label for="validationCustom01" class="form-label">
								Comentario
							</label>
							<input type="text"
								name="comentario"
								class="form-control"
								id="validationCustom01"
								autocomplete="off"
								value="" required>
							<div class="valid-feedback">
							Looks good!
							</div>
						</div>
						<div class="col-12">
							<button class="btn btn-outline-dark" type="submit">Nuevo</button>
						</div>
					</form>
				</div>
			</div>
			<jsp:include page="script.jsp" />
		</div>
	</body>
</html>