package com.abc.BlindDate;

public class BlindDate {
    private com.abc.BlindDate.Person man;
    private com.abc.BlindDate.Person woman;
    private java.util.Date date;
    private boolean succeeded;
    private String place;
    public BlindDate(Person man, Person woman, boolean succeeded){
        this.man = man;
        this.woman = woman;
        this.succeeded = succeeded;
    }
    public void setPlace(java.lang.String place){this.place = place;}
    public void setDate(java.util.Date date){this.date = date;}
    public void setMan(Person man){this.man = man;}
    public void setWoman(Person woman){this.woman = woman;}
    public void setSucceeded(boolean succeeded){this.succeeded = succeeded;}
    public String getPlace(){return this.place;}
    public Person getWoman(){return this.woman;}
    public Person getMan(){return this.man;}
    public boolean getSuccess(){return this.succeeded;}
    public java.util.Date getDate(){return this.date;}
    public java.lang.String toString(){
        return man + "+" + woman + "is succeded? "+succeeded;
    }
}
