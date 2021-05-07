package Controller;

import View.ViewClient;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerClient implements EventHandler<MouseEvent> {

    private ViewClient vue;
    private ViewHandler vh;

    public ControllerClient(ViewClient vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
    }
}
