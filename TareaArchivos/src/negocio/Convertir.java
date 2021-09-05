
package negocio;

import dominio.mdEmpleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisa
 */
public class Convertir {
    
    public List<mdEmpleado>  StringAObjeto(List<String> lineas){
        
        List<mdEmpleado> empleados = new ArrayList<>();
        
        //LO QUE SE HACE ES QUE SE RECORRE LA LISTA DE STRING UNA POR UNA CON EL CICLO FOR
        //CON EL MÉTODO split SEPARAMOS CADA PALABRA CUANDO SE ENCUENTRE UNA COMA Y CON CADA UNA
        //DE ESAS PALABRAS FORMAMOS EL OBEJTO EMPLEADO Y LO AÑADIMOS A LA LISTA QUE SE VA A RETORNAR
        //
        for(int i = 0; i< lineas.size(); i++){
            //System.out.println(lineas.get(i));
            String linea = lineas.get(i);
            String[] split = linea.split(",");
            mdEmpleado emp1 = new mdEmpleado(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), 0, 0);
            empleados.add(emp1);
        }
        
        return empleados;
    }
    
}
