<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compra</title>
<link rel="stylesheet" type="text/css" href="resources/css/tablas.css" />

</head>
<body>
	<center>
		<form action="finalizar.html">
   		     <table border="1" class="pure-table pure-table-horizontal">
            <thead>
                 <tr>
                    <th>Id</th>
                    <th>Producto</th>
                    <th>Precio</th>
                   <th>Cantidad</th>
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
                		<td> ${articuloC.total}</td>    
                		
                	</tr>
                	</tbody>
                </c:forEach> 
                            
            </table>
            <table align="center" >
                <tr>
                    <td>Total: </td>
                    <td>${total}</td>
                </tr>
                <tr>
                    <td>Impuesto </td>
                    <td>${totalimpuesto}</td>
                </tr>
                <tr>
                    <td>Total: </td>
                    <td>${totaltodo}</td>
                </tr>
            </table>            
            
            <table border="1" class="pure-table pure-table-horizontal">
            <thead>
                 <tr>
                    <th>Id</th>
                    <th>Empresa</th>
                    <th>Importe</th>
                   <th>Elegir</th>
                   <th>Total</th>
                </tr>
               </thead>
                
                <c:forEach items="${empresaForm.empresas}" var="empresa" varStatus="status">
               <tbody>
                	<tr>                	
                		<td> ${empresa.id}</td>
                		<td> ${empresa.nombre}</td>	
                		<td> ${empresa.importe}</td>
                 		<td><input type="radio" name="radio${empresa.id}" value=""></td>                     		
                		<td> ${totaltodo+empresa.importe}</td>    
                		
                	</tr>
                </tbody>
                </c:forEach> 
                            
            </table>
            <br>
            <table>
            	<tr>
            		<td>
						Número de tarjeta de crédito: <input type="text" name="numerotarjeta" value="" size="20" />            		
            		</td>
            	</tr>
            	<tr>
            		<td>
            			NIP :<input type="password" name="nip" value="" size="20" />
            		</td>
            	</tr>
            	<tr>
            		<td>
            			Código de transacción   :<input type="text" name="codigo" value="" size="20" />		
            		</td>
            	</tr>
            </table>            
              <br/>
              <center>
                 <input type="submit" value="Realizar compra" name="realizar" class="styled-button-6"/>
              </center>
            </form>
        </center>
</body>
</html>