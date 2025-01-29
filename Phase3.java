package cinema;
import java.util.Scanner;
public class Cinema{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows = sc.nextInt();
		System.out.println("Enter the number of seats in each row:");
		int cols = sc.nextInt();
		int totalseats = cols * rows;
		
		String[][] seats = initializeSeats(rows, cols);
        printSeats(seats, rows, cols);

		//Seat prices
		System.out.println("Enter a row number:");
		int rowSeat = sc.nextInt();
		System.out.println("Enter a seat number in that row:");
		int colSeat = sc.nextInt();
		if (totalseats <= 60){
			System.out.println("Ticket price: $10");
		}
		else{
				int frontHalf = (rows / 2) ;
				if(rowSeat <= frontHalf){
					System.out.println("Ticket price: $10");
				}
				else{
					System.out.println("Ticket price: $8");
				}
			}
		// Mark the seat as busy
        seats[rowSeat - 1][colSeat - 1] = "B";
        printSeats(seats, rows, cols);

		
		
	}

	public static String[][] initializeSeats(int rows, int cols) {
        String[][] seats = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "S";
            }
        }
        return seats;
    }

    public static void printSeats(String[][] seats, int rows, int cols) {
		System.out.println("Cinema:");
        System.out.print("  ");
        for (int j = 1; j <= cols; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}
