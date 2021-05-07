package View;

import Controller.ControllerAjout;
import Tools.Path;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class ViewGestion_Ajout {
    private ViewGestion_Ajout vga;
    private final Group root;
    private ViewHandler vh;
    private ControllerAjout controllerAjout;
    private ImageView background;

    public ViewGestion_Ajout(Group root, ViewHandler vh) {
        this.root = root;
        this.controllerAjout = new ControllerAjout(this, vh);

        initBackground();
    }

    private void initBackground() {
        background = new ImageView(Path.fondMenu);

    }
    public void setVueCompletAjout() {
        root.getChildren().clear();
        root.getChildren().add(background);

    }


}
