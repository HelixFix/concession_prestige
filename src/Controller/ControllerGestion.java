package Controller;

import View.ViewGestion;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerGestion implements EventHandler<MouseEvent> {

    private ViewGestion vue;
    private ViewHandler vh;

    public ControllerGestion(ViewGestion vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
        if      (event.getSource().equals(vue.getButtonCrud()))         vh.afficherCrud();
    }
}
