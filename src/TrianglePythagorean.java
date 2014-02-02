
/**
 * Program: Pythagorean Theorem
 * @version: 1.0
 * @author: Jordan Cho
 * Date Written: February 1, 2014
 * Compiler/Platform: Java 7, Windows 7
 * 
 * Description: This program takes user input and uses the pythagorean theorem to solve for a missing side.
 * 
 * What I Learned: Using classes and methods
 * 
 * Difficulties: None
 */
public class TrianglePythagorean
{
    private double side1; //Hypotenuse
    private double side2; //Side A
    private double side3; //Side B
    /**
     * Default Constructors
     */
    public TrianglePythagorean()
    {
        side1 = 0;
        side2 = 0;
        side3 = 0;
    }
    
    /**
     * Normal Constructors
     */
    public TrianglePythagorean(double s1, double s2, double s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Accessors(Getters)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public double getSide1()
    {
        return side1;
    }
    public double getSide2()
    {
        return side2;
    }
    public double getSide3()
    {
        return side3;
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Mutators(Setters)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void setSide1(int s1)
    {
        side1 = s1;
    }
    public void setSide2(int s2)
    {
        side2 = s2;
    }
    public void setSide3(int s3)
    {
        side3 = s3;
    }
    
    /**
     * Uses Pythagorean Theorem to find an unknown triangle side
     * Pre :    One side must be undefined
     * Post :   Unknows Side Length Printed
     */
    public void pythagorean()
    {
        if(side1 == 0) //If Hypotenuse is the undefined side
        {
            side1 = Math.pow(side2, 2) + Math.pow(side3, 2);
            side1 = Math.sqrt(side1);
            
         //   return side1;
            System.out.println("The unknown side is...\t" + side1);
        }
        else if(side2 == 0) //If Side A is the undefined side
        {
            side2 = Math.pow(side1, 2) - Math.pow(side3, 2);
            side2 = Math.sqrt(side2);
            
       //     return side2;
            System.out.println("The unknown side is...\t" + side2);
        }
        else if(side3 == 0) //If Side B is the undefined side ---HYPOTENUSE---
        {
            side3 = Math.pow(side1, 2) - Math.pow(side2, 2);
            side3 = Math.sqrt(side3);
            
          //  return side3;
            System.out.println("The unknown side is...\t" + side3);
        }
    }
}
