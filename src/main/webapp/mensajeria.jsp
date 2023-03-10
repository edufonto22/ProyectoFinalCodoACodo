<%@page import="java.util.List"%>

<%if((request.getAttribute("success") != null) || (request.getAttribute("errors") != null) || (request.getAttribute("warnings") != null)) {%>
	<div class="row">
		<%if(request.getAttribute("success") != null) {%>
		<div class="col-12">
			<div class="alert alert-success" role="alert">
		  		<%
					List<String> success = (List<String>) request.getAttribute("success");
					for(String msj : success) {
						out.print(msj);
					}
				%>
			</div>
		</div>
		<% } %>
		
		<%if(request.getAttribute("errors") != null) {%>
		<div class="col-12">
			<div class="alert alert-danger" role="alert">
				<ul>
		  			<%
						List<String> errores = (List<String>) request.getAttribute("errors");
						for(String msj : errores) {
							out.print("<li>" + msj + "</li>");
						}
					%>
				</ul>
			</div>
		</div>
		<% } %>
		
		<%if(request.getAttribute("warnings") != null) {%>
		<div class="col-12">
			<div class="alert alert-warning" role="alert">
		  		A simple warning alert—check it out!
			</div>
		</div>
		<% } %>
	</div>
<% } %>