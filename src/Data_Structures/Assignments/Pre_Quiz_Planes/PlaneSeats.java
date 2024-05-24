package Data_Structures.Assignments.Pre_Quiz_Planes;

import java.util.ArrayList;
import java.util.List;

public class PlaneSeats {
    private final boolean[] seats;
    private boolean planeIsFullChecker;

    public PlaneSeats() {
        seats = new boolean[10];
        planeIsFullChecker = false;
    }

    public boolean getPlaneIsFullChecker() {
        return planeIsFullChecker;
    }

    public int addEconomySeat() {
        if(economySeatsFull()) {
            System.out.println();
            throw new RuntimeException("ALL ECONOMY SEATS FULL, SORRY!");
        }

        List<Integer> availableSeats = new ArrayList<>();

        for(int i = 5; i < 10; i++) {
            if(!seats[i]) availableSeats.add(i);
        }

        if(availableSeats.isEmpty()) throw new RuntimeException("ALL ECONOMY SEATS FULL, SORRY!");

        int randomIndex = (int)(Math.random() * availableSeats.size());
        int randomSeat = availableSeats.get(randomIndex);

        seats[randomSeat] = true;

        return randomSeat + 1;
    }

    public int addFirstClassSeat() {
        if(firstClassSeatsFull()) {
            System.out.println();
            throw new RuntimeException("ALL FIRST CLASS SEATS FULL, SORRY!");
        }

        List<Integer> availableSeats = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            if(!seats[i]) availableSeats.add(i);
        }

        if(availableSeats.isEmpty()) throw new RuntimeException("ALL FIRST CLASS SEATS FULL, SORRY!");

        int randomIndex = (int)(Math.random() * availableSeats.size());
        int randomSeat = availableSeats.get(randomIndex);

        seats[randomSeat] = true;
        return randomSeat + 1;
    }

    public boolean economySeatsFull() {
        for(int i = 5; i < seats.length; i++) {
            if(!seats[i]) return false;
        }
        return true;
    }

    public boolean firstClassSeatsFull() {
        for(int i = 0; i < 5; i++) {
            if(!seats[i]) return false;
        }
        return true;
    }

    public boolean firstAndEconClassSeatsFull() {
        return economySeatsFull() && firstClassSeatsFull();
    }

    public void planeIsFull() {
        System.out.println("**ALL SEATS ARE FULL**");
        System.out.println("NEXT ONE LEAVES IN 3 HOURS");
        System.out.println("THANKS FOR CHOOSING DIAZ AIRLINES");
    }

    public void displaySeats() {
        StringBuilder sb = new StringBuilder();

        System.out.println();
        System.out.println();
        System.out.printf("%41s", "* SEAT MAP *");
        System.out.println();

        for(int i = 0; i < 72; i++) {
            System.out.print("-");
        }

        sb.append("- ");
        for(int i = 0; i < seats.length; i++) {
            if(seats[i]) {
                sb.append(i + 1).append(" F -- ");
            }
            else {
                sb.append(i + 1).append(" A -- ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);

        System.out.println();
        System.out.println(sb);
        for(int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%42s", "diaz airlines©");

        System.out.println();
        System.out.println();
    }

    public void processedTicketOutput(int ticketType, int seatNumber) {

        if(ticketType == 1) {
            System.out.println("TICKED PROCESSED... FIRST CLASS CONFIRMED...SEAT #: " + seatNumber);
        }
        else if(ticketType == 2) {
            System.out.println("TICKET PROCESSED...ECONOMY CONFIRMED SEAT #" + seatNumber);
        }
        else {
            System.out.println();
            System.out.println("NEXT PLANE LEAVES IN 3 HOURS");
            System.out.println("THANK YOU FOR CHOOSING DIAZ AIRLINES");
            planeIsFullChecker = true;
        }
    }

}
