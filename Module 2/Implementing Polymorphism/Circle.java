// Circle class - a subclass of Shape
public class Circle extends Shape {
    // Step 1: Declare private variable for radius
    // Hint: Use double for the radius
    private double raduis;
    
    // Step 2: Create a constructor that takes name, color, and radius as parameters
    // Hint: Use super() to call the parent constructor and then initialize radius

    public Circle(String name, String color, double raduis){
        super(name, color);
        this.raduis=raduis;
    }
    
    // Step 3: Create getter method for radius
    // Hint: public double getRadius()

    public double getRaduis(){
        return this.raduis;
    }
    
    // Step 4: Override the area() method to calculate the area of a circle
    // Hint: Area of a circle = π * radius * radius (use Math.PI)

    @Override

    public double Area(){
        return Math.PI*raduis*raduis;
    }
    
    // Step 5: Override the perimeter() method to calculate the perimeter (circumference) of a circle
    // Hint: Perimeter of a circle = 2 * π * radius (use Math.PI)

    public double perimeter(){
        return 2*Math.PI*raduis;
    }
    
    // Step 6: Override toString() method to include circle-specific information
    // Hint: Call the parent's toString() method and append circle-specific details
    @Override
    public String toString(){
        return super.toSTring()+", Shape Type: Circle, raduis: " + raduis;
    }
}
