/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaarchivos;

import dominio.mdEmpleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import negocio.ComisionesImpl;
import negocio.Funciones;

/**
 *
 * @author Luisa
 */
public class TareaArchivos {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\17-X173\\Desktop\\Archivos\\Archivo.txt";
    private static final ComisionesImpl comisiones = new ComisionesImpl();
    private static List<mdEmpleado> empleados = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        /**
         LO PRIMERO QUE SE HACE ES ACCEDER AL ARCHIVO Y GARDARLO EN LA LISTA EMPLEADOS
         * DE ESTA FORMA YA LO TENEMOS LISTO EN UN ARREGLO PARA PODER OPERARLO A TRAVÉS DE LA CLASE FUNCIONES
         * QUE FUE LO QUE HEMOS TRABAJADO EN LAS TAREAS ANTERIORES
         * RECORDEMOS QUE EL MÉTODO listar DEVUELVE UNA LISTA DE EMPLEADOS QUE SE CONVIRTIÓ ANTERIORMENTE
         **/
        
        empleados = comisiones.listarComisiones(nombreArchivo);
        while (opcion != 0) {
            try {
                System.out.println("1. Ingresar empleado:");
                System.out.println("2. Venta maxima y venta minima:");
                System.out.println("3. Venta maxima en los 3 meses:");
                System.out.println("4. Buscar cantidad:");
                System.out.println("5. Desplegar archivo completo:");
                System.out.println("0. Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    /**
                     SI LA OPCIÓN ES 1, SE PIDE QUE SE INGRESEN DATOS, CON ESOS DATOS SE CREA UN OBJETO EMPLEADO 
                     * Y SE ENVÍA AL ARCHIVO, RECORDEMOS QUE GRACIAS Al MÉTODO toString() QUE SOBREESCRIBIMOS
                     * EL OBJETO SE ENVÍA COMO UNA CADENA SEPARADA POR COMAS
                     **/
                    
                    case 1:
                        System.out.println("Ingrese nombre del empleado: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese información de enero");
                        String enero = scanner.nextLine();
                        System.out.println("Ingrese información de febrero");
                        String febrero = scanner.nextLine();
                        System.out.println("Ingrese información de marzo");
                        String marzo = scanner.nextLine();

                        mdEmpleado emp = new mdEmpleado(nombre, Integer.parseInt(enero), Integer.parseInt(febrero), Integer.parseInt(marzo), 0, 0);
                        comisiones.agregarComisiones(emp, nombreArchivo);
                        break;
                    case 2:
                        
                        //AQUÍ ENVIAMOS LA LISTA DE EMPLEADOS QUE VIENE DEL ARCHIVO, Y EL MÉTODO ventaMaxMin DE LA
                        //CLASE Funciones SE ENCARGA DE PROCESAR LOS DATOS Y HACER LOS CÁLCULOS NECESARIOS PARA ESTE CASO
                        //ESTO YA SE HIZO EN LAS CLASES ANTERIORES
                        Funciones.ventaMaxMin(empleados);
                        break;

                    case 3:
                        Funciones.ventaMaxima3Meses(empleados);
                        break;
 
                    case 4:
                        Funciones.busqueda(empleados);
                        break;
                    case 5:
                        Funciones.imprimirCompleto(empleados);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
}
