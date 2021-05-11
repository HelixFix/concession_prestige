package Controller;

import View.ViewMenuPrincipal;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

    private ViewMenuPrincipal vue;
    private ViewHandler vh;

    public ControllerMenu(ViewMenuPrincipal vue, ViewHandler vh) {
        this.vh = vh;
        this.vue = vue;   }

    @Override
    public void handle(MouseEvent event) {


        if      (event.getSource().equals(vue.getButtonGestion()))         vh.afficherGenre();
        else if (event.getSource().equals(vue.getButtonGarage()))         vh.afficherNationalite();


        else if (event.getSource().equals(vue.getButtonVente()))         vh.afficherFilms();


        else if (event.getSource().equals(vue.getButtonVente()))         vh.afficherFilms();

        else if (event.getSource().equals(vue.getQuitter()))           System.exit(0);
    }
}
