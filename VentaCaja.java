import java.util.Scanner;
public class VentaCaja {
    int op;
    Refresco refresco;
    static Scanner leerop = new Scanner(System.in);
    Refresco CantidadProducto[] = new Refresco[5];
    int CanProducto=0;
    double Total=0;
    int Nip=2037;
    public void MenuPrincipal() {
        System.out.println("¿Proceso a realiza?");
        System.out.println("1. Introducir productos.\n2. Realizar pago de productos.\n3. Salir");
        op=leerop.nextInt();
        switch (op) {
            case 1:
                mProductos();
                break;
            case 2:
                PagoP();
                break;
            case 3:
                System.exit(0);
                break;
        
            default:
                break;
        }
    }

    private void mProductos() {
        boolean opc = false;
        while (opc == false) {
            System.out.println("En este verano les ofrecemos descuentos del 15% en refresco de la marca Mi refresco.");
            System.out.println("Ademas en la compra de 2 refrescos con presentacion de 500 ml llevate gratis 1 de 235 ml.");
            System.out.println("\t---Tipo de Producto---");
            System.out.println("1. Refresco\n2. Menu Principal");
            op=leerop.nextInt();
            switch (op) {
                case 1:
                    if (CanProducto <5) {
                        registroRefresco(CanProducto); 
                    } else {System.out.println("No es posible ingresar mas productos, solo puede llevar 5");}
                    break;
                case 2:
                    opc = true;
                    MenuPrincipal();
                    break;   
                default:
                    break;
            }
            CanProducto++;
        }
    }
    
    private void registroRefresco(int CanProducto) {
        int Rmarca;
        int Rpresentacion;
        String marca = "";
        String presentacion = "";
        double precio = 0;
        boolean descuento = false;

        System.out.println("\t---Marca---");
        System.out.println("1. Mi refresco\n2. Coca-Cola");
        Rmarca=leerop.nextInt();
        System.out.println("\t---Presentacion---");
        System.out.println("1. 600 ml\n2. 500 ml\n3. 235 ml");
        Rpresentacion=leerop.nextInt();
        switch (Rmarca) {
            case 1:
                marca = "Mi refresco";
                break;
            case  2:
                marca = "Coca-Cola";
                break;
        
            default:
                break;
        }
        switch (Rpresentacion) {
            case 1:
                presentacion = "600 ml";
                precio = 13;
                descuento = true;
                break;
            case 2:
                presentacion = "500 ml";
                precio = 12;
                descuento = false;
                break;
            case 3:
                presentacion = "235 ml";
                precio = 8;
                descuento = true;
                break;
            default:
                break;
        }
        if (Rmarca==1) {
            if (descuento==true) {
                precio = precio - (precio * 0.15);
            }
            
        } else {System.out.println("Este producto no tiene descuento del 15%");}
        if (CantidadProducto.length <=5) {
            refresco = new Refresco(marca, presentacion, precio, descuento);
            CantidadProducto[CanProducto] = refresco;
            
        } else {System.out.println("Solo se permite el ingreso de 5 productos por cliente");}
    }
    private String Promocion500(){
        int promo = 0;
        for (int i = 0; i < CantidadProducto.length; i++) {
            if (CantidadProducto[i] != null && CantidadProducto[i].getPresentacion().equals("500 ml")) {
                promo++;
                if (promo==2) {
                    if (promo==4) {
                        return "Dos refresco de 235 ml";
                    }
                    return "un refresco de 235 ml";
                }
                
            }
            
        }
        return "No aplica";
    }


    private void PagoP() {
        System.out.println("\t---Total de productos---");
        for (int i = 0; i < CantidadProducto.length; i++) {
            if (CantidadProducto[i] != null) {
                System.out.println("-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-");
                System.out.println("-. \tProducto: " + i +": "+ CantidadProducto[i].getMarca()+"\t\t\t.-");
                System.out.println("-. \tPrecio: " + CantidadProducto[i].getPrecio()+"\t\t\t\t.-");
                System.out.println("-. \tPresentacion: " + CantidadProducto[i].getPresentacion()+"\t\t\t.-");
                System.out.println("-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-");
                    Total += CantidadProducto[i].getPrecio();
            }
        }
        System.out.println("-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-");
        System.out.println("-. \tPago total de los productos: "+Total+"\t.-");
        System.out.println("-. \tGratis: "+Promocion500()+"\t\t.-");
        System.out.println("-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-");
        TipoPago();
    }
    private void TipoPago() {
        System.out.println("Pagara con: ");
        System.out.println("1. Efectivo\n2. Tarjeta");
        op = leerop.nextInt();
        switch (op) {
            case 1:
                Efectivo();
                break;
            case 2:
                Tarjeta();
                break;
        
            default:
                break;
        }
    }
    private void Efectivo() {
        int billete;
        System.out.println("¿Con cuanto paga?");
        System.out.println("$");billete = leerop.nextInt();
        System.out.println("Su cambio: $" + (billete-Total));
        System.out.println("Le agradecemos la visita y su compra");   
    }
    private void Tarjeta() {
        String NumeroTarjeta;
        int Nip1;
        int in = 0;
        do {
            System.out.println("Ingresa en numero de tarjeta: ");
            NumeroTarjeta = leerop.nextLine();
            if (NumeroTarjeta.length() == 16) {
                System.out.println("Ingresa tu nip: ");
                Nip1 = leerop.nextInt();
                if (Nip1==Nip) {
                    System.out.println("Gracias por su compra y por su visita");
                    System.out.println("El monto de $"+Total+"se descontara de su cuenta");
                    in=4;
                    System.exit(0);
                } else {
                    System.out.println("Nip invalido, le quedan "+(2-in)+" intentos."); 
                    in=in+1;}
            }else {
                System.out.println("Numero de Tarjeta invalido (tiene que se 16 dijitos), le quedan "+(2-in)+" intentos."); 
                in=in+1;}
        } while (in  <= 2);
        if (in==3) {
            System.out.println("Numero de intentos alcanzados\n¿Desea realizar el pago en efectivo?");
            System.out.println("1. Si\n2. No");
            System.out.printf(">");op = leerop.nextInt();
            if (op==1) {
                Efectivo();
                
            } else {System.out.println("Gracias por su visita"); System.exit(0);}
        }   
    }
}
