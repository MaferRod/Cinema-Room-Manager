package cinema;
import java.util.Scanner;

public class Cinema {

    
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows = sc.nextInt();
		System.out.println("Enter the number of seats in each row:");
		int seats = sc.nextInt();
		int totalseats = seats * rows;
		if (totalseats <= 60){
			int profit = totalseats * 10;
			System.out.println("Total income:");
			System.out.println("$" + profit);
		}
		else{
			if(rows % 2 == 0){
				int frontHalf = (rows / 2) * seats;
				int backHalf = (rows / 2) * seats;
				int profit = (frontHalf * 10) + (backHalf * 8);
				System.out.println("$" + profit);
			}
			else{
				int frontHalf = (rows / 2) * seats;
				int backHalf = ((rows / 2) + 1) * seats;
				int profit = (frontHalf * 10) + (backHalf * 8);
				System.out.println("$" + profit);
			}
		}
		
		
		
		
	}

}
