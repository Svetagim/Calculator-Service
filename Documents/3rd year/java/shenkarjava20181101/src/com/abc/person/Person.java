package com.abc.person;

public class Person
{
    private int id;
    private String firstName;
    private String lastName;
    public Person(int id, String firstName, String lastName)
    {
        super();
        this.id = id;
        //this.firstName = firstName;
        //this.lastName = lastName;
        setFirstName(firstName);
        setLastName(lastName);
    }


    public Person(int id)
    {
        super();
        this.id = id;
        //this.firstName = firstName;
        //this.lastName = lastName;
        setFirstName("No Name");
        setLastName("No Name");
    }

    public Person(int id, String firstName)
    {
        super();
        this.id = id;
        //this.firstName = firstName;
        //this.lastName = lastName;
        setFirstName(firstName);
        setLastName("No Name");
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        if(firstName!=null)
        {
            this.firstName = firstName;
        }
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        if(lastName!=null)
        {
            this.lastName = lastName;
        }
    }
    public int getId()
    {
        return id;
    }
    public String toString()
    {
        return (firstName+" "+lastName);
    }
}

