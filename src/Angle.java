/**
 * This program finds the final angle of a shape with a keyboard entered number of sides.
 * 
 * @author Devin Williams
 * @version 1
 */
import java.util.*;
public class Angle
{
    // instance variables - replace the example below with your own
    private int sides;
    private int angles;
    private int lastAngle;
    
    /**
     * Default Constructor for objects of class Angle
     */
    public Angle()
    {
        // initialise instance variables
        sides = 0;
        angles = 0;
        lastAngle = 0;
    }
    public Angle(int s)
    {
        // initialise instance variables
        sides = s;
        getAngle(sides);
    }

    /****************************** Accessors (getters) ******************************/
    
    public int getAngle(int sides)
    {
        Scanner key = new Scanner(System.in);
        int angle = 0;
        int totalAngle = (sides-2)*180;
        for(int count=sides;count>1;count--)
        {
            System.out.print("Enter an angle: ");
            angles = key.nextInt(); 
            angle +=angles;
            if(angles>=180 || angles<=0)
            {
                System.out.println("Angle entered is not valid");
                System.exit(0);
            }
        }
        lastAngle = totalAngle - angle;
        if(lastAngle>=180 || lastAngle<=0)
        {
            System.out.println("Angles entered are not valid");
            System.exit(0);
        }
        return lastAngle;
    }
    /****************************** Mutators (setters) ******************************/
    public String toString()
    {
        String str = "The final angle in this shape is: ";
        str += "\n\t "+lastAngle+" degrees\n";
        return str;
    }
}
