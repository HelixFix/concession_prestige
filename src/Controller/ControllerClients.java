package Controller;

import View.ViewClients;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerClients implements EventHandler<MouseEvent> {

    private ViewClients vue;
    private ViewHandler vh;


    public ControllerClients(ViewClients vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();

    }
}
