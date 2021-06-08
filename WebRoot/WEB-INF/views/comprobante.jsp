<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprobante</title>
<link rel="stylesheet" type="text/css" href="resources/css/tablas2.css" />

</head>
<body>
	<center>
		<form>
			 <table>
         	   <tr>
            		<td>
						Fecha: ${fecha}     		
            		</td>
            	</tr>
            	<tr>
            		<td>
						Hora: ${hora}            		
						
            		</td>
            	</tr>
            	<tr>
            		<td>
						Número de pedido: 9475            		
            		</td>
            	</tr>
            	<tr>
            		<td>
						Número de tarjeta de crédito: ${tarjeta}            		
            		</td>
            	</tr> 
            </table>
             <br/>
             <table>
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
            <br>
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
            <br>
            
            <table >
            	<thead>
                 <tr>
                   
                    <th>Empresa</th>
                    <th>Importe</th>                   
                   <th>Total</th>
                </tr>
                </thead>
                <tbody>
                	<tr>                	
                		
                		<td> ${empresa.nombre}</td>	
                		<td> ${empresa.importe}</td>                 		                     		
                		<td> ${totaltodo+empresa.importe}</td>    
                		
               		</tr>           
            	</tbody>     
            </table>
            <br><br>
            Puedes consultar en la siguiente página el estado de envío de compra!!!
            
            <br>
            <a href="url">http://mexpost.com</a>
            </form>
        </center>
</body>
</html>