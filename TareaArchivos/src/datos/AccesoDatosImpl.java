
package datos;

import dominio.mdEmpleado;
import excepciones.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Luisa
 */
public class AccesoDatosImpl implements AccesoDatos {

    /*EN ESTA PARTE SE IMPLEMENTAN LOS MÉTODOS QUE SE DEFINIERON EN LA INTERFACE,
    AQUÍ ES DONDE SE LE INDICA CÓMO LO TIENE QUE HACER
    */
    
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    /**EL MÉTODO LISTAR RECIBE COMO PARÁMETRO EL NOMBRE DEL ARCHIVO EN EL QUE SE SE DESEA ACCEDER,
     */
    @Override
    public List<String> listar(String nombreArchivo) throws LecturaDatosEx {
        /** SE DECLARA UNA LISTA DE STRINGS EN LA QUE SE GUARDARÁ CADA LÍNEA QUE CONTIENE EL ARCHIVO
     * ESA LISTA ES LA QUE SE VA A DEVOLVER A QUIÉN ACCESA A ESTE MÉTODO*/
        List<String> filas = new ArrayList();
        try {
            /**SE CREA UN BUFFER A PARTIR DEL ARCHIVO*/
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);

            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                //MIENTRAS EL ARCHIVO CONTENGA LÍNEAS SE VAN GUARDANDO EL ARREGLO filas Y ESE ES EL QUE SE RETORNA
                filas.add(linea);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return filas;
    }

    
    /**
     ESTE MÉTODO RECIBE UN EMPLEADO QUE POR MEDIO DE SU MÉTODO toString() SE OBTIENE 
     * UNA SOLA CADENA PARA ALMACENARLA EN EL ARCHIVO
     **/
    @Override
    public void escribir(mdEmpleado empleado, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;

        try {
            
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            //A TRAVÉS DEL MÉTODO TO STRING QUE FUE SOBREESCRITO SE GUARDA UNA CADENA DE CARACTERES SEPARADAS POR COMAS
            salida.println(empleado.toString());
            salida.close();
            System.out.println("<<<--- Se ha escrito el registro en el archivo");

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);

            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula: " + linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}
