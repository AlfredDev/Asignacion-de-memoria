
import java.util.Vector;

public class Memoria extends Thread
{
    private Vector <Proceso> cola;
    private int capacidadMemoria;
    private int restante;
    private int capSo;
    private int cont;
    /**
     * Contructor pot defecto 
     */

    public Memoria(int capacity , int So){
        cola =  new Vector<>();
        capacidadMemoria = capacity;
        capSo = So;
        restante = capacidadMemoria - capSo;
        cont = 0;
    }

    @Override
    public void run(){
        try{
            while(! cola.isEmpty()){
                System.out.println("Los procesos en memoria:");
                System.out.printf(toString());
                ImprimeCola();
                System.out.println();

                /**Buscamos el proceso de menor tiempo */

                Proceso menorTemp = cola.get(0);
                int i =0;

                for(Proceso it: cola){
                    if(cola.get(i).getTemp() < menorTemp.getTemp()){
                        menorTemp = cola.get(i);
                    }
                    i++;
                }
                /**-------------------------------------------------------------------------*/

                /**
                 * Restamos el tiempo del proceso anterior 
                 * osea el de menor tiempo a todos los procesos
                 * dentro de la memoria
                 */
                int aux = menorTemp.getTemp();
                int x = 0;
                for(Proceso it: cola){
                    if(x < 3)  it.setTemp(aux);
                    x++;
                }

                System.out.println("---------------------------------------------------------");
                // este metodo saca el proceso de menor tiempo
                SacarProceso(menorTemp);
                System.out.println();

                if(cola.isEmpty())System.out.printf(toString());
            }
        } catch(Exception e ){
            System.err.print(e.getCause());
        }
    }

    public void ImprimeCola(){
        for(Proceso it: cola){
            System.out.print(it);
        }
    }
    // agregar proceso si hay espacio disponible
    public void Agrega(Proceso aux){
        cola.add(aux);  
        restante = restante - aux.getCantidadMemoria();
        cont++;
    }

    /** Saca el proceso y regresa capacidad a la memoria */
    public void SacarProceso(Proceso x){
        restante = restante + x.getCantidadMemoria();
        cola.remove(x);
        System.out.print("Salio: "+ x.toString());
        cont --;
    }

    public int getCont(){return cont;}

    @Override
    public String toString(){
        return String.format("[ Capacidad: %2sk | So: %2sk | Restante: %2sk ]\n",capacidadMemoria,capSo,restante);
    }

    public int getResto(){return  restante;}
}
