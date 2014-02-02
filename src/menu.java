import java.util.Scanner;
import java.util.ArrayList;
/**
 * This is the driver program for our Mathey project
 * 
 * @author Mathey Group 5
 * @version 1.0
 * 
 *
 */
public class menu {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int option=0;
		do{
			System.out.println("Options: ");
			System.out.println("\t1. Switch Bases");	
			System.out.println("\t2. Sort numbers");
			System.out.println("\t3. Surface Area");
			System.out.println("\t4. Volume");
			System.out.println("\t5. Angles of Polygons");
			System.out.println("\t6. Roots");
			System.out.println("\t7. Prime Numbers");
			System.out.println("\t8. Pythagorean Theorem");
			System.out.println("\tAny other number. Quit");
			System.out.print("Select an Option: ");
			option=scan.nextInt();
			switch(option){
				case 1:
					baseChange base=new baseChange();
					System.out.println("Options: ");
					System.out.println("\t1. Convert to and from bases");
					System.out.println("\t2. Convert text to different bases");
					System.out.print("Select an Option: ");
					int baseOption=scan.nextInt();
					if(baseOption>2 || baseOption<1){
						System.out.println("Enter a valid option");
						break;
					}
					if(baseOption==1){
						System.out.print("Enter number: ");
						String num=scan.next();
						System.out.print("Enter current base: ");
						int from=scan.nextInt();
						System.out.print("Enter base you want to convert to: ");
						int to=scan.nextInt();
						System.out.println(num+" in base "+from+" is "+ base.convert(num,from,to)+" in base "+to);
					}else{
						System.out.println("Options: ");
						System.out.println("\t1. Encode");
						System.out.println("\t2. Decode");
						System.out.print("Select an Option: ");
						int encodeOption=scan.nextInt();
						if(encodeOption>2 || encodeOption<1){
							System.out.println("Enter a valid option");
							break;
						}
						if(encodeOption==1){
							System.out.print("Enter the base to convert it to: ");
							int toBase=scan.nextInt();
							System.out.print("Enter ASCII text to encode: ");
							scan.nextLine();
							String text=scan.nextLine();
							System.out.println(text);
					
							System.out.println("The encoded message is: "+base.encodeASCII(text, toBase));
						}else{
							System.out.print("Enter the current base: ");
							int decodeBase=scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the encoded ASCII to decode: ");
							String decoded=scan.nextLine();
							System.out.println("The decoded message is: "+base.decodeASCII(decoded,decodeBase));
						}
					}
					break;
				case 2:
					sort sorter=new sort();
					System.out.println("Enter the list of numbers you want to sort, separated by a space");
					scan.nextLine();
					String nums=scan.nextLine();
					ArrayList<Integer> numbers=new ArrayList<Integer>();
					Scanner scanNums=new Scanner(nums);
					while(scanNums.hasNext()){
						numbers.add(scanNums.nextInt());
					}
					System.out.println("Enter whether you want to sort ascending or descending. 1 for ascending, 0 for descending");
					int method=scan.nextInt();
					System.out.println("The sorted array of integers is "+sorter.bubbleSort(numbers, method));
					break;
				case 3:
					System.out.println("Options: ");
					System.out.println("\t1. Rectangular Prism");
					System.out.println("\t2. Cylinder");
					System.out.println("\t3. Sphere");
					System.out.print("Select an Option: ");
					int surfaceOption=scan.nextInt();
					if(surfaceOption==1){
						System.out.print("Enter length, width, and height, separated by a space: ");
						double length=scan.nextDouble();
						double width=scan.nextDouble();
						double height=scan.nextDouble();
						System.out.println("The surface area is: " +SurfaceArea.surfaceAreaPrism(length, width, height));	
					}else if(surfaceOption==2){
						System.out.print("Enter radius and height, separated by a space: ");
						double radius=scan.nextDouble();
						double height=scan.nextDouble();
						System.out.println("The surface area is: "+SurfaceArea.surfaceAreaCylinder(radius,height));
					}else if(surfaceOption==3){
						System.out.print("Enter the radius: ");
						int radius=scan.nextInt();
						System.out.println("The surface area is: "+SurfaceArea.surfaceAreaSphere(radius));
					}
					break;
				case 4:
					System.out.println("Options: ");
					System.out.println("\t1. Rectangular Prism");
					System.out.println("\t2. Cylinder");
					System.out.println("\t3. Sphere");
					System.out.print("Select an Option: ");
					int volumeOption=scan.nextInt();
					if(volumeOption==1){
						System.out.print("Enter length, width, and height, separated by a space: ");
						double length=scan.nextDouble();
						double width=scan.nextDouble();
						double height=scan.nextDouble();
						System.out.println("The volume is: " +Volume.volumePrism(length, width, height));	
					}else if(volumeOption==2){
						System.out.print("Enter radius and height, separated by a space: ");
						double radius=scan.nextDouble();
						double height=scan.nextDouble();
						System.out.println("The volume is: "+Volume.volumeCylinder(radius,height));
					}else if(volumeOption==3){
						System.out.print("Enter the radius: ");
						int radius=scan.nextInt();
						System.out.println("The volume is: "+Volume.volumeSphere(radius));
					}
					break;
				case 5:
					int side=0;
					while(side<=2)
					{
					    System.out.print("Enter number of sides: ");
					    side = scan.nextInt();
					    if(side<=2)
					    {
					        System.out.println("This is not a valid shape");
					    }
					}
					Angle angleOne = new Angle(side);
					System.out.println(""+angleOne);
					break;
				case 6:
					System.out.println("Quadratic Equation Solver ");
					System.out.print("Enter A, B, C [all on one line]");
					int A = scan.nextInt();
					int B = scan.nextInt();
					int C = scan.nextInt();
					Roots root1 = new Roots(A, B, C);
					
					System.out.println(""+root1);
					break;
				case 7:
					System.out.println("Options: ");
					System.out.println("\t1. Primality test");
					System.out.println("\t2. Find all primes lower than a number");
					System.out.println("\t3. Find prime factors");
					System.out.print("Select an Option: ");
					int primeOption=scan.nextInt();
					Primes prime=new Primes();
					if(primeOption==1){
						System.out.print("Enter the number you want to perform a primality test on: ");
						int testPrime=scan.nextInt();
						System.out.println("The number "+testPrime+" is "+(prime.isPrime(testPrime)?"prime":"not prime"));
					}else if(primeOption==2){
						System.out.print("Enter the numbers you want to find the primes under: ");
						int primeMax=scan.nextInt();
						System.out.println("The primes under "+primeMax+" are: "+prime.sieve(primeMax));
					}else{
						System.out.print("Enter the number you want to factorize: ");
						int factor=scan.nextInt();
						System.out.println("The prime factors of "+factor+" are " + prime.primeFactors(factor));
					}
					break;
				case 8:
					TrianglePythagorean ptri = new TrianglePythagorean();

			        System.out.println(".....If unknown enter 0.....\n");

			        System.out.println("Enter the length of side 1(Hypotenuse)...\t");
			        ptri.setSide1(scan.nextInt());

			        System.out.println("Enter the length of side 2...\t\t");
			        ptri.setSide2(scan.nextInt());

			        System.out.println("Enter the length of side 3...\t\t");
			        ptri.setSide3(scan.nextInt());

			        ptri.pythagorean();

			}
		}while(option>0 && option<9);
		
		
	}

}
/*


 */