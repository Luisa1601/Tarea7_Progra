
package datos;
import dominio.mdEmpleado;
import excepciones.*;
import java.util.*;
/**
 *
 * @author Luisa
 */
public interface AccesoDatos {
    
    /**
     SE CREA LA INTERFACE DONDE SE DEFINEN LOS MÉTODOS PRINCIPALES DE ACCESO AL ARCHIVO,
     * AQUÍ SE INDICAN LO QUE TIENE QUE HACER EL PROGRAMA RELACIONADO A LOS DATOS
     * RECORDEMOS QUE LOS DATOS VAN SEPARADOS DEL NEGOCIO
     * EL ACCESO A DATOS HACE REFERENCIA A CÓMO SE LEE Y ESCRIBE EN EL ARCHIVO
     * 
     **/
    
    //ESTE MÉTODO SERÁ USADO PARA COMPROBAR SI EL ARCHIVO YA EXISTE
    boolean existe(String nombreArchivo)throws AccesoDatosEx;
    //ESTE MÉTODO SERÁ USADO PARA LISTAR EL CONTENIDO DEL ARCHIVO
    public List<String> listar(String nombreArchivo) throws LecturaDatosEx;
    //ESTE MÉTODO SERÁ USADO PARA INSERTAR UN NUEVO DATO DE TIPO EMPLEADO EN EL ARCHIVO
    void escribir(mdEmpleado empleado,String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    public String buscar(String nombreArchivo,String buscar)throws LecturaDatosEx;
    public void crear(String nombreArchivo)throws AccesoDatosEx;
    public void borrar(String nombreArchivo)throws AccesoDatosEx;
}
