<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Seleccion</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resources/css/tablas.css" />

  </head>
  
  <body>
    


<center>   
         <h1><label>Carrito de compras</label></h1>
         <h2><label>Seleccione sus artículos</label></h2>
        
         <form  action="agregar.html" modelAttribute="articuloForm">
              
            <table class="table1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Imagen</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Cantidad</th>              
                </tr>
               </thead>
               
                <c:forEach items="${articuloForm.articulos}" var="articulo" varStatus="status">
                <tbody>
                	<tr>                	
                		<td> ${articulo.id}</td>
                		<td> <img src="resources/img/${articulo.nombre}.gif" ></td>	
                		<td> ${articulo.descripcion}</td>
                		<td> ${articulo.precio}</td>                		
                		<td><input type="textbox" name="Elemento${articulo.id}" value="0" size="5" /></td>
                	</tr>                	
                </tbody>
                </c:forEach>
            </table>
               <center>
               <input type="submit" value="Agregar" name="entrar" class="styled-button-6"/>
               </center>
        </form>
               <br/>
        <form action="limpiar.html">       
            <center>    
                   <input type="submit" value="Limpiar" name="limpiar" class="styled-button-6"/>
        	 </center>
        </form>
               
        <form action="comprar.html">       
            <center>
         	    <input type="submit" value="Comprar" name="comprar"  class="styled-button-6"/>
            </center>
        </form>
        
        <form action="actualizar.html">
            <center> 
            	 <input type="submit" value="Actualizar" name="actualizar" class="styled-button-6" />
             </center>
            <br>
            <table border="1" class="pure-table pure-table-horizontal">
            <thead>
                 <tr>
                    <th>Id</th>
                    <th>Producto</th>
                    <th>Precio</th>
                   <th>Cantidad</th>
                   <th>Eliminar</th>
                   <th>Total</th>
                </tr>
                </thead>
                <c:forEach items="${articuloCompra.articulos}" var="articuloC" varStatus="status">
                <tbody>	
                	<tr>                	
                		<td> ${articuloC.id}</td>
                		<td> ${articuloC.nombre}</td>	
                		<td> ${articuloC.precio}</td>
                		<td> ${articuloC.cantidad}</td> 
                		<td><input type="checkbox" name="chk${articuloC.id}" value="" size="5" /></td>                         		
                		<td> ${articuloC.total}</td>    
                		
                	</tr>
                	</tbody>
                </c:forEach> 
                            
            </table>
            <table>
                <tr>
                    <td>Total: </td>
                    <td>${total}</td>
                </tr>                
            </table>
            </form>
        </center>
</body>


	
    
  </body>
</html>
