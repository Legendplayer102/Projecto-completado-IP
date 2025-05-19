/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

public class Page_Ian_ProyectoTienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Definir variables de producto
        int Azucar = 1;
        int Avena = 2;
        int Trigo = 3;
        int Maiz = 4;
       
        String productoAzucar = "Azúcar";
        String productoAvena = "Avena";
        String productoTrigo = "Trigo";
        String productoMaiz = "Maíz";
       
        int inventarioAzucar = 100;  
        int inventarioAvena = 100;
        int inventarioTrigo = 100;
        int inventarioMaiz = 100;
       
        double precioAzucar = 30;
        double precioAvena = 25;
        double precioTrigo = 32;
        double precioMaiz = 20;
       
        double precioCompraAzucar = 25;
        double precioCompraAvena = 20;
        double precioCompraTrigo = 30;
        double precioCompraMaiz = 18;
       
        // Variables de estado
        double caja = 0.00;
        boolean cajaAbierta = false;
        int numeroVentas = 0;
        int numeroCompras = 0;
        double totalVentas = 0;
        double totalCompras = 0;
        double ventaMayorGanancia = 0;
        double compraMayorCosto = 0;
        int ventasAzucar = 0;
        int ventasAvena = 0;
        int ventasTrigo = 0;
        int ventasMaiz = 0;
       
        // Menú principal
        while (true) {
            System.out.println("\n*** Menú Principal ***");
            System.out.println("1. Abrir caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
           
            // Opción 1: Abrir caja
            if (opcion == 1) {
                if (!cajaAbierta) {
                    System.out.print("Ingrese cantidad inicial para la caja: ");
                    double cantidad = scanner.nextDouble();
                    if (cantidad >= 0) {
                        caja = cantidad;
                        cajaAbierta = true;
                        // Reiniciar contadores
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
                        System.out.println("Caja abierta con éxito. Saldo inicial: " + caja + " Lps");
                    } else {
                        System.out.println("Cantidad inválida. Debe ser un valor positivo.");
                    }
                } else {
                    System.out.print("Ingrese cantidad adicional para la caja: ");
                    double cantidad = scanner.nextDouble();
                    if (cantidad > 0) {
                        caja += cantidad;
                        System.out.println("Se añadieron " + cantidad + " Lps. Nuevo saldo: " + caja + " Lps");
                    } else {
                        System.out.println("Cantidad inválida. No se agregaron fondos.");
                    }
                }
            }
            // Opción 2: Ventas
            else if (opcion == 2) { 
                if (!cajaAbierta) {
                    System.out.println("La caja está cerrada. Primero ábrala con la opción 1.");
                } else if (inventarioAzucar <= 0 && inventarioAvena <= 0 && inventarioTrigo <= 0 && inventarioMaiz <= 0) {
                    System.out.println("No hay stock disponible de ningún producto. Realice compras primero.");
                } else {
                    // Variables para la venta
                    double subtotalVenta = 0;
                    boolean continuarVenta = true;
                    
                    // Pedir tipo de cliente solo una vez
                    System.out.print("Ingrese tipo de cliente (A,B,C): ");
                    String tipoCliente = scanner.next().toUpperCase();
                    
                    // Validar tipo de cliente
                    while (!tipoCliente.equals("A") && !tipoCliente.equals("B") && !tipoCliente.equals("C")) {
                        System.out.println("Tipo de cliente inválido.");
                        System.out.print("Ingrese tipo de cliente (A,B,C): ");
                        tipoCliente = scanner.next().toUpperCase();
                    }

                    while (continuarVenta) {
                        // Mostrar productos disponibles
                        System.out.println("\nProductos disponibles:");
                        System.out.println("1. "+ productoAzucar + "   " + precioAzucar + " Lps/kg");
                        System.out.println("2. "+ productoAvena + "   " + precioAvena + " Lps/kg");
                        System.out.println("3. "+ productoTrigo + "   " + precioTrigo + " Lps/kg");
                        System.out.println("4. "+ productoMaiz + "   " + precioMaiz + " Lps/kg");

                        // Pedir código de producto
                        System.out.print("Ingrese el código del producto a vender: ");
                        int codigoProducto = scanner.nextInt();

                        // Validar producto
                        boolean productoValido = false;
                        String nombreProducto = "";
                        double precioProducto = 0;

                        if (codigoProducto == 1) { // Azúcar
                            if(tipoCliente.equals("A") || tipoCliente.equals("B")) {
                                productoValido = true;
                                nombreProducto = productoAzucar;
                                precioProducto = precioAzucar;
                            }
                        } else if (codigoProducto == 2) { // Avena
                            if(tipoCliente.equals("A") || tipoCliente.equals("B")) {
                                productoValido = true;
                                nombreProducto = productoAvena;
                                precioProducto = precioAvena;
                            }  
                        } else if (codigoProducto == 3) { // Trigo
                            if(tipoCliente.equals("A") || tipoCliente.equals("B")) {
                                productoValido = true;
                                nombreProducto = productoTrigo;
                                precioProducto = precioTrigo;
                            }
                        } else if (codigoProducto == 4) { // Maíz
                            if(tipoCliente.equals("A") || tipoCliente.equals("C")) {
                                productoValido = true;
                                nombreProducto = productoMaiz;
                                precioProducto = precioMaiz;
                            }
                        } else {
                            System.out.println("Código de producto no válido.");
                        }

                        if (!productoValido) {
                            System.out.println("Este cliente no puede comprar dicho producto.");
                        } else {
                            // Pedir cantidad
                            System.out.print("Ingrese la cantidad de kilogramos a vender: ");
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
                               
                                // Actualizar inventario y contadores
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
                                System.out.println("Vendido: " + kg + " kg de " + nombreProducto + " - " + monto + " Lps");
                            } else {
                                if (kg <= 0) {
                                    System.out.println("Cantidad no válida.");
                                } else {
                                    System.out.println("No hay suficiente inventario para esta venta.");
                                }
                            }
                        }
                        
                        // Preguntar si desea otro producto (no otro cliente)
                        System.out.print("¿Desea vender otro producto? (S/N): ");
                        String respuesta = scanner.next().toUpperCase();
                        if (!respuesta.equals("S")) {
                            continuarVenta = false;
                        }
                    }
                    
                    // Facturación solo si hubo ventas
                    if (subtotalVenta > 0) {
                        System.out.println("\n=== FACTURA ===");
                        System.out.println("Subtotal: "+ subtotalVenta + " Lps");
                        
                        // Calcular descuento
                        double descuento = 0;
                        if (subtotalVenta >= 5000) {
                            descuento = subtotalVenta * 0.10;
                            System.out.println("Descuento (10%): "+ descuento + " Lps");
                        } else if (subtotalVenta >= 1000) {
                            descuento = subtotalVenta * 0.05;
                            System.out.println("Descuento (5%): "+ descuento + " Lps");
                        }
                        
                        // Calcular impuesto
                        double impuesto = (subtotalVenta - descuento) * 0.07;
                        System.out.println("Impuesto (7%): " + impuesto + " Lps");
                        
                        // Calcular total
                        double total = subtotalVenta - descuento + impuesto;
                        System.out.println("Total a pagar: " + total + " Lps");
                        
                        // Actualizar caja y contadores
                        caja += total;
                        numeroVentas++;
                        totalVentas += total;
                        
                        // Calcular ganancia de la venta
                        double gananciaVenta = total * 0.2;
                        if (gananciaVenta > ventaMayorGanancia) {
                            ventaMayorGanancia = gananciaVenta;
                        }
                    }
                }
            }
            // Opción 3: Compras
            else if (opcion == 3) {
                if (!cajaAbierta) {
                    System.out.println("La caja está cerrada. Primero ábrala con la opción 1.");
                } else {
                    // Pedir tipo de proveedor con validación
                    String tipoProveedor;
                    do {
                        System.out.print("Ingrese tipo de proveedor (A, B, C): ");
                        tipoProveedor = scanner.next().toUpperCase();
                        if (!tipoProveedor.equals("A") && !tipoProveedor.equals("B") && !tipoProveedor.equals("C")) {
                            System.out.println("Tipo de proveedor no válido. Intente nuevamente.");
                        }
                    } while (!tipoProveedor.equals("A") && !tipoProveedor.equals("B") && !tipoProveedor.equals("C"));

                    // Mostrar productos disponibles según proveedor
                    System.out.println("\nProductos disponibles para este proveedor:");
                    if (tipoProveedor.equals("A")) {
                        System.out.println("1. " + productoAzucar);
                        System.out.println("4. " + productoMaiz);
                    } else if (tipoProveedor.equals("B")) {
                        System.out.println("2. " + productoAvena);
                        System.out.println("3. " + productoTrigo);
                    } else {
                        System.out.println("2. " + productoAvena);
                    }
                    
                    // Pedir código de producto
                    System.out.print("Ingrese el código del producto a comprar: ");
                    int codigoCompra = scanner.nextInt();
                    
                    // Validar producto según proveedor
                    boolean productoValidoCompra = false;
                    String nombreProductoCompra = "";
                    double precioProductoCompra = 0;
                    
                    if (codigoCompra == 1) { // Azúcar
                        if (tipoProveedor.equals("A")) {
                            productoValidoCompra = true;
                            nombreProductoCompra = productoAzucar;
                            precioProductoCompra = precioCompraAzucar;
                        }
                    } else if (codigoCompra == 2) { // Avena
                        if (tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                            productoValidoCompra = true;
                            nombreProductoCompra = productoAvena;
                            precioProductoCompra = precioCompraAvena;
                        }
                    } else if (codigoCompra == 3) { // Trigo
                        if (tipoProveedor.equals("B")) {
                            productoValidoCompra = true;
                            nombreProductoCompra = productoTrigo;
                            precioProductoCompra = precioCompraTrigo;
                        }
                    } else if (codigoCompra == 4) { // Maíz
                        if (tipoProveedor.equals("A")) {
                            productoValidoCompra = true;
                            nombreProductoCompra = productoMaiz;
                            precioProductoCompra = precioCompraMaiz;
                        }
                    } else {
                        System.out.println("Código de producto no válido.");
                    }
                    
                    if (!productoValidoCompra) {
                        System.out.println("Proveedor no vende este producto.");
                    } else {
                        // Pedir cantidad
                        System.out.print("Ingrese la cantidad de kilogramos a comprar: ");
                        double kgCompra = scanner.nextDouble();
                        
                        if (kgCompra > 0) {
                            double totalCompra = kgCompra * precioProductoCompra;
                            
                            if (totalCompra > caja) {
                                System.out.println("No se puede pagar la compra. Fondos insuficientes.");
                            } else {
                                // Realizar la compra
                                caja -= totalCompra;
                                numeroCompras++;
                                totalCompras += totalCompra;
                                
                                // Actualizar inventario
                                if (codigoCompra == 1) {
                                    inventarioAzucar += kgCompra;
                                } else if (codigoCompra == 2) {
                                    inventarioAvena += kgCompra;
                                } else if (codigoCompra == 3) {
                                    inventarioTrigo += kgCompra;
                                } else if (codigoCompra == 4) {
                                    inventarioMaiz += kgCompra;
                                }
                                
                                if (totalCompra > compraMayorCosto) {
                                    compraMayorCosto = totalCompra;
                                }
                                
                                System.out.println("\n=== COMPRA REALIZADA ===");
                                System.out.println("Producto: " + nombreProductoCompra);
                                System.out.println("Cantidad: " + kgCompra + " kg");
                                System.out.println("Precio por kg: " + precioProductoCompra + " Lps");
                                System.out.println("TOTAL COMPRA: " + totalCompra + " Lps");
                                System.out.println("Nuevo inventario de " + nombreProductoCompra + ": " + 
                                    (codigoCompra == 1 ? inventarioAzucar : 
                                     codigoCompra == 2 ? inventarioAvena : 
                                     codigoCompra == 3 ? inventarioTrigo : inventarioMaiz) + " kg");
                            }
                        } else {
                            System.out.println("Cantidad no válida.");
                        }
                    }
                }
            }
            // Opción 4: Reportes
            else if (opcion == 4) {
                if (!cajaAbierta) {
                    System.out.println("La caja no está abierta.");
                } else {
                    System.out.println("\n=== REPORTES DEL DÍA ===");
                    System.out.println("1. Cantidad actual en caja: " + caja + " Lps");
                    System.out.println("2. Número de ventas: " + numeroVentas);
                    System.out.println("   Número de compras: " + numeroCompras);
                    System.out.println("3. Volumen total de ventas: " + totalVentas + " Lps");
                    System.out.println("   Volumen total de compras: " + totalCompras + " Lps");
                    System.out.println("   Margen de ganancia: " + (totalVentas - totalCompras) + " Lps");
                    System.out.println("4. Valor medio de venta: " + (numeroVentas > 0 ? totalVentas / numeroVentas : 0) + " Lps");
                    System.out.println("   Valor medio de compra: " + (numeroCompras > 0 ? totalCompras / numeroCompras : 0) + " Lps");
                    System.out.println("5. Venta con mayor ganancia: " + ventaMayorGanancia + " Lps");
                    System.out.println("   Compra con más gasto: " + compraMayorCosto + " Lps");
                    
                    // Producto estrella
                    String productoEstrella = "Ninguno";
                    double maxVentas = 0;
                    if (ventasAzucar > maxVentas) {
                        maxVentas = ventasAzucar;
                        productoEstrella = productoAzucar;
                    }
                    if (ventasAvena > maxVentas) {
                        maxVentas = ventasAvena;
                        productoEstrella = productoAvena;
                    }
                    if (ventasTrigo > maxVentas) {
                        maxVentas = ventasTrigo;
                        productoEstrella = productoTrigo;
                    }
                    if (ventasMaiz > maxVentas) {
                        maxVentas = ventasMaiz;
                        productoEstrella = productoMaiz;
                    }
                    System.out.println("6. Producto estrella: " + productoEstrella + " (" + maxVentas + " kg vendidos)");
                    
                    // Inventario actual
                    System.out.println("\nInventario actual:");
                    System.out.println("Azúcar: " + inventarioAzucar + " kg");
                    System.out.println("Avena: " + inventarioAvena + " kg");
                    System.out.println("Trigo: " + inventarioTrigo + " kg");
                    System.out.println("Maíz: " + inventarioMaiz + " kg");
                }
            }
            // Opción 5: Cierre de caja
            else if (opcion == 5) {
                if (!cajaAbierta) {
                    System.out.println("La caja ya está cerrada.");
                } else {
                    System.out.println("\n=== CIERRE DE CAJA ===");
                    System.out.println("Total en caja: " + caja + " Lps");
                    
                    // Calcular ganancia
                    double ganancia = totalVentas - totalCompras;
                    System.out.println("Ganancia del día: " + ganancia + " Lps");
                    
                    // Deposito en banco
                    System.out.print("¿Cuánto desea depositar en el banco? (Máximo 60%): ");
                    double deposito = scanner.nextDouble();
                    double maxDeposito = caja * 0.6;
                    
                    if (deposito > maxDeposito) {
                        System.out.println("No puede depositar más del 60% (" + maxDeposito + ")");
                        deposito = maxDeposito;
                    }
                    
                    if (deposito > 0) {
                        caja -= deposito;
                        System.out.println("Se depositaron " + deposito + " Lps en el banco");
                        System.out.println("Efectivo restante en caja: " + caja + " Lps");
                    }
                    
                    // Cerrar caja
                    cajaAbierta = false;
                    System.out.println("Caja cerrada. Para operar nuevamente debe abrir la caja.");
                }
            }
            // Opción 6: Salir
            else if (opcion == 6) {
                System.out.println("Saliendo del sistema...");
                scanner.close();
                return;
            }
            // Opción no válida
            else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
