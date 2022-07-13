import java.util.Queue;
import javax.swing.JOptionPane;

public class Despachador 
{
    Queue<Proceso> cola;

    /** Contructor de la clase*/
    public Despachador (Queue<Proceso> c){
        cola=c;
    }

    public void run(){
        try{
            while (!cola.isEmpty()){
                // obtenemos el primer objeto de la lista 
                Proceso procesoX = cola.remove();
                procesoX.Print("Ejecutando");

                if(!cola.isEmpty()){
                    cola.peek().Print("En Cola Listo");}

                System.out.println();
                carga(procesoX.gettime());  
                // si el recurso es falso ocurrira un bloqueo de E/S
                if(!procesoX.getrecurso()){
                    procesoX.Print("Bloqueado recurso de E/S necesario");
                    procesoX.Print("Espera\nListo");

                    // Establecemos el recurso en verdadero para que pueda ser ejecutado
                    while(!procesoX.getrecurso()){
                        System.out.print("\nEsperando Recurso....");
                        Thread.sleep(4000); 
                        // hasta que se introduzca una cadena
                        if(Jpanel() == true){
                            procesoX.setrecurso(true);
                            procesoX.Print("Ejecutando");
                            Thread.sleep(3000); 
                            procesoX.Print("Terminado");
                            System.out.println();
                        }
                    }
                }
                else{
                    Thread.sleep(1000); 
                    procesoX.Print("Terminado");
                    System.out.println();
                }

            }

        }catch(InterruptedException e){
            System.err.print(e.getMessage());
        }
        catch(NullPointerException e){
            System.err.print(e.getMessage());
        }
    }

    /** Este metodo simulara de manera animada una 
     * pequeña barra de carga, a un cierto ritmo
     */
    public void carga(int max){
        char[] animacion = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= max; i++) {
            System.out.print(animacion[i % 4] );

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean Jpanel(){
        String str = JOptionPane.showInputDialog("Introduce una frase");
        if(str != null) return true;
        return false;
    }

}
