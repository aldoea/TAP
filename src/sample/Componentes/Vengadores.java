package sample.Componentes;

import javafx.scene.control.ProgressBar;

public class Vengadores extends Thread {

    private ProgressBar pgbCarril;
    public Vengadores(String nombre, ProgressBar pgbCarril) {
        super(nombre);
        this.pgbCarril = pgbCarril;
    }

    @Override
    public void run() {
        super.run();
        /*try {
            System.out.println("Sale " + getName());
            for (int i = 1; i <= 10; i++) {
                int max = 10;
                int min = 1;
                double x = (Math.random()*((max-min)+1))+min;
                sleep((long) (x * 1000));
                System.out.println("KM " + i + " : " + getName());
            }
            System.out.println("Sí acabo el vato " + getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        pgbCarril.setProgress(0.25);
        try {
            int max = 10;
            int min = 1;
            double avance = 0;
            while(avance < 1) {
                avance += Math.random() /10;
                pgbCarril.setProgress(avance);
                double x = (Math.random()*((max-min)+1))+min;
                sleep((long) (x * 1000));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
