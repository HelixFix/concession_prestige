package Controller;

import View.Clients;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerClients implements EventHandler<MouseEvent> {

    private Clients vue;
    private ViewHandler vh;


    public ControllerClients(Clients vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
