
public class Proceso
{
    private int cantidadMemoria;
    private String nombre;
    private int temp;

    /**Contructor pot defecto 
     * para crear un nuevo proceso
     */
    public Proceso( String n,int c, int temp){

        cantidadMemoria = c;
        nombre = n ;
        this.temp = temp;

    }

    /** 
     * Metodo toString
     */

    @Override
    public String toString(){
        return String.format("Nombre: %-10s | Memoria asignada: %2sk | Tiempo: %-8d \n"  , nombre, cantidadMemoria, temp);
    }

    public int getTemp(){return temp;}

    /**Metodos get and setter*/
    public int getCantidadMemoria(){
        return this.cantidadMemoria;
    }

    public String getNombre(){
        return this.nombre;
    }


    public void  setTemp(int t){
        temp = temp - t;
        if(temp < 0) temp = 0;
    }

}
