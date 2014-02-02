/**
 * This program finds the Roots of a quadratic equation.
 * 
 * @author Devin Williams
 * @version 1
 */
public class Roots
{
    // instance variables - replace the example below with your own
    private double equation;
    private double aValue;
    private double bValue;
    private double cValue;
    private double root1;
    private double root2;

    /**
     * Default Constructor for objects of class Book
     */
    public Roots()
    {
        // initialise instance variables
        aValue = 0;
        bValue = 0;
        cValue = 0;
    }
    public Roots(int a, int b, int c)
    {
        // initialise instance variables
        aValue = a;
        bValue = b;
        cValue = c;
        getRoot(aValue,bValue,cValue);
    }

    /****************************** Accessors (getters) ******************************/
    
    public double getRoot(double aValue, double bValue, double cValue)
    {
        equation = (bValue*bValue) - (4 * aValue * cValue);
        root1 = ((-bValue) + Math.sqrt(equation)) / (2 * aValue);
        root2 = ((-bValue) - Math.sqrt(equation)) / (2 * aValue);
        return root1;
    }
    /****************************** Mutators (setters) ******************************/
    public String toString()
    {
        String str = "The roots of this equation are: ";
        str += "\n\t "+root1;
        str += "\n\t "+root2;
        return str;
    }
}
