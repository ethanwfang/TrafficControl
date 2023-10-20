import processing.core.PApplet;
public class Ped extends Floater{
    public Ped(PApplet applet_, float x, float y, int xSpeed, int ySpeed){
        super(applet_);
        myCenterX = x;
        myCenterY = y;
        myXspeed = xSpeed;
        myYspeed = ySpeed;
        originX = x;
        originY = y;
    }

    public void show(){
        applet.fill(0, 255, 0);
        applet.ellipse((float)myCenterX, (float)myCenterY, 15, 15);
    }

    public void stopAtLight(){
        if(myXspeed != 0){
            if(myCenterX < originX+2 && myCenterX > originX-2){
                stop();
            }
            else{
                move();
            }
        }
        if(myYspeed != 0){
            if(myCenterY < originY+2 && myCenterY > originY-2){
                stop();
            }
            else{
                move();
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
}
