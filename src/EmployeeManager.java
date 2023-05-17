import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeManager {
    protected int length; //to store the length of the list
    protected int maxSize; //to store the maximum size of the list
    protected Employee [] list; //array to hold the list elements

    //Place the definitions of the instance methods
    //and abstract methods here

    //default constructor
    public EmployeeManager(){
        length = 0;
        maxSize = 10;
        list = new Employee[maxSize];
    }

    //constructor with one argument
    public EmployeeManager(int size){
        if (size <=0){
            System.err.println("The array size must be positive. " +
                    "Creating an array of size 100");
            maxSize = 100;
        } else {
            this.maxSize = size;
            this.length = 0;
            this.list = new Employee[this.maxSize];
        }
    }//end constructor

    //append method
    public void append(Employee newEmployee){

        if(length == maxSize){
            System.err.println("Cannot insert into a full list.");
        }
        else{
            //list is empty
            list[length] = newEmployee; //insert insertItem
            this.length++; //increment length
        }
    }//end append method

    //print method for all elements in array
    public void print(){
        int count = 0;
        while (count<length){
            System.out.println(list[count].toString());
            count++;
        }
    }

    //loadEmployees Method
    public void loadEmployees(){
        //Record structure of employee Test Data File

        //First item is first name
        //Second item is Last name
        //Third item is email
        //Fourth Item is Employee ID
        //Fifth is Phone number
        Employee temp = new Employee();

        try {
            File file = new File("testdata.txt");
            Scanner empdata = new Scanner(file);

            while (empdata.hasNext()){ //start while
                String record = empdata.nextLine();
                String[] fields = record.split(",");
                temp.setFirstName(fields[0]);
                temp.setLastName(fields[1]);
                temp.setEmail(fields[2]);
                temp.setEmployeeID(Integer.parseInt(fields[3]));
                temp.setPhoneNumber(fields[4]);
                append(temp);
            }//end while
            print();
        }//end try
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//end try-catch

    //This module imputs an Employee Record
    //It then loads an Employee Object with entered Data
    //Finally it returns the loaded object for further processing
    public Employee getAnEmployee(){
        //Begin getAnEmployee

        Scanner kb =new Scanner(System.in);
        String first;   //First name of Employee
        String last;    //Last name of Employee
        String email;   //Email of Employee
        String phone;   //Phone number of Employee
        int empnum;     //Employee Number
        Employee emp;   //Employee Object to Return
        String informationCorrect; //User Response for correctness

        emp = new Employee();
        System.out.println("Get an Employee Record \n");
        System.out.println("This Module Inputs an Employee Record");

        System.out.println("Enter Employee ID: \n");
        empnum = kb.nextInt();

        System.out.println("Enter Employee First Name: \n");
        first = kb.next();

        System.out.println("Enter Employee Last Name: \n");
        last = kb.next();

        System.out.println("Enter Employee Email: \n");
        email = kb.next();

        System.out.println("Enter Employee Phone Number: \n");
        phone = kb.next();


        //Display Data User Entered for Verification

        System.out.println("The Following information was Entered: \n\n");

        System.out.println("Enter Employee ID: " + empnum);
        System.out.println("Enter Employee First Name: " + first);
        System.out.println("Enter Employee Last Name: " + last);
        System.out.println("Enter Employee Email: " + email);
        System.out.println("Enter Employee Phone Number: " + phone);

        System.out.println("\n Is the Information Correct? \n");
        System.out.println("Press Y to confirm information is correct");
        informationCorrect = kb.next();

        informationCorrect = informationCorrect.toUpperCase();

        //if the information is correct, load employee object with correct information

        if(informationCorrect.equals("Y")){

            emp.setEmployeeID(empnum);
            emp.setFirstName(first);
            emp.setLastName(last);
            emp.setEmail(email);
            emp.setPhoneNumber(phone);
        }
        return emp;
    }//end GetAnEmployee

    public void saveEmployees(){ //start saveEmployees Method
        // First item is First Name
        // Second Item is Last Name
        // Third Item is email
        // Fourth Item is Employee ID
        // Fifth Item is Phone number

        try{ //start try
            File file = new File("employeeData.txt");
            PrintWriter pw = new PrintWriter(file);
            int count = 0;

            String printLine = "";
            while (count < length){
                //start while
                Employee temp = null;
                printLine = "";
                new Employee();
                temp = this.list[count];
                printLine = printLine + temp.getFirstName() + ",";
                printLine = printLine + temp.getLastName() + ",";
                printLine = printLine + temp.getEmail() + ",";
                printLine = printLine + temp.getEmployeeID() + ",";
                printLine = printLine + temp.getPhoneNumber();

                pw.println(printLine);
                System.out.println(printLine);
                count++;

            }//end while
            pw.close();
        }//start catch
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }//end catch

    }//end save employees

    //Method SeqSearch
    public int seqSearch(Employee searchItem) {
        int loc;
        boolean found = false;
        for (loc = 0; loc < this.length; loc++)
            if (this.list[loc].equals(searchItem)) {
                found = true;
                break;
            }
        if (found)
            return loc;
        else
            return -1;
    }//end seq search

    //Start removeAt Method
    public void removeAt(int location){
        //if the location that was passed in is an invalid length
        //an error message is displayed

        if(location < 0 || location >= length){
            System.err.println("The location of the item to be removed is out of range");
        }//end if
        else{//start else
            //if the position passed is a valid integer within the range of possible index positions
            //the items below it shifted up one position in the array

            for(int i = location; i < length - 1; i++){
                list[i] = list[i + 1];
                list[length - 1] = null;
                length--;

            }
        }//end else
    }//End removeAt Method

    //start deleteEmployee
    public static void deleteEmployee(EmployeeManager em){
        System.out.println("Application to remove an Employee");
        Scanner kb = new Scanner(System.in);

        Employee emp;
        int empID;
        int position;
        String confirmation;

        //get employee ID to Delete
        System.out.println("What is the Employee ID that you would like to delete?");
        empID = kb.nextInt();

        emp = new Employee();
        emp.setEmployeeID(empID);
        position = em.seqSearch(emp);

        if(position >=0){
            System.out.println("Employee has been located\n");
            System.out.println("Are you sure you want to delete this Employee?");
            System.out.println("Enter Y to confirm: ");
            confirmation = kb.next();

            if (confirmation.toUpperCase().equals("Y")){
                em.removeAt(position);
            }//end if confirmation
        }//end if position
    }//end delete employee
}//end Employee manager
