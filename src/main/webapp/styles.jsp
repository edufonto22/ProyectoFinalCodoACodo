<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<link
	rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	crossorigin="anonymous">
	
<link rel="preconnect"
	href="https://fonts.googleapis.com">

<link rel="preconnect"
	href="https://fonts.gstatic.com"
	crossorigin>
	
<link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap"
	rel="stylesheet">
	
<link rel="preconnect"
	href="https://fonts.googleapis.com">

<link rel="preconnect"
	href="https://fonts.gstatic.com"
	crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap"
	rel="stylesheet">
	
<style>
	*{
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}

	body{
		background-color: #fab243;
		font-family: poppins;
	}
	
	.offcanvas{
		background-color: #2b5166;
		color: white;
	}
	
	.card{
		border: 2px solid black;
		background-color: transparent;
		font-size: 100px;
		color:#2b5166;
		-webkit-text-stroke: 1px black;
		display: flex;
		justify-content: center;
		align-items: center;
		text-align: center;
	}
	
	.btn{
		border: 2px solid black;
		background-color: transparent;
	}
	
	.card .btn{
		color:#2b5166;
	}
	
	.btn:hover{
		border: 2px solid black;
	}
	
	.form-control{
		border: 2px solid black;
		background-color: transparent;
	}
	
	.form-select{
		border: 2px solid black;
		background-color: #fab243;
	}
	
	.form-control:focus{
		border: 2px solid black;
		background-color: rgba(0,0,0,0.1);
	}
	
	.form-control:disabled{
		border: 2px solid black;
		background-color: #fab243;
	}
	
	.dropdown-menu{
		border: 2px solid white;
		background-color: transparent;
	}
	
	.dropdown-item{
		color: white;
	}
	
	.table {
		border: 2px solid black;
	}
	
	.btn-edit:hover{
		background-color:#2b5166;
		color:black;
	}
	
	.btn-delete:hover{
		background-color:#e02130;
		color:black;
	}
	
	.btn-add{
		background-color: black;
		color: black;
		-webkit-text-stroke: 0.5px #fab243;
	}
	
	.modal-content{
		border: 2px solid black;
		background-color: #fab243;
	}
	
	.rating {
    background-color: black;
    border: 10px;
    border-radius: 20px;
	}
	
	.rating>input {
	    display: none
	}
	
	.rating>label {
	    position: relative;
	    width: 1em;
	    font-size: 30px;
	    font-weight: 300;
	    color: #FFD600;
	    cursor: pointer
	}
	
	.rating>label::before {
	    content: "\2605";
	    position: absolute;
	    opacity: 0
	}
	
	.rating>label:hover:before,
	.rating>label:hover~label:before {
	    opacity: 1 !important
	}
	
	.rating>input:checked~label:before {
	    opacity: 1
	}
	
	.rating:hover>input:checked~label:before {
	    opacity: 0.4
	}
	
	.alert-success{
		border: 2px solid black;
		background-color: #429867;
		color: black;
	}
</style>

<!--
	morado: #482344
	azul: #2b5166
	verde: #429867
	amarillo: #fab243
	rojo: #e02130
-->