package sample.Componentes;

public class RecursoCompartido {
    private int pos = 0;
    int[] recurso = new int[5];
    boolean stopThread = false;

    public synchronized void llenarRecurso(int valor){
        try {
            if( stopThread == true ) {
                System.out.println("Productor se Detiene");
                wait();
                System.out.println("Productor se Reinicia");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recurso[pos] = valor;
        pos++;
        if( pos == recurso.length ){
            pos--;
            notify(); // Notifica y libera el recurso
            stopThread = true;
        }
    }

    public synchronized void vaciarRecurso(){
        try {
            if (stopThread == false) {
                System.out.println("Consumidor se Detiene");
                wait();
                System.out.println("Consumidor se Reinicia");
            }
        }
        catch (InterruptedException ie){}

        int valor = recurso[pos];
        System.out.println("Recurso["+pos+"] = "+valor);
        pos--;
        if( pos < 0 ){
            pos++;
            notify();
            stopThread = false;
        }
    }
}
