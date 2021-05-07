package Controller;

import View.ViewGarage;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerGarage implements EventHandler<MouseEvent> {

    private ViewGarage vue;
    private ViewHandler vh;

    public ControllerGarage(ViewGarage vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
    }
}
