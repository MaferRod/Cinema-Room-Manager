package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Cinema:");
        int cols = 8;
        int rows = 7;
        String[][] seats = new String[rows][cols];
        
        // Initialize the seating chart
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "S";
            }
        }
        
        // Print the column headers
        System.out.print("  ");
        for (int j = 1; j <= cols; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        // Print the seating chart with row headers
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}
