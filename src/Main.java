import java.util.Scanner;

public class Main {
    //instantiates an instance of EmployeeManager
    public static EmployeeManager em = new EmployeeManager();

    public static void main(String[] args) { //start main method4
        menu();//call menu method
    } //end main method

    public static void menu(){ //start menu method

        int selection = 0;
        Scanner kb = new Scanner(System.in); //scanner kb keyboard init

        while (selection != 7){
            System.out.println("\t\tEmployee Array API \n");
            System.out.println("1 ===>>> To List Employees");
            System.out.println("2 ===>>> To Add an Employee");
            System.out.println("3 ===>>> To Save an Employee");
            System.out.println("4 ===>>> To Load Employees");
            System.out.println("5 ===>>> To Search for an Employee");
            System.out.println("6 ===>>> To Delete an Employee");
            System.out.println("7 ===>>> To Exit the System");
            selection = kb.nextInt();

            Employee emp = new Employee();
            if(selection == 1){     //Begin If Selection
                System.out.println("You Selected to list all Employees \n\n");
                em.print();
            }
            else if(selection == 2){
                System.out.println("You Selected to Add Employees \n\n");
                Employee newEmployee;
                newEmployee = em.getAnEmployee();
                em.append(newEmployee);
            }
            else if(selection == 3){
                System.out.println("You Selected to Save All Current Employees \n\n");
                em.saveEmployees();
            }
            else if(selection == 4){
                System.out.println("You Selected to Load All Current Employees \n\n");
                em.loadEmployees();
            }
            else if(selection == 5){
                System.out.println("You Selected to Search for an Employee \n\n");
                emp = getEmployeeIDObject();
                if(emp == null){
                    System.err.println("No Matching record");
                }
                else{
                    int stat = em.seqSearch(emp);
                    System.out.println("The status of the search is " + stat);
                }
            }
            else if(selection == 6){
                System.out.println("You Selected to Delete an Employee");
                EmployeeManager.deleteEmployee(em);
            }
            else if (selection == 7){
                System.out.println("You Selected to Exit the program");
                System.out.println("Have a great day!");
            }
        } kb.close(); //while loop
    }//end menu

    //start get employee id object
    public static Employee getEmployeeIDObject() {
        Employee temp = null; //holds the state of the ID
        int empID; //holds the input representing an employee ID
        Scanner kb = new Scanner(System.in); //key board data stream
        String response; //holds state of users response
        //end get employee id object

        //obtains an employee ID from user
        System.out.println("Employee ID to Search for \n\n");
        System.out.println("What is the employee ID that you are searching for?: \n");
        empID = kb.nextInt();

        //Echos the users input and confirms validity
        System.out.println("Is this the employee ID that you are searching for?: " + empID);
        response = kb.next();

        //Evaluates a users response
        if (response.toUpperCase().equals("Y")) {
            //begin if
            temp = new Employee();
            temp.setEmployeeID(empID);
        }
        return temp;
    }//end get employee id object

}//end main class


