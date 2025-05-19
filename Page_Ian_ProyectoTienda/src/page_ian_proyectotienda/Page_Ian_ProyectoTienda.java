/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package page_ian_proyectotienda;


import java.util.Scanner;
public class Page_Ian_ProyectoTienda {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       //Definir variables de producto:
       
       int Azucar = 1;
       int Avena = 2;
       int Trigo = 3;
       int Maiz = 4;
       
       String productoAzucar = ("Azucar");
       String productoAvena = ("Avena");
       String productoTrigo = ("Trigo");
       String productoMaiz = ("Maiz");
       
       int inventarioAzucar = 100;  
       int inventarioAvena = 100;
       int inventarioTrigo = 100;
       int inventarioMaiz = 100;
       
       double precioAzucar = 30;
       double precioAvena = 25;
       double precioTrigo = 32;
       double precioMaiz = 20;
       
       double precioCompraAzucar = 25;
       double precioCopraAvena = 20;
       double precioCompraTrigo = 30;
       double precioCompraMaiz = 18;
       
       //Definir variables de caja y estadisticas de costos:
       
       double caja = 0.00;
       boolean cajaAbierta = false; //Determinar el estado de la caja 
       boolean diaActivo = true;
       int numeroVentas = 0;
       int numeroCompras = 0;
       int totalVentas = 0;
       int totalCompras = 0;
       double ventaMayorGanancia = 0;
       double compraMayorCosto = 0;
       int ventasAzucar = 0;
       int ventasAvena = 0;
       int ventasTrigo = 0;
       int ventasMaiz = 0;
       
       //Menu principal
       
