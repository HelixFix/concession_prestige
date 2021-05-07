package View;

import Controller.ControllerCrud;
import Controller.ControllerMenu;
import javafx.scene.Group;

public class ViewGestion_Crud {
    private final Group root;
    private final ControllerCrud controllerGestionCrud;

    public ViewGestion_Crud(Group root, ViewHandler vh) {
        this.root = root;
        this.controllerGestionCrud = new ControllerCrud(this, vh);
    }







    public void setVueCompleteCrud() {
        root.getChildren().clear();


    }
}
