<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	    <div class="modal-content">
	    	<form action="<%=request.getContextPath()%>/DeleteProductoController">
	    		<input type="hidden" name="idProducto" id="idProducto">
	      		<div class="modal-header" style="border:0">
	        		<h5 class="modal-title" id="exampleModalLabel" style="font-weight:600">Eliminar</h5>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body" style="border:0">
	        		¿Confirma que desea eliminar?
	      		</div>
	      		<div class="modal-footer" style="border:0">
	        		<button type="button" class="btn btn-edit" data-bs-dismiss="modal">Cancelar</button>
	        		<button type="submit" class="btn btn-delete">Eliminar</button>
	      		</div>
	     	</form>
	    </div>
	  </div>
</div>