       while (true){
           System.out.println("\n*** Menu Principal ***");
           System.out.println("1. Abrir caja");
           System.out.println("2. Ventas");
           System.out.println("3. Compras");
           System.out.println("4. Reportes");
           System.out.println("5. Cierre de Caja");
           System.out.println("6. Salir del Sistema");
           System.out.println("Seleccione una opcion: ");
           int opcion = scanner.nextInt();
           
            // Funcion de el menu principal
       
           if (opcion == 1){
               if (!cajaAbierta) {            //Abrir la caja 
                   cajaAbierta = true; 
                   diaActivo = true;
                                        //Establecer los datos en 0 a inicio de ventas
                   numeroVentas = 0;
                   numeroVentas = 0;
                   numeroCompras = 0;
                   totalVentas = 0;
                   totalCompras = 0;
                   ventaMayorGanancia = 0;
                   compraMayorCosto = 0;
                   ventasAzucar = 0;
                   ventasAvena = 0;
                   ventasTrigo = 0;
                   ventasMaiz = 0;
                   
                   // parte visual para el usuario
                   
                   System.out.println("Caja abierta para uso");
                   System.out.println("Ingrese cantidad que desea aÃ±adir a la caja");
                   double cantidad = scanner.nextDouble();
                   if (cantidad > 0){
                       caja += cantidad;
                       System.out.println("Se aÃ±adieron "+ caja + "Lps a la caja");
                   } else {
                       System.out.println("Cantidad Invalida. No se agregaron los fondos.");
                   }
               } else { // AÃ±adir dinero extra durante el dÃ­a
                       
                    System.out.print("Ingrese cantidad adicional para la caja: ");
                    double cantidad = scanner.nextDouble();
                    if (cantidad > 0) {
                        caja += cantidad;
                        System.out.println("Se aÃ±adieron " + cantidad + " Lps. Nuevo saldo: " + caja + " Lps");
                    } else {
                        System.out.println("Cantidad invÃ¡lida. No se agregaron fondos.");
                
                   
               }
               }
           
           //Ventas
           } else if (opcion == 2){ 
               if (!cajaAbierta){
                   System.out.println("La caja esta cerada o el dia esta cerrado. Seleccione Abrir caja para iniciar");
               } else {
                   
                    // Variables para le siguiente venta

                double subtotalVenta = 0;
                boolean continuarVenta = true;

                while (continuarVenta){
                    System.out.println("Ingrese tipo de cliente (A,B,C): ");
                    String tipoCliente = scanner.next().toUpperCase(); //por si el usuario escribe en minuscula

                    if (!tipoCliente.equals("A") && !tipoCliente.equals("B") && !tipoCliente.equals("C")){
                        System.out.println("Tipo de cliente invalido.");
                    } else {



                     //Los Productos disponibles

                     System.out.println("\nProductos disponibles:");
                     System.out.println("1. "+ productoAzucar + "   " +precioAzucar + "Lps/kg");
                     System.out.println("2. "+ productoAvena + "   " + precioAvena + "Lps/kg");
                     System.out.println("3. "+ productoTrigo + "   " + precioTrigo + "Lps/kg");
                     System.out.println("4. "+ productoMaiz + "   " + precioMaiz + "Lps/kg");

                        //Pedir el codigo del producto

                        System.out.println("Ingrese el codigo del producto a vender: ");
                        int codigoProducto = scanner.nextInt();

                        //verificar el producto y el tipo de cliente

                        boolean productoValido = false;
                        String nombreProducto = "";
                        double precioProducto = 0;

                       if (codigoProducto == 1){     //Azucar
                           if(tipoCliente.equals("A") || tipoCliente.equals("B")){
                               productoValido = true;
                               nombreProducto = productoAzucar;
                               precioProducto = precioAzucar;
                           }
                       } else if (codigoProducto == 2){
                           if(tipoCliente.equals("A") || tipoCliente.equals("B")){
                               productoValido = true;
                               nombreProducto = productoAvena;
                               precioProducto = precioAvena;
                            }  
                       } else if (codigoProducto == 3){
                           if(tipoCliente.equals("A") || tipoCliente.equals("B")){
                               productoValido = true;
                               nombreProducto = productoTrigo;
                               precioProducto = precioTrigo;
                            }
                       } else if (codigoProducto == 4){
                           if(tipoCliente.equals("A") || tipoCliente.equals("C")){
                               productoValido = true;
                               nombreProducto = productoMaiz;
                               precioProducto = precioMaiz;
                           }
                       } else {
                           System.out.println("Codigo de producto no valido.");
                       }
                       if (!productoValido){
                           System.out.println("Este cliente No puede comprar dicho producto.");
                       } else {
                           //Cantidad de kg
                           System.out.println("Ingrese la cantidad de kilogramos a vender: ");
                           double kg = scanner.nextDouble();
                           
                           boolean inventarioSuficiente = false;
                            if (codigoProducto == 1 && kg <= inventarioAzucar) {
                             inventarioSuficiente = true;
                            } else if (codigoProducto == 2 && kg <= inventarioAvena) {
                             inventarioSuficiente = true;
                            } else if (codigoProducto == 3 && kg <= inventarioTrigo) {
                             inventarioSuficiente = true;
                            } else if (codigoProducto == 4 && kg <= inventarioMaiz) {
                             inventarioSuficiente = true;
                        }
    
                            if (kg > 0 && inventarioSuficiente) {
                                double monto = kg * precioProducto;
                                subtotalVenta += monto;
                                
                               //Actualizar productos vendidos
                               
                              if (codigoProducto == 1) {
                                ventasAzucar += kg;
                                inventarioAzucar -= kg;
                              } else if (codigoProducto == 2) {
                                ventasAvena += kg;
                                inventarioAvena -= kg;
                              } else if (codigoProducto == 3) {
                                ventasTrigo += kg;
                                inventarioTrigo -= kg;
                              } else if (codigoProducto == 4) {
                                ventasMaiz += kg;
                                inventarioMaiz -= kg;
                              }
                              System.out.println("Vendido: " + kg + "kg de" + nombreProducto + "-" + monto + "Lps");
                              
                           } else {
                                if (kg <= 0){
                                    System.out.println("Cantidad no valida.");
                                } else {
                                    System.out.println("No hay suficiente inventario para esta venta");
                                }
                               
                           }
                           
                       }
                       //Preguntar si desea comprar otro producto
                        System.out.println("Desea comprar otro producto? (S/N): ");
                        String respuesta = scanner.next().toUpperCase();
                        if (!respuesta.equals("S")){
                            continuarVenta = false; 
                        }
                    }
                    
                    //factura
                    
                    if (subtotalVenta > 0){   
                        System.out.println("\n=== FACTURA ===");
                        System.out.println("Subtotal: "+ subtotalVenta + "Lps");
                        
                        // Calculo de descuento
                        double descuento = 0;
                        if (subtotalVenta >= 5000){
                            descuento = subtotalVenta * 0.10;
                            System.out.println("Descuento (10%): "+ descuento + "Lps");
                        } else if (subtotalVenta >= 1000){
                            descuento = subtotalVenta * 0.05;
                            System.out.println("Descuento (5%): "+ descuento + "Lps");
                        }
                        
                        // Calcular Impuestos
                        double impuesto = (subtotalVenta - descuento) *0.07;
                        System.out.println("Impuesto (7%): " +impuesto+ "Lps");
                        
                        //Calcular el total
                        double total = subtotalVenta - descuento + impuesto;
                        System.out.println("Total a pagar: " +total+ "Lps");
                        
                        // Actializar contadores y la caja
                        
                        caja += total;
                        numeroVentas++;
                        totalVentas += total;
                        
                        // Calcular la ganancia de la venta
                        
                        double gananciaVenta = 0;
                        gananciaVenta = total * 0.2;
                        if (gananciaVenta > ventaMayorGanancia){
                            ventaMayorGanancia = gananciaVenta;
                        }
                    }
               }

                }   
                
            //compras
            } else if (opcion == 3){
               if (!cajaAbierta || !diaActivo){
                   System.out.println("La caja no esta abieta o el dia esta cerrado");
               } else {
                   
                   //tipo de proveedor
               System.out.println("Ingrese tipo de proveedor (A, B, C): ");
               String tipoProveedor = scanner.next().toUpperCase();
               
               // verificar proveedor
               
               if (!tipoProveedor.equals("A") && !tipoProveedor.equals("B") && !tipoProveedor.equals("C")){
                   System.out.println("Tipo de proveedor no valido");
               }
               
               // Tipo de productos disponibles dependiento del proveedor
               
               System.out.println("\nproductos disponibles para este proveedor:");
               if (tipoProveedor.equals("A")){
                   System.out.println("1. " + productoAzucar);
                   System.out.println("4. " + productoMaiz);
               } else if (tipoProveedor.equals("B")){
                   System.out.println("2. " + productoAvena);
                   System.out.println("3. " + productoTrigo);
               } else {
                   System.out.println("2. " + productoAvena);
               }
               
               //pedir el codigo del producto
               
               System.out.println("Ingrese el codigo del producto a comprar:");
               int codigoCompra = scanner.nextInt();
               
               //Validar producto segun tipo de proveedor
               
               boolean productoValidoCompra = false;
               String nombreProductoCompra = "";
               double precioProductoCompra = 0;
               
               if (codigoCompra == 1) {  // Azucar
                   if (tipoProveedor.equals("A")){
                       productoValidoCompra = true;
                       nombreProductoCompra = productoAzucar;
                       precioProductoCompra = precioCompraAzucar;
                   }
               } else if (codigoCompra == 2){
                   if (tipoProveedor.equals("B") || tipoProveedor.equals("C")){
                       productoValidoCompra = true;
                       nombreProductoCompra = productoAvena;
                       precioProductoCompra = precioCopraAvena;
                   }
               } else if (codigoCompra == 3){
                   if (tipoProveedor.equals("B")){
                       productoValidoCompra = true;
                       nombreProductoCompra = productoTrigo;
                       precioProductoCompra = precioCompraTrigo;
                   }
               } else if (codigoCompra == 4){
                   if (tipoProveedor.equals("A")){
                       productoValidoCompra = true;
                       nombreProductoCompra = productoMaiz;
                       precioProductoCompra = precioCompraMaiz;
                   }
               } else {
                   System.out.println("Codigo de producto no valido");
               }
               
               if (!productoValidoCompra){
                   System.out.println("Proveedor no vende el Producto");
               } else {  // pedir cantidad en kg
                   System.out.println("Ingrese la cantidad de kilogramos a comprar: ");
                   double kgCompra = scanner.nextDouble();
                   
                   if (kgCompra > 0) {
                       double totalCompra = kgCompra * precioProductoCompra;
                       
                      if (totalCompra > caja){
                          System.out.println("No se puede pagar la compra");
                      } else {  //realizar la compra
                          caja -= totalCompra;
                          numeroCompras++;
                          totalCompras += totalCompra;
                          
                          if (totalCompra > compraMayorCosto){
                              compraMayorCosto = totalCompra;
                          }
                          System.out.println("\n====< COMPRA REALIZADA >====");
                          System.out.println("\nProducto: " + nombreProductoCompra);
                          System.out.println("\nCantidad: " + kgCompra + "kg");
                          System.out.println("\nPrecio por kg: " + precioProductoCompra);
                          System.out.println("\nTOTAL COMPRA: " + totalCompra + "Lps");
                      }
                    } else {
                       System.out.println("Cantidad no valida.");
                   }
               }
            }
               
           // Reportes
           } else if (opcion == 4){
               if (!cajaAbierta){
                  System.out.println("La caja no esta abierta"); 
               } else {
                   System.out.println("\n====* REPORTES DEL DIA *====");
                   System.out.println("1. Cantidad actual en caja: " + caja + "Lps");
                   System.out.println("2. Numero de ventas: " + numeroVentas);
                   System.out.println("   Numero de compras: " + numeroCompras);
                   System.out.println("3. Volumen total de ventas: " + totalVentas + "Lps");
                   System.out.println("   Volumen total de compras: " + totalCompras + "Lps");
                   System.out.println("   Margen de ganancia: " +(totalVentas - totalCompras)+ "Lps");
                   System.out.println("4. Valor medio de venta: " + (numeroVentas > 0 ? totalVentas / numeroVentas : 0) + "LPS");
                   System.out.println("   Valor medio de compra: " + (numeroCompras > 0 ? totalCompras / numeroCompras : 0) + "LPS");
                   System.out.println("5. Venta con mayor ganancia: " + ventaMayorGanancia + "Lps");
                   System.out.println("   Compra con mas gasto: " + compraMayorCosto + "Lps");
                   
                   //Conseguir el producto estrella
                   String productoEstrella = "Ninguno";
                   double maxVentas = 0;
                   if (ventasAzucar > maxVentas){
                       maxVentas = ventasAzucar;
                       productoEstrella = productoAzucar;
                   }
                   if (ventasAvena > maxVentas) {
                       maxVentas = ventasAvena;
                       productoEstrella = productoAvena;
                   }
                   if (ventasTrigo > maxVentas){
                       maxVentas = ventasTrigo;
                       productoEstrella = productoTrigo;                    
                   }
                   if (ventasMaiz > maxVentas){
                       maxVentas = ventasMaiz;
                       productoEstrella = productoMaiz;
                   }
                   System.out.println("6. Producto estrella: " + productoEstrella + " (" + maxVentas + "kg vendidos)");
               }
               
           //Cierre de caja
           } else if (opcion == 5){
                if (!cajaAbierta){
                    System.out.println("La caja ya esta cerrada.");
                } else {
                    
                    System.out.println("\n====< CIERRE DE CAJA >====");
                System.out.println("Total en caja: " + caja + "Lps");
                
                //Calculo de ganancia
                double ganancia = totalVentas - totalCompras;
                System.out.println("Ganancia del dia: " + ganancia + "Lps");
                
                //deposito en el banco
                System.out.println("Cuanto desea depositar en el banco? (Maximo 60%): ");
                double deposito = scanner.nextDouble();
                double maxDeposito = caja * 0.6;
                
                if (deposito > maxDeposito){
                    System.out.println("No puede depositar mas del 60% (" + maxDeposito + ")");
                    deposito = maxDeposito;
                }
                
                if (deposito > 0) {
                    caja -= deposito;
                    System.out.println("Se depositaron " + deposito + " Lps. en el banco");
                    System.out.println(" Efectivo restante en caja: " + caja + "Lps");
                }
                
                //cabiar estados
                cajaAbierta = false;
                diaActivo = false;
                System.out.println("Caja cerrada. Para operar nuevamente debe avrir la caja");
            }
                
            //Salir del sistemma
            } else if (opcion == 6){
                System.out.println("Saliendo del sistema...");
                scanner.close();
                return;
            } else {
                System.out.println("opcion no valida. Intente nuevamente.");
            }
          }
       }
}
