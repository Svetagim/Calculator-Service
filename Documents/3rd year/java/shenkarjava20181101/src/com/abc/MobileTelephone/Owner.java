package com.abc.MobileTelephone;

public class Owner {
    public Owner(String name, long id) {
        this.name = name;
        this.id = id;
    }

    private java.lang.String name;
    private long id;
    private MobileTelephone mobileTelephone;

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", mobileTelephone=" + mobileTelephone +
                '}';
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void details(){
        System.out.println(this);
    }
}
