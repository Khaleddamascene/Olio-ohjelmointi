package contorller;

import javafx.animation.AnimationTimer;

import model.PetModel;
import view.PetView;


public class PetController {

    private PetModel pet;
    private PetView petView;

    private double targetX;
    private double targetY;
    private double speed = 10.0; // Pixels per update

    private boolean moving = false;

    public PetController(PetView view) {
        this.petView = view;
        this.pet = new PetModel(200, 200);
    }

    public double getPetX() {
        return pet.getX();
    }

    public double getPetY() {
        return pet.getY();
    }

    public void setTarget(double x, double y) {
        targetX = x;
        targetY = y;
        moving = true;
        animationTimer.start();
    }

    public void stopMoving() {
        moving = false;
    }

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (moving) {
                moveTowardsTarget();
            }

        }
    };

    private void moveTowardsTarget() {
        double petX = pet.getX();
        double petY = pet.getY();

        double dx = targetX - petX;
        double dy = targetY - petY;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < speed) {
            pet.setPosition(targetX, targetY);
            moving = false;
            petView.drawPet();
            return;
        }

        double directionX = dx / distance;
        double directionY = dy / distance;

        double newX = petX + directionX * speed;
        double newY = petY + directionY * speed;

        pet.setPosition(newX, newY);

        petView.drawPet();


    }

}