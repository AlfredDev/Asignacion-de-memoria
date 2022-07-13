
import java.util.LinkedList;
import java.util.Queue;
public class ProcessTets
{
    public static void main(String [] args) throws InterruptedException{

        Queue<Proceso> fifo = new LinkedList<>();
        fifo.add(new Proceso("notepad.exe",true));
        fifo.add(new Proceso("C:\\Program Files\\Internet Explorer\\iexplore.exe",true));
        fifo.add(new Proceso("D:\\Arduino\\arduino.exe",true));
        fifo.add(new Proceso("notepad.exe",false));
        fifo.add(new Proceso("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",true));
        fifo.add(new Proceso("C:\\Program Files\\Mozilla Firefox\\firefox.exe",true));

        System.out.println("Procesos nuevo recogidos");
        System.out.println("Procesos Listos");

        Memoria memoria = new Memoria(fifo);
        memoria.start();

    }
}
