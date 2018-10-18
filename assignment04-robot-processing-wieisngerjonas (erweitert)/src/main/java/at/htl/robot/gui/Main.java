package at.htl.robot.gui;

import at.htl.robot.model.Direction;
import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {
    Robot robot;
    int boxCenterX;
    int boxCenterY;
    int leftMargin = 20;
    int upperMargin = 50;
    int boxlength = 50;
    int xaa, xab, yaa, yab = 0;
    int xba, xbb, yba, ybb = 0;
    boolean gamemode = false;
    int leftMarginDiv = 50;

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
        frameRate(25);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */


    public void draw() {
        strokeWeight(2);
        deleteAll();

        textSize((int) (upperMargin * 0.5));
        fill(0);
        text("<F> Forwards, <L> Left", 10, 30);

        fill(255);
        for (int i = 0; i < 11; i++) {
            line(leftMargin, upperMargin + i * boxlength, leftMargin + 10 * boxlength, upperMargin + i * boxlength);
            line(leftMargin + i * boxlength, upperMargin, leftMargin + i * boxlength, upperMargin + 10 * boxlength);
        }

        if(gamemode) {
            boxCenterX = (leftMargin + robot.getX() * boxlength - boxlength / 2) - (500 * xaa) + (500 * xab);
            boxCenterY = (upperMargin + robot.getY() * boxlength - boxlength / 2) - (500 * yaa) + (500 * yab);

            if (boxCenterX == 545) {
                xaa++;
            } else if (boxCenterY == 575) {
                yaa++;
            } else if (boxCenterX == -5) {
                xab++;
            } else if (boxCenterY == 25) {
                yab++;
            }

            xba = 0;
            xbb = 0;
            yba = 0;
            ybb = 0;

        }else{
            boxCenterX = (leftMargin + robot.getX() * boxlength - boxlength / 2) - (boxlength * xba) + (boxlength * xbb);
            boxCenterY = (upperMargin + robot.getY() * boxlength - boxlength / 2) - (boxlength * yba) + (boxlength * ybb);

            if (boxCenterX == 545) {
                xba++;
            } else if (boxCenterY == 575) {
                yba++;
            } else if (boxCenterX == -5) {
                xbb++;
            } else if (boxCenterY == 25) {
                ybb++;
            }

            xaa = 0;
            xab = 0;
            yaa = 0;
            yab = 0;
        }
        System.out.println(boxCenterX + " | " + boxCenterY);

        ellipse(boxCenterX, boxCenterY, (int)(boxlength * 0.8),(int)(boxlength * 0.8));
        fill(0, 102, 153);


        if(robot.getDirection() == Direction.NORTH){
            textSize((int) ((boxlength * 0.8) * 0.5));
            text("N", (int)boxCenterX - (boxlength/8), boxCenterY);
        }else if(robot.getDirection() == Direction.EAST) {
            textSize((int) ((boxlength * 0.8) * 0.5));
            text("E", boxCenterX + (boxlength/8), boxCenterY + (boxlength/8));
        }else if(robot.getDirection() == Direction.SOUTH){
            textSize((int) ((boxlength * 0.8) * 0.5));
            text("S", (int)boxCenterX - (boxlength/8), (int)boxCenterY + (boxlength/3));
        }else if(robot.getDirection() == Direction.WEST){
            textSize((int) ((boxlength * 0.8) * 0.5));
            text("W", (int)boxCenterX - (boxlength/3), (int)boxCenterY + (boxlength/5));
        }

        if(     mouseX >= boxlength*10 + leftMargin + leftMarginDiv &&
                mouseX <= boxlength*10 + leftMargin + leftMarginDiv +180 &&
                mouseY >= upperMargin &&
                mouseY <= upperMargin + 100){

            fill(0, 84, 153);
        }else{
            fill(0, 102, 153);
        }

        rect(boxlength*10 + leftMargin + leftMarginDiv, upperMargin, 180, 100);

        textSize(25);
        fill(255);
        text("change mod", boxlength*10 + leftMargin + leftMarginDiv + 13, upperMargin + 60);

        if(     mouseX >= boxlength*10 + leftMargin + leftMarginDiv &&
                mouseX <= boxlength*10 + leftMargin + leftMarginDiv +180 &&
                mouseY >= upperMargin &&
                mouseY <= upperMargin + 100 &&
                mousePressed){

            if(gamemode){
                gamemode = false;
            }else{
                gamemode = true;
            }

        }

        textSize(25);
        fill(0);
        text("current mode: ", boxlength*10 + leftMargin + leftMarginDiv + 13, upperMargin + 130);

        if(gamemode){
            text("TELEPORTATION", boxlength*10 + leftMargin + leftMarginDiv + 13, upperMargin + 160);
        }else{
            text("PRISON", boxlength*10 + leftMargin + leftMarginDiv + 13, upperMargin + 160);
        }
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
