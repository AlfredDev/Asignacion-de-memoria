import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;
public class Os
{
    /** Objeto cola para almacenar los procesos que seran usados para la prueba*/
    static  Queue<Proceso> colaDtrabajo = new LinkedList<>();
    static int contprocess = 0;
    public static void main (String [] args ){
        System.out.printf("%48s","Memoria");
        System.out.printf("\n%70s","<----------------------------------------------->\n");
        Memoria memory;

        /**Creamos una instancia de memoria con asignacion desde teclado*/
        int memoriacap= Integer.parseInt(Jpanel("Capacidad De memoria"));
        int capSo= Integer.parseInt(Jpanel("Tamaño Del Sistema operativo"));

        if(memoriacap <= capSo) return;

        memory = new Memoria(memoriacap,capSo);
        System.out.printf("                    "+memory.toString()+"\n");

        /**Cargamos los procesos a la cola de trabajos*/
        contprocess = Integer.parseInt(Jpanel("la cantidad de procesos a agregar"));
        ProcesosTest(contprocess);

        memory.start(); 
        /** verificamos si losprocesos pueden entrar a la memoria, si pueden entrar saldra de la cola de trabajo*/
        while(! colaDtrabajo.isEmpty() ){
            if(memory.getResto() >= colaDtrabajo.peek().getCantidadMemoria() && memory.getCont() < 3)
                memory.Agrega(colaDtrabajo.remove());
        }
        System.out.printf(memory.toString());

    }

    static String Jpanel(String aux){
        return JOptionPane.showInputDialog("Introduce "+ aux);
    }

    /** 
     * Este metodo creara los procesos 
     * con los que quiera probar el usuario
     */
    public  static void ProcesosTest(int cant){
        for(int i = 1; i <= cant; i++){
            String name = Jpanel("el nombre");
            int cap = Integer.parseInt(Jpanel("la cantidad de memoria del proceso: "+i));
            int temp = Integer.parseInt(Jpanel("el tiempo"));
            colaDtrabajo.add(new Proceso(name,cap,temp));
        }
    }

}
