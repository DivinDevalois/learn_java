// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters

        Employee employee1= new Employee();
        employee1.setName("Maelle");
        employee1.setAge(30);
        employee1.setSalary(5500);

        Employee employee2=new Employee();
        employee1.setName("Gabrielle");
        employee1.setAge(20);
        employee1.setSalary(6860);
        
        System.out.println("\nInitial Employee Details:");
        employee1.displayDetail();
        employee2.displayDetail();

        
        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        System.out.println("Testing validation with invalid values:");
        employee1.setName("");  // Invalid: empty name
        employee1.setAge(70);   // Invalid: age outside range
        employee2.setSalary(-100); // Invalid: negative salary

        System.out.println("\nEmployee Details After Invalid Values:");
        employee1.displayDetail();
        employee2.displayDetail();


        
        // Step 4: Give both employees a 10% raise and display their details again
        System.out.println("employee raise 10%");
        employee1.giveRaise(10);
        employee2.giveRaise(10);
        
        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
         System.out.println("\nCloning the first employee...");
         try {
            Employee clonedEmployee= (Employee) employee1.clone();
            System.out.println("employee cloned");
            clonedEmployee.displayDetail();
            System.out.println("Modifying the original employee's salary...");
            employee1.setSalary(6000.0);
            
            System.out.println("\nOriginal Employee After Modification:");
            employee1.displayDetail();
            
            System.out.println("Cloned Employee After Original was Modified:");
            clonedEmployee.displayDetail();
         } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
         }
        // Step 6: Compare salaries
        String result = compareSalaries(employee1, employee2);
        System.out.println("Salary Comparison Result: " + result);
    }
    
    // Step 7: Create a method that compares the salaries of two employees
    // and returns the name of the employee with the higher salary
    // If salaries are equal, return "Equal salaries"// Method to compare salaries
    public static String compareSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName() + " has a higher salary";
        } else if (emp2.getSalary() > emp1.getSalary()) {
            return emp2.getName() + " has a higher salary";
        } else {
            return "Equal salaries";
        }
    }
}

