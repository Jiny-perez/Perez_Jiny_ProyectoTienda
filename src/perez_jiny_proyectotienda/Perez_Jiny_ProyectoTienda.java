/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perez_jiny_proyectotienda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Perez_Jiny_ProyectoTienda {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in).useDelimiter("\n");

        //Declaracion de variables
        int opcionMenu = 0;
        //Variables para restricciones del estado del sistema.
        boolean abrirCaja = false, compra = false, cerrarCaja = false;
        //Variables para caja, ventas y compras.
        String producto = "";
        double caja = 0, cantidadIngresada = 0, isv = 0, cantKilosVenta = 0;
        double stockAzucar = 0, stockAvena = 0, stockMaiz = 0, stockTrigo = 0;
        //Variables para reportes.
        int numeroCompras = 0, numeroVentas = 0;
        double totalVenta = 0, totalCompra = 0, mayorGastoCompra = 0, mayorGananciaVentas = 0;
        String productoMayorGanancia = "", productoMayorGasto = "", productoEstrella = "";
        double margenGanancia, valorMedioVenta, valorMedioCompra, maxCantVendida = 0;
        double cantVendidaAzucar = 0, cantVendidaAvena = 0, cantVendidaTrigo = 0, cantVendidaMaiz = 0;

        //Ciclo principal, se ejecuta hasta la opcion 6.
        while (opcionMenu != 6) {
            try {
                //Impresión de menu principal.
                System.out.println(" ___________________________________________________________________");
                System.out.println("|                            TIENDA JAVA                            |");
                System.out.println("|-------------------------------------------------------------------|");
                System.out.println("|                           MENU PRINCIPAL                          |");
                System.out.println("|-------------------------------------------------------------------|");
                System.out.println("| [1] Abrir Caja                                                    |");
                System.out.println("| [2] Ventas                                                        |");
                System.out.println("| [3] Compras                                                       |");
                System.out.println("| [4] Reportes                                                      |");
                System.out.println("| [5] Cierre de Caja                                                |");
                System.out.println("| [6] Salir del Sistema                                             |");
                System.out.println("|___________________________________________________________________|\n");
                System.out.print("Seleccionar la opcion deseada: ");
                opcionMenu = lea.nextInt();

                switch (opcionMenu) {
                    case 1:
                        //Reinicio de variables cuando caja sea cerrada.
                        if (cerrarCaja) {
                            numeroCompras = 0;
                            numeroVentas = 0;
                            totalVenta = 0;
                            totalCompra = 0;
                            mayorGastoCompra = 0;
                            mayorGananciaVentas = 0;
                            cantVendidaAzucar = 0;
                            cantVendidaAvena = 0;
                            cantVendidaTrigo = 0;
                            cantVendidaMaiz = 0;
                            maxCantVendida = 0;
                            productoEstrella = "";
                            productoMayorGanancia = "";
                            productoMayorGasto = "";

                            //Estados de la caja.
                            abrirCaja = true;
                            cerrarCaja = false;

                            System.out.println("____________________________________________________________________");
                            System.out.println("                        ABRIR CAJA - TIENDA JAVA                    ");
                            System.out.println("____________________________________________________________________\n");
                            System.out.println("                      Se ha abierto la caja correctamente.          ");
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println(String.format("%-55s L. %.2f", "Cantidad en Caja:", caja));
                            System.out.println("____________________________________________________________________");
                            System.out.println("");
                            System.out.println("Regresando al menu...\n");
                        } else {

                            //Estados de la caja.
                            abrirCaja = true;
                            cerrarCaja = false;

                            System.out.println("____________________________________________________________________");
                            System.out.println("                        ABRIR CAJA - TIENDA JAVA                    ");
                            System.out.println("____________________________________________________________________\n");

                            //Ciclo para ingresar una cantidad de dinero.
                            while (true) {
                                try {
                                    System.out.print("Ingrese la cantidad de dinero que desea guardar en caja: ");
                                    cantidadIngresada = lea.nextDouble();

                                    //Validacion sobre si la cantidad es positva.
                                    if (cantidadIngresada <= 0) {
                                        System.out.println("Error: Ingrese una cantidad valida.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                    } else {
                                        //Actualizacion de caja y confirmacion de que ha sido guardado el monto.
                                        caja += cantidadIngresada;
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println("                      Se ha guardado correctamente.                ");
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println(String.format("%-55s L. %.2f", "Cantidad Guardada:", cantidadIngresada));
                                        System.out.println(String.format("%-55s L. %.2f", "Cantidad Total:", caja));
                                        System.out.println("____________________________________________________________________");
                                        System.out.println("");
                                        System.out.println("Regresando al menu...\n");
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    //Impresión de error para entrada no numérica.
                                    System.out.println("Error: Ingrese datos numericos.\n ");
                                    System.out.println("--------------------------------------------------------------------");
                                    lea.next();
                                }
                            }
                        }
                        break;
                    case 2:
                        //Requisitos para entrar a venta.
                        if (!abrirCaja) {
                            System.out.println("\n--------------------------------------------------------------------");
                            System.out.println("     Error: No es posible habilitar ventas, debe de abrir caja.     ");
                            System.out.println("--------------------------------------------------------------------\n");
                            break;
                        }
                        if (!compra) {
                            System.out.println("\n--------------------------------------------------------------------");
                            System.out.println("Error: No es posible habilitar ventas, debe de realizar una compra.");
                            System.out.println("--------------------------------------------------------------------\n");
                            break;
                        }

                        System.out.println("____________________________________________________________________");
                        System.out.println("                         VENTAS  - TIENDA JAVA                      ");
                        System.out.println("____________________________________________________________________\n");

                        //Variables para la validacion de tipos de clientes.
                        String tipoClienteVenta;
                        char clienteVenta;

                        //Selección y manejo de tipo de clientes.
                        while (true) {
                            System.out.print("Ingrese el tipo del cliente (A, B o C): ");
                            tipoClienteVenta = lea.next().toUpperCase();

                            if (tipoClienteVenta.equals("A") || tipoClienteVenta.equals("B") || tipoClienteVenta.equals("C")) {
                                clienteVenta = tipoClienteVenta.charAt(0);
                                break;
                            } else {
                                System.out.println("Error: Ingrese una opcion valida (A, B o C).\n");
                                System.out.println("--------------------------------------------------------------------\n");
                            }
                        }

                        //Variables para el proceso de ventas.
                        int codProductoVenta = 0;
                        String facturaVenta = "",
                         adquirirProducto = "",
                         porcentDescuento = "";
                        double precioUniVenta = 0;
                        double totalProductoVenta = 0,
                         subtotalVenta = 0,
                         descuento = 0,
                         totalPagarVenta = 0;

                        //Ciclo para adqurir otro producto en ventas.
                        do {
                            //Impresión sobre los productos de tienda Java.
                            System.out.println(" ____________________________________________________________________");
                            System.out.println("| Codigo           |  Producto                 | Precio              |");
                            System.out.println("|--------------------------------------------------------------------|");
                            System.out.println("| 1                |  Azucar                   |  L. 30.00           |");
                            System.out.println("| 2                |  Avena                    |  L. 25.00           |");
                            System.out.println("| 3                |  Trigo                    |  L. 32.00           |");
                            System.out.println("| 4                |  Maiz                     |  L. 20.00           |");
                            System.out.println("|____________________________________________________________________|\n");

                            //Validación del código del producto que el usario desea.
                            while (true) {
                                try {
                                    System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                                    codProductoVenta = lea.nextInt();

                                    if (codProductoVenta < 1 || codProductoVenta > 4) {
                                        System.out.println("Error: El codigo que escogio es invalido.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Ingrese un codigo valido (1 - 4).\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    lea.next();
                                }
                            }

                            //Asignación de producto y precio según el código y validación de disponibilidad sobre el producto por el tipo de cliente.
                            boolean tipoProducto = true;
                            switch (codProductoVenta) {
                                case 1:
                                    producto = "Azucar";
                                    precioUniVenta = 30.00;
                                    if (clienteVenta == 'C') {
                                        System.out.println("Error: Este producto no esta disponible.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 2:
                                    producto = "Avena";
                                    precioUniVenta = 25.00;
                                    if (clienteVenta == 'C') {
                                        System.out.println("Error: Este producto no esta disponible.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 3:
                                    producto = "Trigo";
                                    precioUniVenta = 32.00;
                                    if (clienteVenta == 'C') {
                                        System.out.println("Error: Este producto no esta disponible.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 4:
                                    producto = "Maiz";
                                    precioUniVenta = 20.00;
                                    if (clienteVenta == 'B') {
                                        System.out.println("Error: Este producto no esta disponible.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                        tipoProducto = false;
                                    }
                                    break;
                                default:
                                    System.out.println("Error: Esta opcion no existe.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    tipoProducto = false;
                                    break;
                            }

                            //Si el producto corresponde al cliente, procesar la venta.
                            if (tipoProducto) {
                                //Comprobación de stock disponible sobre el producto seleccionado .
                                double stockDisponible = 0;
                                switch (codProductoVenta) {
                                    case 1:
                                        stockDisponible = stockAzucar;
                                        break;
                                    case 2:
                                        stockDisponible = stockAvena;
                                        break;
                                    case 3:
                                        stockDisponible = stockTrigo;
                                        break;
                                    case 4:
                                        stockDisponible = stockMaiz;
                                        break;
                                }
                                System.out.println(String.format("Stock disponible de %s: %.2f kg", producto, stockDisponible));

                                //Veficación si hay stock suficiente.
                                if (stockDisponible <= 0) {
                                    System.out.println("\n--------------------------------------------------------------------");
                                    System.out.println("            Error: No hay stock disponible de este producto.        ");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    System.out.print("Desea elegir otro producto (SI/NO): ");
                                    adquirirProducto = lea.next().toUpperCase();
                                    if (adquirirProducto.equals("SI")) {
                                        continue;
                                    } else {
                                        break;
                                    }
                                }

                                //Ingreso de la cantidad a vender.
                                boolean cantidadValida = false;
                                while (!cantidadValida) {
                                    try {
                                        System.out.print("Ingrese la cantidad en kilogramos de " + producto + ": ");
                                        cantKilosVenta = lea.nextDouble();
                                        if (cantKilosVenta <= 0) {
                                            System.out.println("Error: Ingrese una cantidad valida.\n");
                                            System.out.println("--------------------------------------------------------------------\n");
                                            continue;
                                        }

                                        //Verificación y actualización del stock segun el producto seleccionado .
                                        boolean stockSuficiente = false;
                                        if (codProductoVenta == 1 && stockAzucar >= cantKilosVenta) {
                                            stockAzucar -= cantKilosVenta;
                                            cantVendidaAzucar += cantKilosVenta;
                                            stockSuficiente = true;
                                        } else if (codProductoVenta == 2 && stockAvena >= cantKilosVenta) {
                                            stockAvena -= cantKilosVenta;
                                            cantVendidaAvena += cantKilosVenta;
                                            stockSuficiente = true;
                                        } else if (codProductoVenta == 3 && stockTrigo >= cantKilosVenta) {
                                            stockTrigo -= cantKilosVenta;
                                            cantVendidaTrigo += cantKilosVenta;
                                            stockSuficiente = true;
                                        } else if (codProductoVenta == 4 && stockMaiz >= cantKilosVenta) {
                                            stockMaiz -= cantKilosVenta;
                                            cantVendidaMaiz += cantKilosVenta;
                                            stockSuficiente = true;
                                        } else {
                                            //Mensaje si no hay stock suficiente.
                                            System.out.println("\n--------------------------------------------------------------------");
                                            System.out.println("          Error: No hay suficiente cantidad de productos.            ");
                                            System.out.println("--------------------------------------------------------------------\n");

                                            System.out.print("Desea intentar con una cantidad menor (SI/NO): ");
                                            String intentarDeNuevo = lea.next().toUpperCase();
                                            if (intentarDeNuevo.equals("SI")) {
                                                continue;
                                            } else {
                                                adquirirProducto = "NO";
                                                cantidadValida = true;
                                                break;
                                            }
                                        }

                                        //Calculos sobre la venta a realizar y se añade a factura si hay stock suficiente.
                                        if (stockSuficiente) {
                                            totalProductoVenta = cantKilosVenta * precioUniVenta;
                                            facturaVenta += String.format("%-19s %-19s %-12s L. %.2f\n", producto, String.format("%.0f", cantKilosVenta), String.format("%.0f", precioUniVenta), totalProductoVenta);
                                            subtotalVenta += totalProductoVenta;
                                            cantidadValida = true;
                                        }
                                    } catch (InputMismatchException e) {
                                        //Impresión de error para entrada no numérica.
                                        System.out.println("Error: Ingrese una cantidad numerica valida.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                        lea.next();
                                    }
                                }
                            }

                            //Verifica si quiere adquirir otro producto.
                            if (!adquirirProducto.equals("NO")) {
                                boolean respuestaCompraValida = false;
                                while (!respuestaCompraValida) {
                                    System.out.print("Desea comprar otro producto (SI/NO): ");
                                    adquirirProducto = lea.next().toUpperCase();

                                    if (adquirirProducto.equals("SI") || adquirirProducto.equals("NO")) {
                                        respuestaCompraValida = true;
                                    } else { //Verifica si se realizó alguna venta.
                                        System.out.println("\n--------------------------------------------------------------------");
                                        System.out.println("                   Error: Debe ingresar SI o NO.                      ");
                                        System.out.println("--------------------------------------------------------------------\n");
                                    }
                                }
                            }

                        } while (adquirirProducto.equals("SI"));

                        //Calculos sobre el descuento dependiendo del subtotal.
                        if (subtotalVenta > 5000) {
                            descuento = subtotalVenta * 0.10;
                            porcentDescuento = "10%";
                        } else if (subtotalVenta >= 1000) {
                            descuento = subtotalVenta * 0.05;
                            porcentDescuento = "05%";
                        } else {
                            descuento = 0;
                            porcentDescuento = "";
                        }

                        //Calculó de impuestos y total a pagar.                        
                        isv = subtotalVenta * 0.07;
                        totalPagarVenta = (subtotalVenta - descuento) + isv;

                        //Actualización de caja y estaditicas de venta para reporte.
                        caja += totalPagarVenta;
                        numeroVentas++;
                        totalVenta += totalPagarVenta;

                        //Registro de venta con mayor ganancia.
                        if (totalPagarVenta > mayorGananciaVentas) {
                            mayorGananciaVentas = totalPagarVenta;
                        }

                        //Impresión de factura de venta.
                        System.out.println("\n____________________________________________________________________");
                        System.out.println("                           TIENDA JAVA                                ");
                        System.out.println("                              FACTURA                                 ");
                        System.out.println("____________________________________________________________________");
                        System.out.println("Tipo de Cliente: " + clienteVenta);
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("Producto       Cantidad(kg)       Precio Unit.          Total");
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(facturaVenta);
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Subtotal:", subtotalVenta));
                        System.out.println(String.format("%-50s L. %.2f", "Descuento " + porcentDescuento + ":", descuento));
                        System.out.println(String.format("%-50s L. %.2f", "ISV %7:", isv));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagarVenta));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("                      GRACIAS POR SU COMPRA.                    ");
                        System.out.println("____________________________________________________________________\n");
                        break;
                    case 3:
                        //Requisito para realizar compra.                        
                        if (!abrirCaja) {
                            System.out.println("\n--------------------------------------------------------------------");
                            System.out.println("      Error: Debe de abrir caja antes de poder realizar compras.     ");
                            System.out.println("--------------------------------------------------------------------\n");
                            break;
                        }

                        System.out.println("____________________________________________________________________");
                        System.out.println("                         COMPRAS  - TIENDA JAVA                      ");
                        System.out.println("____________________________________________________________________");
                        System.out.println(String.format("%-55s L. %.2f", "Cantidad en Caja:", caja));
                        System.out.println("--------------------------------------------------------------------\n");

                        //Variables para el tipo proveedor.                       
                        String tipoProveedor;
                        char proveedor;

                        //Selección y validación del tipo de proveedor.                       
                        while (true) {
                            System.out.print("Ingrese el tipo de Proveedor (A, B o C): ");
                            tipoProveedor = lea.next().toUpperCase();

                            if (tipoProveedor.equals("A") || tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                proveedor = tipoProveedor.charAt(0);
                                break;
                            } else {
                                System.out.println("Error: Ingrese una opcion valida (A, B o C).\n");
                                System.out.println("--------------------------------------------------------------------\n");
                            }
                        }

                        //Variables para el proceso de compras.
                        int codProductoCompra = 0;
                        String facturaCompra = "";
                        double precioUniCompra = 0.00,
                         cantKilosCompra = 0;
                        double totalProductoCompra = 0,
                         subtotalCompra = 0,
                         totalPagarCompra = 0;

                        //Impresion de catálogo de productos para comprar.
                        System.out.println(" ___________________________________________________________________");
                        System.out.println("| Codigo                            |  Producto                     |");
                        System.out.println("|-------------------------------------------------------------------|");
                        System.out.println("| 1                                 |  Azucar                       |");
                        System.out.println("| 2                                 |  Avena                        |");
                        System.out.println("| 3                                 |  Trigo                        |");
                        System.out.println("| 4                                 |  Maiz                         |");
                        System.out.println("|___________________________________________________________________|\n");

                        //Validación del código de producto.
                        while (true) {
                            try {
                                System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                                codProductoCompra = lea.nextInt();

                                if (codProductoCompra < 1 || codProductoCompra > 4) {
                                    System.out.println("Error: El codigo que escogio es invalido.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                } else {
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese un codigo valido (1 - 4).\n");
                                System.out.println("--------------------------------------------------------------------\n");
                                lea.next();
                            }
                        }

                        // Asignación de producto y precio según código y validación de disponibilidad por tipo de proveedor.
                        boolean tipoCompra = true;
                        switch (codProductoCompra) {
                            case 1:
                                producto = "Azucar";
                                precioUniCompra = 25.00;
                                if (proveedor == 'B' || proveedor == 'C') {
                                    System.out.println("Error: Este producto no esta disponible por el proveedor.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    tipoCompra = false;
                                }
                                break;
                            case 2:
                                producto = "Avena";
                                if (proveedor == 'A') {
                                    System.out.println("Error: Este producto no esta disponible por el proveedor.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    tipoCompra = false;
                                } else if (proveedor == 'B') {
                                    precioUniCompra = 20.00;
                                } else if (proveedor == 'C') {
                                    precioUniCompra = 22.00;
                                }
                                break;
                            case 3:
                                producto = "Trigo";
                                precioUniCompra = 30.00;
                                if (proveedor == 'A' || proveedor == 'C') {
                                    System.out.println("Error: Este producto no esta disponible por el proveedor.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    tipoCompra = false;
                                }
                                break;
                            case 4:
                                producto = "Maiz";
                                precioUniCompra = 18.00;
                                if (proveedor == 'B' || proveedor == 'C') {
                                    System.out.println("Error: Este producto no esta disponible por el proveedor.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    tipoCompra = false;
                                }
                                break;
                            default:
                                System.out.println("Error: Esta opcion no existe.\n");
                                System.out.println("--------------------------------------------------------------------\n");
                                tipoCompra = false;
                                break;
                        }

                        //Si el producto corresponde al proveedor, procesar la compra.
                        if (tipoCompra) {
                            while (true) {
                                try {
                                    System.out.print("Ingrese la cantidad en kilogramos de " + producto + " a comprar : ");
                                    cantKilosCompra = lea.nextDouble();

                                    //Validación de cantidad positiva.                                    
                                    if (cantKilosCompra <= 0) {
                                        System.out.println("Error: Ingrese una cantidad válida mayor que cero.\n");
                                        System.out.println("--------------------------------------------------------------------\n");
                                        continue;
                                    }

                                    //Calculos sobre la compra.
                                    totalProductoCompra = cantKilosCompra * precioUniCompra;
                                    subtotalCompra += totalProductoCompra;
                                    totalPagarCompra = subtotalCompra;

                                    //Verificación si en caja hay saldo suficiente.
                                    if (caja >= totalPagarCompra) {
                                        //Actualizar el stock del producto a comprar.
                                        if (codProductoCompra == 1) {
                                            stockAzucar += cantKilosCompra;
                                        } else if (codProductoCompra == 2) {
                                            stockAvena += cantKilosCompra;
                                        } else if (codProductoCompra == 3) {
                                            stockTrigo += cantKilosCompra;
                                        } else if (codProductoCompra == 4) {
                                            stockMaiz += cantKilosCompra;
                                        }

                                        facturaCompra = String.format("%-19s %-19s %-10.2s L. %.2f\n", producto, String.format("%.0f", cantKilosCompra), String.format("%.0f", precioUniCompra), totalProductoCompra);

                                        //Registro de producto con mayor gasto.
                                        if (totalPagarCompra > mayorGastoCompra) {
                                            mayorGastoCompra = totalPagarCompra;
                                            productoMayorGasto = producto;
                                        }

                                        //Impresion de la factura compra.
                                        System.out.println("\n____________________________________________________________________");
                                        System.out.println("                              TIENDA JAVA                           ");
                                        System.out.println("                                FACTURA                             ");
                                        System.out.println("____________________________________________________________________");
                                        System.out.println("Tipo de Proveedor: " + proveedor);
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println("Producto       Cantidad(kg)       Precio Unit.       Total");
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println(facturaCompra);
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println(String.format("%-55s L. %.2f", "Subtotal:", subtotalCompra));
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println(String.format("%-55s L. %.2f", "TOTAL A PAGAR:", totalPagarCompra));
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println("                          GRACIAS POR SU COMPRA.                     ");
                                        System.out.println("____________________________________________________________________\n");

                                        //Actualización de caja y estadistica de compras para reporte.                                       
                                        caja -= totalPagarCompra;
                                        totalCompra += totalPagarCompra;
                                        numeroCompras++;
                                        compra = true;
                                    } else {
                                        //Mensaje si no hay saldo suficiente.
                                        System.out.println("\n--------------------------------------------------------------------");
                                        System.out.println("Error: No se puede realizar la compra, saldo insuficiente.");
                                        System.out.println("Disponiblidad: L." + caja);
                                        System.out.println("--------------------------------------------------------------------\n");
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    //Impresion de error para entrada no númericas.  
                                    System.out.println("\n--------------------------------------------------------------------");
                                    System.out.println("            Error: Ingrese una cantidad numerica valida.               ");
                                    System.out.println("--------------------------------------------------------------------\n");
                                    lea.next();
                                }
                            }
                        }
                        break;
                    case 4:
                        //
                        if (!abrirCaja) {
                            System.out.println("\n--------------------------------------------------------------------\n");
                            System.out.println("     Error: No es posible abrir Reporte, primero debe abrir caja.     ");
                            System.out.println("--------------------------------------------------------------------\n");
                            break;
                        }

                        //Calculó de margen de ganancia entre venta y compra.
                        margenGanancia = totalVenta - totalCompra;

                        //Calculó del valor medio de venta y compra.
                        if (numeroVentas > 0) {
                            valorMedioVenta = totalVenta / numeroVentas;
                        } else {
                            valorMedioVenta = 0;
                        }

                        if (numeroCompras > 0) {
                            valorMedioCompra = totalCompra / numeroCompras;
                        } else {
                            valorMedioCompra = 0;
                        }

                        //Verificación sobre cual es el producto estrella.
                        if (cantVendidaAzucar > maxCantVendida) {
                            maxCantVendida = cantVendidaAzucar;
                            productoEstrella = "Azucar";
                        }
                        if (cantVendidaAvena > maxCantVendida) {
                            maxCantVendida = cantVendidaAvena;
                            productoEstrella = "Avena";
                        }
                        if (cantVendidaTrigo > maxCantVendida) {
                            maxCantVendida = cantVendidaTrigo;
                            productoEstrella = "Trigo";
                        }
                        if (cantVendidaMaiz > maxCantVendida) {
                            maxCantVendida = cantVendidaMaiz;
                            productoEstrella = "Maiz";
                        }

                        //Impresion y resultados sobre venta y compra.
                        System.out.println("\n____________________________________________________________________");
                        System.out.println("                             TIENDA JAVA                              ");
                        System.out.println("                                REPORTE                               ");
                        System.out.println("____________________________________________________________________");
                        System.out.println(String.format("%-50s L. %.2f", "Cantidad Actual:", caja));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s %d", "Compras Realizadas:", numeroCompras));
                        System.out.println(String.format("%-50s L. %.2f", "Gasto sobre Compra:", totalCompra));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s %d", "Ventas Realizadas:", numeroVentas));
                        System.out.println(String.format("%-50s L. %.2f", "Ganancias sobre Venta:", totalVenta));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Margen de Ganancia:", margenGanancia));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Promedio de Venta:", valorMedioVenta));
                        System.out.println(String.format("%-50s L. %.2f", "Promedio de Compra:", valorMedioCompra));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Venta con Mayor Ganancia:", mayorGananciaVentas));
                        System.out.println(String.format("%-50s L. %.2f", "Compra con Mayor Gasto:", mayorGastoCompra));
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(String.format("%-50s %s", "Producto Estrella:", productoEstrella));
                        System.out.println("____________________________________________________________________\n");
                        break;
                    case 5:
                        //Requisito para cerrar caja.
                        if (!abrirCaja) {
                            System.out.println("\n--------------------------------------------------------------------");
                            System.out.println("       Error: No es posible cerrar caja, primero debe abrir caja.     ");
                            System.out.println("--------------------------------------------------------------------\n");
                            break;
                        }

                        // Verificar si la caja ya fue cerrada
                        if (cerrarCaja) {
                            System.out.println("\n--------------------------------------------------------------------");
                            System.out.println("     Error: La caja ya ha sido cerrada. Debe abrir caja nuevamente.   ");
                            System.out.println("--------------------------------------------------------------------\n");
                            break;
                        }

                        //Variables para el cierre caja.
                        double maximoDeposito = caja * 0.60;
                        double montoDepositado = 0;

                        System.out.println("____________________________________________________________________");
                        System.out.println("                    CIERRE DE CAJA  - TIENDA JAVA                   ");
                        System.out.println("____________________________________________________________________\n");
                        // Imprime el total de dinero en caja y el máximo que se puede depositar. 
                        System.out.println(String.format("%-50s L. %.2f", "Total de Ganancias:", caja));
                        System.out.println(String.format("%-50s L. %.2f", "Maximo a depositar en banco 60%:", maximoDeposito));
                        System.out.println("--------------------------------------------------------------------");

                        //Selección y validación cantidad a depositar.
                        while (true) {
                            try {
                                System.out.print("Ingrese la cantidad que desea depositar en el banco: ");
                                montoDepositado = lea.nextDouble();

                                //Validación de monto positivo.
                                if (montoDepositado <= 0) {
                                    System.out.println("Error: Ingrese una cantidad válida.\n");
                                    System.out.println("--------------------------------------------------------------------\n");
                                } else if (montoDepositado > maximoDeposito) {
                                    System.out.println("Error: El monto excede el 60% permitido. Maximo a depositar: L. " + maximoDeposito);
                                    System.out.println("--------------------------------------------------------------------\n");
                                } else {
                                    //Actualización de caja y confrimación de cierre.
                                    caja -= montoDepositado;
                                    cerrarCaja = true;
                                    //Impresión del monto depositado y lo restante en caja.
                                    System.out.println("____________________________________________________________________");
                                    System.out.println("                             TIENDA JAVA                            ");
                                    System.out.println("                            CIERRE DE CAJA                          ");
                                    System.out.println("____________________________________________________________________");
                                    System.out.println(String.format("%-50s L. %.2f", "Monto depositado en banco:", montoDepositado));
                                    System.out.println(String.format("%-50s L. %.2f", "Efectivo restante en caja:", caja));
                                    System.out.println("____________________________________________________________________\n");
                                    abrirCaja = false;
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                //Impresión de error cuando es un valor no numerico.
                                System.out.println("\n--------------------------------------------------------------------");
                                System.out.println("                 Error: Ingrese un valor numérico válido.             ");
                                System.out.println("--------------------------------------------------------------------\n");
                                lea.next();
                            }
                        }
                        break;
                    case 6:
                        // Opción para salir del sistema.
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    default:
                        // Impresión de error cuando la opción esta fuera del rango.
                        System.out.println("\n--------------------------------------------------------------------");
                        System.out.println("        Error: Opcion invalida. Ingrese una opcion del (1 - 6).       ");
                        System.out.println("--------------------------------------------------------------------\n");
                }
            } catch (InputMismatchException e) {
                //Impresión de error cuando es un valor no numerico.
                System.out.println("\n--------------------------------------------------------------------");
                System.out.println("             Error: Ingrese una opcion numerica valida.               ");
                System.out.println("--------------------------------------------------------------------\n");
                lea.next();
            }
        }
    }
}
