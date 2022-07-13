import java.util.Queue;

public class Memoria extends Thread
{
    Queue<Proceso> cola;
    public Memoria(Queue<Proceso> c){
        cola=c;
    }
    
    @Override 
    public void run(){
        try{
            while(!cola.isEmpty()){
                Proceso process = cola.remove();
                process.Print("Esta ejecuntandose");

                if(!cola.isEmpty()){
                    cola.peek().Print("En espera");}

                carga(process.gettime());
                if(!process.getrecurso()){
                    System.out.println("\n proceso bloqueado recurso de e/s necesario ");
                    Thread.sleep(10000); 

                    process.setrecurso(true);
                    cola.add(process);
                    System.out.println("El proceso volvio en cola Listo");
                }
                else{

                    process.Ejecutar();
                    Thread.sleep(10000); 
                    process.KillRun();
                    process.Print("Terminado");}
            }
        }catch(InterruptedException e){
            System.err.print(e.getMessage());
        }
        catch(NullPointerException e){
            System.err.print(e.getMessage());
        }

        System.out.println("\n Prueba finalizada");
        System.out.println("|==================| ");

    } 

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

}
