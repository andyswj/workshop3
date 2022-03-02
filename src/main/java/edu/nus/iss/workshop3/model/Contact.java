package edu.nus.iss.workshop3.model;

import java.io.Serializable;
import java.util.Random;

//Contact class representing the contact information

public class Contact implements Serializable{ //Serializable to generate the serialVersionUID
    private String name;
    private String email;
    private int phoneNumber;
    private String id;

    public Contact() {
            this.id = generateId(8);
    }

    public Contact(String id, String name, String email, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String email, int phoneNumber) {
        this.id = generateId(8);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //Method to generate the ID
    private synchronized String generateId(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer(); //Can use StringBuilder
        while(sb.length() < numchars){
                sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
            this.name = name;
    }

    public String getEmail(){
            return this.email;
    }   

    public void setEmail(String email){
            this.email = email;
    }

    public int getPhoneNumber(){
            return this.phoneNumber;
    }   

    public void setPhoneNumber(int phoneNumber){
            this.phoneNumber = phoneNumber;
    }

    public String getId(){
            return this.id;
    }   

    public void setId(String id){
            this.id = id;
    }

}
