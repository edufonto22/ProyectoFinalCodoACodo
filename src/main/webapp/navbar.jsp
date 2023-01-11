<div class="row d-flex justify-content-between w-100">
	<div class="col-4 mt-3 ms-3">
		<button class="btn btn-outline-dark"
			type="button"
			data-bs-toggle="offcanvas"
			data-bs-target="#offcanvasWithBothOptions"
			aria-controls="offcanvasWithBothOptions">
			<i class="fas fa-hamburger"></i>
		</button>

			<a class="btn btn-outline-black"
				role="button"
				href="<%=request.getContextPath()%>/index.jsp">
				<i class="fas fa-home"></i>
			</a>
		
		<div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
		  <div class="offcanvas-header">
		    <h5 class="offcanvas-title mt-3" id="offcanvasWithBothOptionsLabel" style="font-weight:800">STAR TRACKER</h5>
		    <button type="button" class="btn-close btn-close-white mt-3" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		  </div>
		  <div class="offcanvas-body">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>"><i class="fas fa-star me-3"></i>Home</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/FindAllPeliculaController"><i class="fas fa-star me-3"></i>Peliculas</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/FindAllSerieController"><i class="fas fa-star me-3"></i>Series</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/FindAllLibroController"><i class="fas fa-star me-3"></i>Libros</a></li>
				</ul>
		  </div>
		</div>
	</div>
	<div class="col-4 col-lg-3 mt-3 me-3">
		<form class="d-flex"
			action="<%=request.getContextPath()%>/SearchProductoController">
			<input class="form-control me-2"
				name="claveBusqueda"
				type="search"
				placeholder="Buscar"
				autocomplete="off"
				aria-label="Search" required>
			<button class="btn btn-outline-dark"
				type="submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</div>
</div>