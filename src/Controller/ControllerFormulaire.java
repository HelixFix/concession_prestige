package Controller;

import View.Formulaire;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFormulaire implements EventHandler<MouseEvent> {

    private Formulaire vue;
    private ViewHandler vh;

    public ControllerFormulaire(Formulaire vue, ViewHandler vh) {
        this.vh = vh;
        this.vue = vue;   }

    @Override
    public void handle(MouseEvent event) {


        if      (event.getSource().equals(vue.getGenre()))         vh.afficherGenre();
        else if (event.getSource().equals(vue.getNationalite()))         vh.afficherNationalite();
        else if (event.getSource().equals(vue.getClients()))         vh.afficherClients();
        else if (event.getSource().equals(vue.getQuitter()))           System.exit(0);
    }
}
