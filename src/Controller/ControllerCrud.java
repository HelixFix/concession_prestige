package Controller;

import View.ViewGestion_Crud;
import View.ViewHandler;
import View.ViewMenuPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerCrud implements EventHandler<MouseEvent> {

    private ViewGestion_Crud vgc;
    private ViewHandler vh;

    public ControllerCrud(ViewGestion_Crud vgc, ViewHandler vh) {
        this.vh = vh;
        this.vgc = vgc;   }

    @Override
    public void handle(MouseEvent event) {

    }
}
