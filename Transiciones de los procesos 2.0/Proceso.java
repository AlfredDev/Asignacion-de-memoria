
public class Proceso
{
    private int tiempo;
    private  String Nproceso;
    private boolean recurso;
    
    public Proceso(String n,boolean r){
        Nproceso=n;
        tiempo = 30;
        recurso = r;
    }


    public int gettime(){return tiempo;}

    public void Print(String adv){
        System.out.print("\nEl proceso "+Nproceso+" "+adv);
    }

    public boolean getrecurso(){return recurso;}

    public void setrecurso(boolean d){recurso = d;}

  
   

}
