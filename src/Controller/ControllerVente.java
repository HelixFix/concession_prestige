package Controller;

import View.ViewVente;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerVente implements EventHandler<MouseEvent> {

    private ViewVente vue;
    private ViewHandler vh;

    public ControllerVente(ViewVente vue, ViewHandler vh) {
        this.vue = vue;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(vue.getRetour())) {
            vh.afficherMenuPrincipal();
        } else if (event.getSource().equals(vue.getMois())) {
            vh.afficherTableauMois();
        } else if (event.getSource().equals(vue.getAnnee())) {
            vh.afficherTableauAnne();
        }
    }
}
