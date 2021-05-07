package Controller;

import View.PagePasEncoreUtilisé;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerRealisateur implements EventHandler<MouseEvent> {

    private PagePasEncoreUtilisé vue;
    private ViewHandler vh;

    public ControllerRealisateur(PagePasEncoreUtilisé vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vue.getRetour()))          vh.afficherMenuPrincipal();
    }
}
