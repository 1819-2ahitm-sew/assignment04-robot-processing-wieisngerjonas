package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {
    Robot robot;
    int leftMargin = 20;
    int upperMargin = 50;
    int boxlength = 50;

    // Hier die Member-Attribute eintragen

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        robot = new Robot();
        robot.setX(1);
        robot.setY(1);

    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */


    public void draw() {
        strokeWeight(2);
        deleteAll();

        textSize((int)(upperMargin * 0.5));

        text("<F> Forwards, <L> Left", 10, 30);
        for (int i = 0; i < 11; i++) {
            line(leftMargin , upperMargin + i * boxlength,  leftMargin +  10 * boxlength, upperMargin + i * boxlength);
            line(leftMargin + i * boxlength, upperMargin, leftMargin + i * boxlength,upperMargin + 10 * boxlength);
        }
        int boxCenterX = leftMargin + robot.getX() * boxlength - boxlength / 2;
        int boxCenterY = upperMargin + robot.getY() * boxlength - boxlength / 2;

        ellipse(boxCenterX, boxCenterY, (int)(boxlength * 0.8),(int)(boxlength * 0.8));


    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(232);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            robot.stepForward();
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }
    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
