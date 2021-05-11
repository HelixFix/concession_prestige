package Controller;

import View.ViewHandler;
import View.ViewTableau_Mois;
import View.ViewVente;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerTableauVenteMois implements EventHandler<MouseEvent> {
    private ViewTableau_Mois tbm;

    private ViewHandler vh;



    public ControllerTableauVenteMois(ViewTableau_Mois tbm, ViewHandler vh) {
        this.vh = vh;

        this.tbm = tbm;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(tbm.getRetour())) {
            vh.afficherMenuPrincipal();
        } else if (event.getSource().equals(tbm.getSemaine())) {
            vh.afficherVente();
        } else if (event.getSource().equals(tbm.getAnnee())) {
            vh.afficherTableauAnne();
        }
    }
}










