import processing.core.PApplet;
public class Floater {
    protected PApplet applet;
    protected int corners;
    protected int[] xCorners;
    protected int[] yCorners;
    protected int myColor;
    protected double myCenterX, myCenterY;
    protected double myXspeed, myYspeed;
    protected double myPointDirection;
    protected double originX, originY, oSpeedX, oSpeedY;

    public Floater(PApplet applet_){
        applet = applet_;
    }

    public void move(){
        myCenterX += myXspeed;
        myCenterY += myYspeed;

        if(myCenterX > applet.width){
            myCenterX = 0;
        }
        else if (myCenterX < 0){
            myCenterX = applet.width;
        }
        if(myCenterY > applet.height){
            myCenterY = 0;
        }
        else if (myCenterY < 0){
            myCenterY = applet.height;
        }
    }

    public void show(){
        applet.fill(myColor);
        applet.stroke(myColor);
        applet.translate((float)myCenterX, (float)myCenterY);

        applet.beginShape();
        for(int i = 0; i < corners; i++){
            applet.vertex(xCorners[i], yCorners[i]);
        }
        applet.endShape(applet.CLOSE);

        applet.translate(-1*(float)myCenterX, -1*(float)myCenterY);
    }
}

