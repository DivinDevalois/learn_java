// Step 1: Create an abstract class Instrument

public abstract class Instrument{
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method Play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument

    private String name;
    protected int year;

    public Instrument(String name, int year){
        this.name=name;
        this.year=year;
    }

    public abstract String Play();

    public String getInstrumentDetails(){
        return "instrument name: " + name + " year of manufacture: " + year;
    }

    public String getName  (){
        return this.name;
    }

    public int getYear(){
        return this.year;
    }
}




// Step 2: Create an interface Tunable
// This should include:
// - abstract method Tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means increase pitch)

interface Tunable{
    String Tune();

    String adjustPitch(boolean up);
}


// Step 3: Create an interface Maintainable
// This should include:
// - abstract method Tune() that returns a String
// - abstract method Inspect() that returns a String

interface Maintainable{
    String Clean();
    String Inspect();
}


// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract Play() method
// - override getInstrumentDetails() to include number of strings

class StringedInstrument extends Instrument {
    private int numberOfStrings;

    public StringedInstrument(String name, int year, int numberOfStrings){
        super(name, year);
        this.numberOfStrings=numberOfStrings;
    }

    @Override
    public String Play() {
        return "Playing and instrument";
    }

    @Override

    public String getInstrumentDetails(){
        return super.getInstrumentDetails()+ "instrument number: " + numberOfStrings;
    }

}


// Step 5: Create a concrete class Guitar that extends StringedInstrument 
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods

class Guitar extends StringedInstrument implements Tunable, Maintainable{
    private String guitarType;

    public Guitar(String name, int year, int numberOfStrings, String guitarType){
        super(name, year, numberOfStrings);
        this.guitarType=guitarType;
    }

    @Override
    public String Play(){
        return "Playing the" +guitarType + "guitar with " + getInstrumentDetails();
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + guitarType;
    }

    @Override
    public String Tune() {
        return "Tuning the " + guitarType + " guitar";
    }

    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the guitar" : "Decreasing pitch of the guitar";
    }

    public String Clean() {
        return "Cleaning the " + guitarType + " guitar";
    }
    
    @Override
    public String Inspect() {
        return "Inspecting the " + guitarType + " guitar from " + year;
    }

}


// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract Play() method
// - implementation of all required interface methods

class Piano extends Instrument implements Tunable, Maintainable {
    // Additional field specific to Piano
    private boolean isGrand;
    
    // Constructor
    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }
    
    // Implementation of abstract method from parent
    @Override
    public String Play() {
        return "Playing the " + (isGrand ? "grand" : "upright") + " piano";
    }
    
    // Override parent method to add more details
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + (isGrand ? "Grand" : "Upright");
    }
    
    // Implement methods from Tunable interface
    @Override
    public String Tune() {
        return "Tuning the piano";
    }
    
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the piano" : "Decreasing pitch of the piano";
    }
    
    // Implement methods from Maintainable interface
    @Override
    public String Clean() {
        return "Cleaning the piano keys and interior";
    }
    
    @Override
    public String Inspect() {
        return "Inspecting the " + (isGrand ? "grand" : "upright") + " piano from " + year;
    }
}


// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
//   2. Iterates through the array calling Play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods

class MusicShop {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];
        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "electric");
        instruments[1] = new Piano("Steinway", 2015, true);
        instruments[2] = new Guitar("Martin", 2018, 12, "acoustic");
        
        System.out.println("===== PLAYING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println(instrument.Play());
            System.out.println(instrument.getInstrumentDetails());
        }
        
        System.out.println("\n===== MAINTAINING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println("Working with: " + instrument.getName());
            
            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.Tune());
                System.out.println(tunableInstrument.adjustPitch(true));
            }
            
            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.Clean());
                System.out.println(maintainableInstrument.Inspect());
            }
            
            System.out.println("-----");
        }
    }
}
