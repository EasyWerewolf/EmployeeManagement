//start Class Person
public class Person {

    private String firstName;
    private String lastName;

    //no argument constructor
    public Person() {

    }//end no argument constructor

    //two argument constructor
    public Person(String first, String last){
        setFirstName(first);
        setLastName(last);
    }//end two argument constructor

    //sets the first name
    public void setFirstName (String first){
        firstName = first;
    }//end method setFirstName

    //returns the first name
    public String getFirstName(){
        return firstName;
    }//end method getFirstName

    //sets last name
    public void setLastName(String last){
        lastName = last;
    }//end method setLastName

    //returns last name
    public String getLastName(){
        return lastName;
    }//end method getLastName

    //returns the state of a Person Object
    public String toString(){
        String item = "";
        item = item + "First Name: " + firstName + "\n";
        item = item + "Last Name: " + lastName + "\n";
        return item;
    }//end method toString

    //determines if two person object contain the same information
    public boolean equals(Person p){
        return (firstName.equals(p.firstName) && lastName.equals(p.lastName));
    }

    public int compareTo(Person p){
        String item1 = lastName + firstName;
        String item2 = p.lastName + p.firstName;
        return item1.compareTo(item2);
    }

}//end class Person
