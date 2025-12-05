package edu.loyola.cs485.model.entity;

public class Stage extends AbstractEntity{

    private Integer ID;
    private String Name;
    private String Size;
    private String Layout;

    public Integer getID(){
        return ID;
    }

    public void setID(Integer ID){
        this.ID = ID;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getSize(){
        return Size;
    }

    public void setSize(String Size){
        this.Size = Size;
    }

    public String getLayout(){
        return Layout;
    }

    public void setLayout(String Layout){
        this.Layout = Layout;
    }

    @Override
    public String toString(){
        return getID().toString()+": "+getName()+" <"+getSize()+"> <"+getLayout()+">";
    }

}
