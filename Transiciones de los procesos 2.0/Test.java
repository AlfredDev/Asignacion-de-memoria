/**
 * TRANSICION DE LOS PROCESOS
 * Nuevo - Listo
 * listo - ejecucion -  bloqueado 
 * listo - ejecucion - terminado
 * 
 * @author (Alfredo garcia) 
 * @version (2.0)
 */

import java.util.LinkedList;
import java.util.Queue;
public class Test
{
    public static void main(String args []){
        System.out.printf("%60s","TRANSICION DE LOS PROCESOS");
        System.out.printf("\n%70s","|-----------------------------------------------|");
        
        Queue<Proceso> fifo = new LinkedList<>();
        Despachador scheduler = new Despachador(fifo);
        for(int i=1; i<=5; i++){
            Proceso aux = ProcesoRnd(i);
            System.out.println("\nProceso Nuevo");
            fifo.add(aux);
            System.out.println("Proceso "+i+" en cola listo");
            scheduler.run();
        }

        System.out.printf("\n%55s","SIMULACION TERMINADA");
        System.out.printf("\n%70s","|-----------------------------------------------|");

    }

    /**
     *       Método para crear un Objeto de tipo Proceso *
     * El metodo retorna un proceso aleaotio asigandoles un recurso de false o true
     * para simular el estado bloqueado, si el ramdom es 2 el proceso tendra verdadero
     * si no sera falso.
     */
    static Proceso ProcesoRnd(int i){
        int aux = (int) (Math.random() *2) +1; 
        if(aux>1) return new Proceso ("Process "+i,true);

        return new Proceso ("Process "+i,false);
    }
}
