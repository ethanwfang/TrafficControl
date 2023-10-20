import processing.core.PApplet;
import processing.core.*;
public class Car extends Floater{
    protected int lane;
    public Car(PApplet applet_, float x, float y, int xSpeed, int ySpeed){
        super(applet_);
        myCenterX = x;
        myCenterY = y;
        myXspeed = xSpeed;
        myYspeed = ySpeed;
        corners = 4;
        myColor = 255;
        originX = x;
        originY = y;
        oSpeedX = xSpeed;
        oSpeedY = ySpeed;
        lane = getLane();
    }

    public void show(){
        applet.fill(255, 0, 0);
        applet.ellipse((float)myCenterX, (float)myCenterY, 20, 20);
    }

    public double getX(){
        return myCenterX;
    }

    public double getY(){
        return myCenterY;
    }

    public void stopAtLight(){
        if(myXspeed != 0){
            if(myCenterX < originX+2 && myCenterX > originX-2){
                stop();
            }
            else{
                go();
            }
        }
        if(myYspeed != 0){
            if(myCenterY < originY+2 && myCenterY > originY-2){
                stop();
            }
            else{
                go();
            }
        }
    }

    public void stop(){
        myXspeed = 0;
        myYspeed = 0;
    }

    public void go(){
        myXspeed = oSpeedX;
        myYspeed = oSpeedY;
    }

    public boolean inIntersection(){
        if(myCenterX < 600 && myCenterX > 400){
            if(myCenterY < 600 && myCenterY > 400){
                return true;
            }
        }
        return false;
    }

    public int getLane(){
        if(inIntersection()) return 0;
        if(lane1()) return 1;
        if(lane2()) return 2;
        if(lane3()) return 3;
        if(lane4()) return 4;
        return -1;
    }

    public boolean lane1(){
        if(myCenterX > 600 && myCenterX < 1000){
            if(myCenterY > 400 && myCenterY < 500) return true;
        }
        if(myCenterX > 0 && myCenterX < 410){
            if(myCenterY > 400 && myCenterY < 500) return true;
        }
        return false;
    }

    public boolean lane2(){
        if(myCenterX > 0 && myCenterX < 400){
            if(myCenterY > 500 && myCenterY < 600) return true;
        }
        if(myCenterX > 590 && myCenterX < 1000){ // might have to make this tighter
            if(myCenterY > 500 && myCenterY < 600) return true;
        }
        return false;
    }
    public boolean lane3(){
        if(myCenterX > 400 && myCenterX < 500){
            if(myCenterY > 0 && myCenterY < 400) return true;
        }
        if(myCenterX > 400 && myCenterX < 500){
            if(myCenterY >= 590 && myCenterY < 1000) return true;
        }
        return false;
    }

    public boolean lane4(){
        if(myCenterX > 500 && myCenterX < 600){
            if(myCenterY > 600 && myCenterY < 1000) return true;
        }
        if(myCenterX > 500 && myCenterX < 600){
            if(myCenterY <= 410 && myCenterY > 0) return true;
        }
        return false;
    }


    public void moveLeft2(){
        if (lane == 1){
            myXspeed = -1.5;
            myYspeed = 1.5;
            if(lane3()){
                lane = 3;
            }

        }
        if(lane == 2){
            myXspeed = 1.5;
            myYspeed = -1.5;
            if(lane4()){
                lane = 4;
            }
        }
        if(lane == 3){
            myXspeed = 1.5;
            myYspeed = 1.5;
            if(lane2()){
                lane = 2;
            }
        }
        if(lane == 4){
            myXspeed = -1.5;
            myYspeed = -1.5;
            if(lane1()) lane =1;
        }


    }


}
