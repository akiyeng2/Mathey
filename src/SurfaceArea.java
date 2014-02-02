/**
 * This program finds the surface area for either a rectangular prism, a cylinder, or a sphere
 * 
 * Lauren Koval
 * 1-28-14
 */


public class SurfaceArea
{
 
    public static double surfaceAreaPrism(double length, double width, double height){    //this method takes the parameters of length width and height to calculate surface area of a rectangular prism
        return (2*(length*width))+(2*(width*height))+(2*(height*length));             
    }
    public static double surfaceAreaCylinder(double radius, double height){     //this method takes the parameters of radius and height to calculate surface area of a cylinder
        return (2*Math.PI*(radius*radius))+(2*Math.PI*radius*height);
    }
    public static double surfaceAreaSphere(double radius){   //this method takes the parameter radius to calculate the surface area of a sphere
        return (4*Math.PI*(radius*radius));
    }
}







