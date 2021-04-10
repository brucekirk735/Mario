package components;
import  scenes.Scene;
import jade.GameObject;
import jade.KeyListener;
import jade.MouseListener;
import jade.Window;
import util.Settings;
import static org.lwjgl.glfw.GLFW.*;

public class MouseControls extends Component {
    GameObject holdingObject = null;
    GameObject alreadyPlacedGO = null;
    Scene myscene;
    Window window;
    public void pickupObject(GameObject go) {
        this.holdingObject = go;
        Window.getScene().addGameObjectToScene(go);

    }


    public void place() {
        this.holdingObject = null;
    }

    @Override
    public void editorUpdate(float dt) {
 /*       if (holdingObject != null) {
            holdingObject.transform.position.x = MouseListener.getOrthoX();
            holdingObject.transform.position.y = MouseListener.getOrthoY();
            holdingObject.transform.position.x = (int)(holdingObject.transform.position.x / Settings.GRID_WIDTH) * Settings.GRID_WIDTH;
            holdingObject.transform.position.y = (int)(holdingObject.transform.position.y / Settings.GRID_HEIGHT) * Settings.GRID_HEIGHT;

            if (MouseListener.mouseButtonDown(GLFW_MOUSE_BUTTON_LEFT)) {
                place();
            }

  */



            if (holdingObject != null) {
                holdingObject.transform.position.x = MouseListener.getOrthoX();
                holdingObject.transform.position.y = MouseListener.getOrthoY();
                holdingObject.transform.position.x = (int)(holdingObject.transform.position.x / Settings.GRID_WIDTH) * Settings.GRID_WIDTH;
                holdingObject.transform.position.y = (int)(holdingObject.transform.position.y / Settings.GRID_HEIGHT) * Settings.GRID_HEIGHT;

                if (MouseListener.mouseButtonDown(GLFW_MOUSE_BUTTON_LEFT)) {
                    holdingObject = holdingObject.copy();
                    Window.getScene().addGameObjectToScene(holdingObject);
                }

                if (KeyListener.isKeyPressed(GLFW_KEY_ESCAPE)) {
                    holdingObject.destroy();
                    holdingObject = null;
                }
            }

        }
    }

