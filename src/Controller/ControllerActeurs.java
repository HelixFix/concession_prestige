package Controller;

import View.Acteurs;
import View.Genre;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerActeurs implements EventHandler<MouseEvent> {

    private Acteurs vue;
    private ViewHandler vh;

    public ControllerActeurs(Acteurs vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
    }
}
