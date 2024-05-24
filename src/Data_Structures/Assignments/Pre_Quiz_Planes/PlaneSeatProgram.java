package Data_Structures.Assignments.Pre_Quiz_Planes;

import java.util.Scanner;

public class PlaneSeatProgram {
    private final PlaneSeats plane;

    public PlaneSeatProgram() {
        plane = new PlaneSeats();
    }

    public void start() {
        while(!plane.getPlaneIsFullChecker()) {
            if(plane.firstAndEconClassSeatsFull()) {
                plane.planeIsFull();
                break;
            }

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("WELCOME TO DIAZ AIRLINES");
            System.out.print("ENTER 1 FOR FIRST CLASS | 2 FOR ECONOMY | 3 TO EXIT : ");
            int choice = sc.nextInt();

            try {
                if(choice == 1) {
                    plane.processedTicketOutput(choice, plane.addFirstClassSeat());
                    plane.displaySeats();
                }
                else if(choice == 2) {
                    plane.processedTicketOutput(choice, plane.addEconomySeat());
                    plane.displaySeats();
                }
                else {
                    plane.processedTicketOutput(0, 0);
                }
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
