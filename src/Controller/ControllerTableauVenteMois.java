package Controller;

import View.ViewHandler;
import View.ViewTableau_Mois;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerTableauVenteMois implements EventHandler<MouseEvent>  {

    private ViewHandler vh;
    private ViewTableau_Mois tbm;



    public ControllerTableauVenteMois(ViewTableau_Mois tbm, ViewHandler vh) {
        this.vh = vh;
        this.tbm = tbm;
    }

    public void handle(MouseEvent event) {
        if (event.getSource().equals(tbm.getRetour())) {
            vh.afficherMenuPrincipal();
        } else if (event.getSource().equals(tbm.getAnnee())) {
            vh.afficherTableauAnne();
        } else if (event.getSource().equals(tbm.getSemaine())) {
            vh.afficherTableauJour();}
    }
}
