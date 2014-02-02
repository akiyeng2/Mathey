/**
 * This program finds the volume for either a rectangular prism, a cylinder, or a sphere
 * 
 * Lauren Koval
 * 1-28-14
*/

public class Volume
{
    public static void main (String[] args){          
        //The main menu allows the user to pick an option of a rectangular prism, a cylinder, or a sphere and was the test code for my methods
//         Scanner kb =new Scanner (System.in);
//          System.out.println("1. Rectangular Prism");
//          System.out.println("2. Cylinder");
//          System.out.println("3. Sphere");
//          System.out.print("Enter a number 1-3: ");
//          int choice= kb.nextInt();   
//          if(choice==1){        //This allows the user to enter the dimmensions of a rectangular prism then calls the method that calculate the volume for a rectangular prism
//              System.out.print("Enter length: ");
//              double length= kb.nextDouble();
//              System.out.print("Enter width: ");
//              double width= kb.nextDouble();
//              System.out.print("Enter height: ");
//              double height= kb.nextDouble();
//              System.out.println("The volume is: " +volumePrism(length, width, height));
//          }
//          else if(choice==2){     //This allows the user to enter the dimmensons of a cylinder then calls the  method the calculates the volume of a cylinder
//              System.out.print("Enter height: ");
//              double height= kb.nextDouble();
//              System.out.print("Enter radius: ");
//              double radius= kb.nextDouble();
//              System.out.println("The volume is: " +volumeCylinder(radius, height));
//          }
//          else{     //This allows the user to enter the radius of a sphere then calls the  method the calculates the volume of the sphere
//              System.out.print("Enter radius: ");
//              double radius= kb.nextDouble();
//              System.out.println("The volume is: " +volumeSphere(radius));
//          }
     }
    public static double volumePrism(double length, double width, double height){    //this method takes the parameters of length width and height to calculate volume of a rectangular prism
        return (length*width*height);          
    }
    public static double volumeCylinder(double radius, double height){   //this method takes the parameters of radius and height to calculate volume of a cylinder
        return ((Math.PI*(radius*radius))*height);
    }
    public static double volumeSphere(double radius){   //this method takes the parameter radius to calculate the volume of a sphere
        return ((4*Math.PI*(radius*radius*radius))/3);
    }
}
