import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet{
    PImage backgroundImage;

    private ArrayList<Car> group1;
    private ArrayList<Car> group2;
    private ArrayList<Car> group3;
    private ArrayList<Car> group4;
    private ArrayList<Ped> people1;
    private ArrayList<Ped> people2;
    private boolean movement;
    private boolean stopLight;
    private boolean state1;
    private boolean state2;
    private boolean state3;
    private boolean state4;

    public void settings(){
        size(1000, 1000);
        group1 = new ArrayList<>();
        group2 = new ArrayList<>();
        group3 = new ArrayList<>();
        group4 = new ArrayList<>();
        movement = false;
        stopLight = false;
        people1 = new ArrayList<>();
        people2 = new ArrayList<>();
    }



    public void executeCurrentState() {
        if (state1) {
            for(Ped p: people1){
                if(stopLight) p.stopAtLight();
                p.show();
                p.move();
            }
            for (Car c : group1) {
                if(stopLight) c.stopAtLight();
                c.show();
                c.move();
            }
            for (Car c : group2) {
                if(stopLight) c.stopAtLight();
                c.show();
                c.move();
            }
        }

        else if (state2) {
            for (Car c : group2) {
                c.move();
                if (c.lane == 2) {
                    if (c.inIntersection() && c.lane != 4) {
                        c.moveLeft2();
                    }
                }
                if (c.lane == 4) {
                    c.myXspeed = 0;
                    c.myYspeed = -2;
                    c.oSpeedX = 0;
                    c.oSpeedY = -2;
                    c.originX = 550;
                    c.originY = 700;
                    group4.add(c);
                    break;
                }
                c.show();
            }

            for (Car c : group1) {
                c.move();
                if (c.lane == 1) {
                    if (c.inIntersection() && c.lane != 3) {
                        c.moveLeft2();
                    }
                }
                if (c.lane == 3) {
                    c.myXspeed = 0;
                    c.myYspeed = 2;
                    c.oSpeedX = 0;
                    c.oSpeedY = 2;
                    c.originX = 450;
                    c.originY = 300;
                    group3.add(c);
                    break;
                }
                c.show();
            }

            for (Car c : group3) {
                c.show();
                c.stopAtLight();
            }
            for (Car c : group4) {
                c.show();
                c.stopAtLight();
            }


        }

        else if (state3) {
            for(Ped p: people2){
                if(stopLight) p.stopAtLight();
                p.show();
                p.move();
            }
            for (Car c : group3) {
                c.myXspeed = 0;
                c.myYspeed = 2;
                c.move();
                c.show();
            }
            for (Car c : group4) {
                c.myXspeed = 0;
                c.myYspeed = -2;
                c.move();
                c.show();
            }
        }

        else if (state4) {
            for (Car c : group3) {
                c.move();
                if (c.lane == 3) {
                    if (c.inIntersection() && c.lane != 2) {
                        c.moveLeft2();
                    }
                }
                if (c.lane == 2) {
                    c.myXspeed = 2;
                    c.myYspeed = 0;
                    c.oSpeedX = 2;
                    c.oSpeedY = 0;
                    c.originX = 300;
                    c.originY = 550;
                    group2.add(c);
                    //remove3.add(c);
                    break;
                }
                c.show();
            }

            for (Car c : group4) {
                c.move();
                if (c.lane == 4) {
                    if (c.inIntersection() && c.lane != 1) {
                        c.moveLeft2();
                    }
                }
                if (c.lane == 1) {
                    c.myXspeed = -2;
                    c.myYspeed = 0;
                    c.oSpeedX = -2;
                    c.oSpeedY = 0;
                    c.originX = 700;
                    c.originY = 450;
                    group1.add(c);
                    //remove4.add(c);
                    break;
                }
                c.show();
            }
            for (Car c : group1) {
                c.show();
                c.stopAtLight();
            }
            for (Car c : group2) {
                c.show();
                c.stopAtLight();
            }
        }
    }


    public void setRoad(){
        background(220);
        fill(100, 100, 100);
        noStroke();
        rect(400, 0, 200, ((float) height /2)-100);
        rect(0, 400, (width/2)-100, 200);
        rect(400, ((float) height /2)+100, 200, ((float) height /2)-100);
        rect((width/2)+100, 400, (width/2)-100, 200);
        rect(400, 400, 200, 200);

        stroke(255);
        strokeWeight(5);

        for(int x = 0; x < width; x += 100){
            line(x, height/2, x+50, height/2);
        }
        for(int y = 0; y < height; y+=100){
            line(width/2, y, width/2, y+50);
        }

        rect(400, 400, 200, 200);
        fill(255, 255, 0);
        stroke(255, 255, 0);

        for(int i = 420; i < 600; i += 40){
            rect(350, i, 40, 8);
        }

        for(int i = 420; i < 600; i += 40){
            rect(610, i, 40, 8);
        }

        for(int i = 420; i < 600; i += 40){
            rect(i, 350, 8, 40);
        }

        for(int i = 420; i < 600; i += 40){
            rect(i, 610, 8, 40);
        }
    }

    void fullReset(){
        group1 = new ArrayList<>();
        group2 = new ArrayList<>();
        group3 = new ArrayList<>();
        group4 = new ArrayList<>();
        movement = false;
        stopLight = false;
        people1 = new ArrayList<>();
        people2 = new ArrayList<>();
        group1.add(new Car(this, 700, 450, -2, 0));
        group2.add(new Car(this, 300, 550, 2, 0));
        group3.add(new Car(this, 450, 300, 0, 2));
        group4.add(new Car(this, 550, 700, 0, -2));
        people1.add(new Ped(this, 370, 370, 2, 0));
        people1.add(new Ped(this, 370, 630, 2, 0));
        people2.add(new Ped(this, 370, 370, 0, 2));
        stopLight = false;
    }

    public void setup(){
        fullReset();
    }

    public void draw(){

        setRoad();

        noStroke();
        executeCurrentState();

        if (keyPressed) {
            if (keyCode == RIGHT) {
                stopLight = true;
            }
            if (keyCode == LEFT){
                fullReset();
                state1 = false;
                state2 =false;
                state3 = false;
                state4 = false;
            }
            else if (key == '1') {
                state1 = true;
            } else if (key == '2') {
                state2 = true;
            } else if (key == '3') {
                state3 = true;
            } else if (key == '4') {
                state4 = true;
            }
        }

    }

    public static void main(String[] args){
        PApplet.main("Main");
    }
}