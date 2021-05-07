package Controller;

import View.Genre;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerGenre implements EventHandler<MouseEvent> {

    private Genre vue;
    private ViewHandler vh;

    public ControllerGenre(Genre vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
    }
}
