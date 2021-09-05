
package negocio;

import dominio.mdEmpleado;
import java.util.List;

/**
 *
 * @author Luisa
 */

/**
 AQUÍ SE DEFINE LA LÓGICA DE NEGOCIOS, ES DECIR LA FUNCIONALIDAD DEL PROGRAMA
 * POR ESO SE CREA LA INTERFAZ CON MÉTODOS RELACIONADOS A COMISIONES Y EMPLEADOS
 * AGREGAR, LISTAR, BUSCAR, ETC.
 * AQUÍ SOLO SE DEFINEN LA LÓGICA. NADA RELACIONADO A LOS DATOS
 */
public interface IComisiones {
    public void agregarComisiones(mdEmpleado empleado, String nombreArchivo);
    public List<mdEmpleado> listarComisiones(String nombreArchivo);
    public void buscarComisiones(String nombreArchivo, String buscar);
    public void iniciarArchivo(String nombreArchivo);
}
