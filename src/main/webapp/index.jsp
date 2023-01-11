<!DOCTYPE html>
<html lang="es">
	<head>
		<jsp:include page="styles.jsp"/>
		<!--<script type="text/javascript">
			function verListado() {
				window.location = '<%=request.getContextPath()%>/FindAllProductoController';
			}
		</script>-->
		
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"/>
		<!--<button onclick="verListado()">
			Ver Listado de Productos
		</button>-->
		<jsp:include page="portada.jsp"/>
		<jsp:include page="cards.jsp"/>
		<jsp:include page="script.jsp"/>
		
	</body>
</html>