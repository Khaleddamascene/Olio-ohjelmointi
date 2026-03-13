package view;

import contorller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PetView extends Application  {
    private Canvas canvas;
    private GraphicsContext gc;
    private PetController petController;
    private Image petImage;

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 600;

    @Override
    public void init() {
        petController = new PetController(this);
    }

    @Override
    public void start(Stage stage){
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        try {
            petImage = new Image(getClass().getResourceAsStream("/kitten.jpg"));
        } catch (Exception e) {
            System.out.println("image file not found, continuing with defaults.");
        }

        canvas.setOnMouseMoved(mouseEvent -> {
            petController.setTarget(mouseEvent.getX(), mouseEvent.getY());
        });

        canvas.setOnMouseExited(MouseEvent -> {
            petController.stopMoving();
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        stage.setScene(scene);
        stage.setTitle("Virtual Pet");
        stage.show();

        drawPet();
    }
    public void drawPet(){
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        gc.drawImage(petImage, petController.getPetX(), petController.getPetY(), 120,120);
    }
}