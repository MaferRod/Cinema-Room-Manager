package cinema;
import java.util.Scanner;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int cols = sc.nextInt();
        
        String[][] seats = initializeSeats(rows, cols);
        int purchasedTickets = 0;
        int totalSeats = rows * cols;
        int currentIncome = 0;
        int totalIncome = totalIncome(rows, cols);
        
        while (true) {
            System.out.println("1. Show the seats\n" + 
                               "2. Buy a ticket\n" +
                               "3. Statistics\n" + 
                               "0. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    printSeats(seats, rows, cols);
                    break;
                case 2:
                    currentIncome += buyTickets(seats, rows, cols, sc);
                    purchasedTickets++;
                    break;
                case 3:
                    printStatistics(purchasedTickets, totalSeats, currentIncome, totalIncome);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static int buyTickets(String[][] seats, int rows, int cols, Scanner sc) {
        int totalseats = cols * rows;
        int ticketPrice;
        // Seat prices
        System.out.println("Enter a row number:");
        int rowSeat = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int colSeat = sc.nextInt();
        if (rowSeat > rows || colSeat > cols) {
            System.out.println("Wrong input!");
            return buyTickets(seats, rows, cols, sc);
        }
        if (totalseats <= 60) {
            ticketPrice = 10;
        } else {
            int frontHalf = (rows / 2);
            if (rowSeat <= frontHalf) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        // Mark the seat as busy
        if (seats[rowSeat - 1][colSeat - 1].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            return buyTickets(seats, rows, cols, sc);
        } else {
            System.out.println("Ticket price: $" + ticketPrice);
            seats[rowSeat - 1][colSeat - 1] = "B";
        }
        printSeats(seats, rows, cols);
        return ticketPrice;
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

    public static int totalIncome(int rows, int cols) {
        int totalSeats = rows * cols;
        int frontHalf = rows / 2;
        int backHalf = rows - frontHalf;
        if (totalSeats <= 60) {
            return totalSeats * 10;
        } else {
            return (frontHalf * cols * 10) + (backHalf * cols * 8);
        }
    }

    public static void printStatistics(int purchasedTickets, int totalSeats, int currentIncome, int totalIncome) {
        double percentage = (double) purchasedTickets / totalSeats * 100;
        System.out.printf("Number of purchased tickets: %d%n", purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }
}
