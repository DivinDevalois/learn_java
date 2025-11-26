import java.util.Scanner;

public class ShapeDemo {
    public static void main(String[] args) {

        // Step 1: Create an array of Shape objects with size 5
        // Hint: Shape[] shapes = new Shape[5];
        
        Shape [] shapes=new Shape[5];

        
        // Step 2: Create a Scanner object for user input
        
        Scanner scanner=new Scanner(System.in);
        boolean exit=false;
        int shapeCount = 0;

        // Step 3: Create an interactive menu to add shapes to the array
        // Hint: Use a loop and a counter to keep track of how many shapes are added
        // The menu should allow users to:
        // 1. Add a Circle
        // 2. Add a Rectangle
        // 3. Add a Triangle
        // 4. Display all shapes
        // 5. Exit

        while (true) { 
            System.out.println("\n===== Shape Management System =====");
            System.out.println("1. Add a Circle");
            System.out.println("2. Add a Triangle");
            System.out.println("3. Add a Rectangle");
            System.out.println("4. Display all shapes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise) {
                case 1:
                    if (shapeCount < shapes.length) {
                        System.out.print("Enter circle name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter circle color: ");
                        String color = scanner.nextLine();
                        
                        System.out.print("Enter circle radius: ");
                        double radius = scanner.nextDouble();
                        scanner.nextLine();
                        
                        shapes[shapeCount] = new Circle(name, color, radius);
                        System.out.println("Circle added successfully!");
                        System.out.println("\nCircle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].Area());
                        System.out.println("Perimeter: " + shapes[shapeCount].Perimeter());
                        shapeCount++;
                    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
                    }
                break;
                case 2:
                    if(shapeCount<shapes.length){
                        System.out.println("enter the triangle name");
                        String name=scanner.nextLine();

                        System.out.println("enter the triangle color");
                        String color=scanner.nextLine();

                        System.out.println("enter the triangle side1");
                        double side1=scanner.nextDouble();

                        System.out.println("enter the triangle side2");
                        double side2=scanner.nextDouble();

                        System.out.println("enter the triangle side3");
                        double side3=scanner.nextDouble();

                        scanner.nextLine();

                        shapes[shapeCount]= new Triangle(name, color, side1, side2, side3);
                        System.out.println("Triangle added successfully!");
                        System.out.println("\nTriangle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].Area());
                        System.out.println("Perimeter: " + shapes[shapeCount].Perimeter());
                        shapeCount++;
                    }else{
                        System.out.println("can add more shapp array is full");
                    }
                break;

                case 3:
                    if (shapeCount<shapes.length) {
                        System.out.println("enter Rectangle name");
                        String name=scanner.nextLine();

                        System.out.println("enter Rectangle color");
                        String color=scanner.nextLine();

                        System.out.println("enter Rectangle length");
                        double length=scanner.nextDouble();

                        System.out.println("enter Rectangle width");
                        double width=scanner.nextDouble();

                        scanner.nextLine();

                        shapes[shapeCount]=new Rectangle(name, color, length, width);
                        System.out.println("Triangle added successfully!");
                        System.out.println("\nTriangle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].Area());
                        System.out.println("Perimeter: " + shapes[shapeCount].Perimeter());
                        shapeCount++;            
                    }else{
                        System.out.println("can add more shapp array is full");
                    }
                break;

                case 4:
                    if(shapeCount>0){
                        for(int i=0; i<shapeCount; i++){
                            System.out.println(shapes[i].toString());
                            System.out.println("Area:" +shapes[i].Area());
                            System.out.println("Area:" +shapes[i].Perimeter());
                        }

                    }else{
                        System.out.println("no shapes to display so enter shapes");
                    }
                break;

                case 5:
                    exit=true;
                    System.out.println("Goodbye ");
                    scanner.close();
                break;
                
                default:
                    System.out.println("invalid choice");
            }
        }

        
        // Step 4: For each shape type, prompt the user for the required attributes
        // For Circle: name, color, radius
        // For Rectangle: name, color, length, width
        // For Triangle: name, color, side1, side2, side3
        
        // Step 5: After adding a shape, display its details
        
        // Step 6: When displaying all shapes, loop through the array and call each shape's
        // toString(), area(), and perimeter() methods
        // This will demonstrate polymorphism as each shape type will use its own implementation

    }



}

