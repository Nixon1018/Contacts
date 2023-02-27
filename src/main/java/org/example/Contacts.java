package org.example;

public class Contacts
{
    String name;
    long phonenumber;
    String emailaddress;
    Contacts nextnode;
    Contacts(String name,long phonenumber,String emailaddress)
    {
        this.name=name;
        this.phonenumber=phonenumber;
        this.emailaddress=emailaddress;
    }
}