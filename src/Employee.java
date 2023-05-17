//Start class Employee

//Employee.java
//inherits from Person
public class Employee extends Person{
    private int employeeID;
    private String email;
    private String phoneNumber;

    //no argument constructor
    public Employee(){
    }//end no argument constructor

    //three argument constructor
    public Employee(int id, String emailAddress, String phone){
        setEmployeeID(id);
        setEmail(emailAddress);
        setPhoneNumber(phone);
    }//end three argument constructor

    //sets the employee ID
    public void setEmployeeID(int id){
        employeeID = id;
    }//end method setEmployeeID

    //gets the EmployeeID
    public int getEmployeeID(){
        return employeeID;
    }//end getEmployeeID

    //sets the email
    public void setEmail(String emailAddress){
        email = emailAddress;
    }//end method setEmail

    //returns the Email
    public String getEmail(){
        return email;
    }//end getEmail

    //sets phone number
    public void setPhoneNumber(String phone){
        phoneNumber = phone;
    }//end method setPhoneNumber

    //returns phone number
    public String getPhoneNumber(){
        return phoneNumber;
    }//end getPhoneNumber method

    //returns current state of a instance of Employee
    public String toString(){
        String item = "";
        item = item + "Employee ID: " + employeeID + "\n";
        item = item + super.toString();
        item = item + "Email: " + email + "\n";
        item = item + "Phone: " + phoneNumber + "\n";
        item = item + "Employee ID" + employeeID + "\n";
        return item;
    }

    //compares 2 instances of an employee object
    //returned the ranking order based on employee id
    public int compareTO(Employee e){
        if(employeeID > e.employeeID) {
            return 1;
        } else
        if (employeeID < e.employeeID) {
            return -1;
        } else
            return 0;
    }

    //compares 2 instances of an employee object
    //returns equality based on employeeID
    public boolean equals(Employee e){
        return (employeeID == e.employeeID);
    }//End equals method
}//End Employee class
