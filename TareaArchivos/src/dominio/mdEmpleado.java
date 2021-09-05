
package dominio;

/**
 *
 * @author Luisa
 */
public class mdEmpleado {
    String nom;
    double enero;
    double febrero;
    double marzo;
    double prom;
    double total;

    public double getPromedio() {
        return prom;
    }

    public void setPromedio(double promedio) {
        this.prom = promedio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombre() {
        return nom;
    }

    public void setNombre(String nombre) {
        this.nom = nombre;
    }

    public double getEnero() {
        return enero;
    }

    public void setEnero(double enero) {
        this.enero = enero;
    }

    public double getFebrero() {
        return febrero;
    }

    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    public double getMarzo() {
        return marzo;
    }

    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }

    public mdEmpleado(String nombre, double enero, double febrero, double marzo, double promedio, double total) {
        this.nom = nombre;
        this.enero = enero;
        this.febrero = febrero;
        this.marzo = marzo;
        this.prom = promedio;
        this.total = total;
    }
  

    public void setMes(int mes, double valor) {

        switch (mes) {
            case 1:
                setEnero(valor);
                break;
            case 2:
                setFebrero(valor);

                break;
            case 3:
                setMarzo(valor);

                break;

            default:
                System.out.println("Por favor, ingrese el numero correcto de las opciones");
        }

    }
    
    @Override
    public String toString(){
        //SOBREESCRIBIMOS EL MÉTODO toString() PARA GUARDAR CADA PROPIEDAD SEPARADA POR COMA
        //ESO NOS SERVIRÁ PARA POSTERIOR PODER ACCEDER A LOS DATOS MÁS FÁCIL
        return this.getNombre() + "," + this.getEnero() + "," + this.getFebrero()+ "," + this.getMarzo();
    }
}
