package View;

import Controller.ControllerClients;
import javafx.scene.Group;

public class Clients {

    private final Group root;
    private final ControllerClients controllerClients;

    public Clients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initButtons();
        

    }

    private void initButtons() {
    }

    public void setVueClients() {
        root.getChildren().clear();
    }

}
