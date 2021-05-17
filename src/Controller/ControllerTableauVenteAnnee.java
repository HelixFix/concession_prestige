package Controller;

import View.ViewHandler;
import View.ViewTableau_Annee;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerTableauVenteAnnee implements EventHandler<MouseEvent> {

    private ViewTableau_Annee tba;

    private ViewHandler vh;
    public ControllerTableauVenteAnnee(ViewTableau_Annee tba, ViewHandler vh) {
        this.vh = vh;
        this.tba = tba;



    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(tba.getRetour())) {
            vh.afficherMenuPrincipal();
        } else if (event.getSource().equals(tba.getJour())) {
            vh.afficherTableauJour();
        } else if (event.getSource().equals(tba.getMois())) {
            vh.afficherTableauMois();}

    }
}
