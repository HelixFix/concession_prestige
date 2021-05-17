package Controller;

import View.ViewTableau_Jour;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerTableauJour implements EventHandler<MouseEvent> {

    private ViewTableau_Jour tbj;
    private ViewHandler vh;

    public ControllerTableauJour(ViewTableau_Jour tbj, ViewHandler vh) {
        this.tbj = tbj;
        this.vh = vh;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(tbj.getRetour())) {
            vh.afficherMenuPrincipal();
        } else if (event.getSource().equals(tbj.getAnnee())) {
            vh.afficherTableauAnne();
        } else if (event.getSource().equals(tbj.getMois())) {
            vh.afficherTableauMois();}
    }
}
