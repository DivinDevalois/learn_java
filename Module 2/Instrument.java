public abstract class Instrument {
    private String name;
    protected int year;

    public  Instrument(String name, int year){
        this.name=name;
        this.year=year;
    }
    
    public abstract String play();

    public String getInstrumentDetails(){
        return "Instrument: " + name + " year: " + year;
    }

    

}
interface  Tunable{
    String tune();
    String adjustPitch(boolean up);
}

interface Maintainable{
    String clean();
    String inspect();
}

class StringedInstrument extends Instrument{
    private int numberOfStrings;
    
    public StringedInstrument(int numberOfStrings){
        super(name, year);
        this.numberOfStrings=numberOfStrings;
    }

    @Override
    public String play(){
        return "am playin instrument";
    }

    @Override
    public String getInstrumentDetails(){
        return super.getInstrumentDetails() +", Strings:" + numberOfStrings;
    }
}


class Guitar extends StringedInstrument implements Tunable, Maintainable {
    // Additional field specific to Guitar
    private String guitarType;
    
    // Constructor
    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings); // Call parent constructor
        this.guitarType = guitarType;
    }
    
    // Override play method to be more specific
    @Override
    public String play() {
        return "Playing the " + guitarType + " guitar with " + getNumberOfStrings() + " strings";
    }
    
    // Override parent method to add more details
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + guitarType;
    }
    
    // Implement methods from Tunable interface
    @Override
    public String tune() {
        return "Tuning the " + guitarType + " guitar";
    }
    
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the guitar" : "Decreasing pitch of the guitar";
    }
    
    // Implement methods from Maintainable interface
    @Override
    public String clean() {
        return "Cleaning the " + guitarType + " guitar";
    }
    
    @Override
    public String inspect() {
        return "Inspecting the " + guitarType + " guitar from " + year;
    }
}

// Step 6: Create a concrete class Piano that extends Instrument and implements interfaces
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
    public String play() {
        return "Playing the " + (isGrand ? "grand" : "upright") + " piano";
    }
    
    // Override parent method to add more details
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + (isGrand ? "Grand" : "Upright");
    }
    
    // Implement methods from Tunable interface
    @Override
    public String tune() {
        return "Tuning the piano";
    }
    
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the piano" : "Decreasing pitch of the piano";
    }
    
    // Implement methods from Maintainable interface
    @Override
    public String clean() {
        return "Cleaning the piano keys and interior";
    }
    
    @Override
    public String inspect() {
        return "Inspecting the " + (isGrand ? "grand" : "upright") + " piano from " + year;
    }
}

// Step 7: Create a class to test everything
public class MusicShop {
    public static void main(String[] args) {
        // Create an array of Instrument objects
        Instrument[] instruments = new Instrument[3];
        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "electric");
        instruments[1] = new Piano("Steinway", 2015, true);
        instruments[2] = new Guitar("Martin", 2018, 12, "acoustic");
        
        // Demonstrate polymorphism by calling play() for each instrument
        System.out.println("===== PLAYING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println(instrument.play());
            System.out.println(instrument.getInstrumentDetails());
        }
        
        // Demonstrate interface type checking and method calling
        System.out.println("\n===== MAINTAINING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println("Working with: " + instrument.getName());
            
            // Check if this instrument is Tunable
            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));
            }
            
            // Check if this instrument is Maintainable
            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());
            }
            
            System.out.println("-----");
        }
    }
}
// 0604414646
