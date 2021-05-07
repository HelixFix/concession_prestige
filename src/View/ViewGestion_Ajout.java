package View;

import javafx.scene.Group;

public class ViewGestion_Ajout {
    private ViewGestion_Ajout vga;
    private final Group root;
    private ViewHandler vh;

    public ViewGestion_Ajout(ViewHandler vh, Group root) {
        this.vh = vh;
        this.root = root;
    }
}
