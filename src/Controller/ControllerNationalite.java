package Controller;

import View.Nationalité;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerNationalite implements EventHandler<MouseEvent> {

    private Nationalité vue;
    private ViewHandler vh;

    public ControllerNationalite(Nationalité vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
    }
}
