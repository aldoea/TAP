package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class EventoTeclado  implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        System.out.println("jiji");
        System.out.println(event.getCode());
    }
}
