import controller.Controller;
import gui.GUI;

public class Launcher {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Controller controller = new Controller();
        controller.setGui(gui);
        gui.setController(controller);
    }
}
