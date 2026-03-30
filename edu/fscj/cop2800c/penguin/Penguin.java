// Penguin.java
// Jihae Kim
// 03/29/2026
// Represents a Palmer Penguin

package edu.fscj.cop2800c.penguin;

// Penguin class extends the Bird base class
public class Penguin extends Bird {
    // private fields
    private String species;
    private double flipperLength;

    // Constructor
     public Penguin(int sampleNum, String species,
                   double culmenLength, double culmenDepth,
                   double bodyMass, String sex, double flipperLength) {
        super(sampleNum, culmenLength, culmenDepth, bodyMass, sex);
        this.species = species;
        this.flipperLength = flipperLength;
    }

    // Getter methods
    public String getSpecies() {
        return species;
    }

    public double getFlipperLength() {
        return flipperLength;
    }

    // Override Bird class's toString method
    @Override
    public String toString() {
        return super.toString() + 
               ", species='" + species + '\'' +
               ", flipperLength=" + flipperLength;
    }

    // Override Bird's compareTo method to include Penguin field comparison
    @Override
    public int compareTo(Bird other) {
        int result = super.compareTo(other);
        if (result != 0) return result;

        // Check if 'other' is a Penguin before 
        // comparing flipper length and species
        if (other instanceof Penguin) {
            Penguin otherPenguin = (Penguin) other;
    
            // Compare flipper length
            result = Double.compare(
                this.flipperLength, otherPenguin.flipperLength);
            if (result != 0) return result;
    
            // Compare species (handle potential null values)
            if (this.species == null && otherPenguin.species == null) return 0;
            if (this.species == null) return -1;
            if (otherPenguin.species == null) return 1;
    
            return this.species.compareTo(otherPenguin.species);
        }

        return result;
    }
}
