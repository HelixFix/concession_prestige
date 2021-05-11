package Controller;

import View.ViewGestion_Ajout;
import View.ViewHandler;
import View.ViewMenuPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerAjout implements EventHandler<MouseEvent> {

    private ViewGestion_Ajout vga;
    private ViewHandler vh;

    public ControllerAjout(ViewGestion_Ajout vga, ViewHandler vh) {
        this.vh = vh;
        this.vga = vga;
    }

    @Override
    public void handle(MouseEvent event) {
        if      (event.getSource().equals(vga.getRetour()))          vh.afficherGestion();

    }
}
