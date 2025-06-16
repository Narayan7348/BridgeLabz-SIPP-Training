import java.util.*;
public class Volume_of_cylinder {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double r=sc.nextDouble();
		double h=sc.nextDouble();
		double volume=Math.PI*r*r*h;
		System.out.print(volume);

	}

}
