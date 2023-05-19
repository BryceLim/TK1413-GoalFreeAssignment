public class Person {

    String name;
    String email;
    String contact;

    public Person(String nm, String eml, String ct){
        name = nm;
        email = eml;
        contact = ct;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getContact(){
        return contact;
    }
    
}
