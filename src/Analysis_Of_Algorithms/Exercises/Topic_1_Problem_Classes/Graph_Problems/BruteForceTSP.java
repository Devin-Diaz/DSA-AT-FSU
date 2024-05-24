package Analysis_Of_Algorithms.Exercises.Topic_1_Problem_Classes.Graph_Problems;

import java.util.ArrayList;
import java.util.List;

public class BruteForceTSP {
    private double[][] distanceMatrix;
    private int numberOfCities;

    public BruteForceTSP(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
        this.numberOfCities = distanceMatrix.length;
    }

    public List<Integer> getShortestTour() {
        // Generate initial list of cities
        List<Integer> cities = new ArrayList<>();
        for (int i = 0; i < numberOfCities; i++) {
            cities.add(i);
        }

        List<Integer> bestTour = new ArrayList<>(cities);
        double bestTourCost = Double.MAX_VALUE;

        // Compute all permutations of cities and evaluate the cost
        permuteCities(new ArrayList<>(), cities, bestTour, bestTourCost);

        return bestTour;
    }

    private void permuteCities(List<Integer> currentTour, List<Integer> remainingCities,
                               List<Integer> bestTour, double bestTourCost) {
        if (remainingCities.isEmpty()) {
            currentTour.add(currentTour.get(0)); // Return to start city to complete the circuit
            double tourCost = calculateTourCost(currentTour);

            if (tourCost < bestTourCost) {
                bestTour.clear();
                bestTour.addAll(currentTour);
                bestTourCost = tourCost;
            }
            currentTour.remove(currentTour.size() - 1); // Remove the return step for further permutations
        } else {
            for (int i = 0; i < remainingCities.size(); i++) {
                int city = remainingCities.remove(i);
                currentTour.add(city);

                permuteCities(currentTour, remainingCities, bestTour, bestTourCost);

                remainingCities.add(i, city);
                currentTour.remove(currentTour.size() - 1);
            }
        }
    }

    private double calculateTourCost(List<Integer> tour) {
        double totalCost = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            totalCost += distanceMatrix[tour.get(i)][tour.get(i + 1)];
        }
        return totalCost;
    }

    public static void main(String[] args) {
        double[][] distanceMatrix = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        BruteForceTSP tsp = new BruteForceTSP(distanceMatrix);
        List<Integer> shortestTour = tsp.getShortestTour();
        System.out.println("Shortest Tour: " + shortestTour);
    }
}

