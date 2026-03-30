// PalmerPenguins.java
// Jihae Kim
// 03/29/2026
// Palmer Penguins application

package edu.fscj.cop2800c.penguin;

public class PalmerPenguins {
    public static void main(String[] args) {
        int numPenguins = 0;
        
        // Create an instance of PenguinAnalyzer
        PenguinAnalyzer analyzer = new PenguinAnalyzer();
    
        // Read CSV data
        numPenguins = analyzer.readPenguins();
        
        // Check if any penguins were read, exit if none
        if (numPenguins == 0) {
            System.err.println(
                "Error: No penguins were read from the file. Exiting program.");
            System.exit(1); // Exit with a non-zero status to indicate an error
        }
    
        if (numPenguins > 1) {
            // Test the compareTo method
            System.out.println("Testing compareTo method:");
        
            Penguin p1 = analyzer.getPenguinBySampleNum(1);
            Penguin p2 = analyzer.getPenguinBySampleNum(2);
        
            if (p1 != null && p2 != null) {
                int comparisonResult = p1.compareTo(p2);
                System.out.println(
                    "Comparison result between first two penguins: " + comparisonResult);
        
                // Test compareTo for equality condition (p1 compared to itself)
                int selfComparison = p1.compareTo(p1);
                System.out.println(
                    "Comparison result of p1 to itself (should be 0): " + selfComparison);
            } else {
                System.out.println("Could not find both penguins for comparison.");
            }
        } else {
            System.out.println("Not enough penguins to test compareTo.");
        }
    
        // Test the toString methods
        analyzer.showRawData();
    
        // Print formatted output
        analyzer.printPenguins();
    
        // Save results to a file
        analyzer.writePenguins();
    }
}