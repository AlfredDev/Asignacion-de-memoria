
public class Proceso
{
    ProcessBuilder builder;
    Process pro;
    private int tiempo;
    private  String Nproceso;
    private boolean recurso;
    public Proceso(String n,boolean r){
        Nproceso=n;
        builder= new ProcessBuilder(Nproceso);
        tiempo = 30;
        recurso = r;
    }

    public void Ejecutar(){
        try{
            pro = builder.start();
        }catch(Exception ex){
            ex.getMessage();
        }
    }

    public int gettime(){return tiempo;}

    public void Print(String adv){
        System.out.println("\nEl proceso "+Nproceso+" "+adv);
    }
    public boolean getrecurso(){return recurso;}
    public void setrecurso(boolean d){recurso = d;}
   
    public void KillRun(){
        pro.destroy();
    }

}
