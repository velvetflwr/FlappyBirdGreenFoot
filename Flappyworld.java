import greenfoot.*;

/**
 * Write a description of class Flappyworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappyworld extends World
{
    int pipeCounter = 0;
    int score = 0;
    int flappyCounter = 0;
    int count = 0;
    int FIRST_PIPE = 235;
    Score scoreObj = null;
    FlappyBird flap;
    boolean isPaused = true;
    public Flappyworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        //set paint order
        setPaintOrder(Score.class, GameOver.class, FlappyBird.class, Pipe.class, Pipe2.class);
        //Create FB Object
        flap = new FlappyBird();
        //creates the ground
        HalfGround ground = new HalfGround();
        HalfGround ground1 = new HalfGround();

        //Create a score object
        scoreObj = new Score(); 
        scoreObj.setScore(0);

        //add flap
        addObject(flap, 100, getHeight()/2);
        addObject(ground, 1, getHeight());
        addObject(ground1, 300, getHeight());
        // int run =1;
        addObject(scoreObj,75,25);
    }

    public void act() {
        //  scoreCounter++;

        pipeCounter++;
        count++;
        // System.out0.println(counter);
        if(count % 3==0){
            // HalfGround ground = new HalfGround();
            HalfGround ground1 = new HalfGround();
            //addObject(ground, 1, getHeight());
            addObject(ground1, 300, getHeight());
        }

        if(pipeCounter % 100 ==0){

            Pipe pipe = new Pipe();
            GreenfootImage image = pipe.getImage();
            addObject(pipe,getWidth(), getHeight()/2+ image.getHeight()-Greenfoot.getRandomNumber(105));
            Pipe2 pipe2 = new Pipe2();
            GreenfootImage image2 = pipe2.getImage();
            addObject(pipe2,getWidth(), getHeight()/2 - image2.getHeight()+ Greenfoot.getRandomNumber(105));

        }
        if( pipeCounter >= FIRST_PIPE){

            if(flappyCounter %100 == 0){
               // if(flap.getYValue()> -400){
                  // flap. displayGameOver();}
                score++;
                scoreObj.setScore(score);
            }
            flappyCounter++;

            // System.out.println(score);
        }

    }
}
