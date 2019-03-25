package sample.Componentes;

public class Vengadores extends Thread {

    public Vengadores(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        super.run();
        try {
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
    }
}
