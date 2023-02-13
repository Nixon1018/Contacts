package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Contacts
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
class  Contactop{
    Contacts head=null;
    Contacts current=null;
    Contacts prev=null;
    private static final Logger logger = Logger.getLogger("InfoLogging");
    void add(String name,long phonenumber,String emailaddress)
    {
        Contacts newcontact = new Contacts(name,phonenumber,emailaddress);
        if(this.head==null)
        {
            this.head=newcontact;
        }
        else
        {
            this.current=this.head;
            while (current.nextnode!=null)
            {
                current=current.nextnode;
            }
            current.nextnode=newcontact;
        }
    }
    void remove()
    {
        if(this.head==null)
        {
            logger.info("The contact list is empty");
        }
        else
        {
            this.current=this.head;
            while (current.nextnode!=null)
            {
                prev = current;
                current=current.nextnode;
            }
            prev.nextnode=null;
        }
    }
    void search(String name)
    {
        if(this.head==null)
        {
            logger.info("The contact list is empty");
        }
        else {
            this.current=head;
            while(current.name.equals(name)){

                String z="Match found:"+current.name+" "+current.phonenumber+" "+current.emailaddress;
                logger.info(z);
                if(current.nextnode!=null) {
                    current = current.nextnode;
                }
                break;
            }
        }
    }
}
public class Main {
    private static final Logger logger = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        int n=1;
        Scanner sc= new Scanner(System.in);
        Contactop list = new Contactop();
        while (n==1)
        {
            logger.info("1.add 2.remove 3.search 4.exit");
            int c= sc.nextInt();
            if(c==1)
            {
                logger.info("Enter the name:");
                String name= sc.next();
                logger.info("Enter the phonenumber:");
                long phonenumber= sc.nextLong();
                logger.info("Enter the email Id:");
                String id =sc.next();
                list.add(name,phonenumber,id);
            }
            else if(c==2)
            {
                list.remove();
            }
            else if(c==3)
            {
                logger.info("Enter the name to be searched:");
                String name=sc.next();
                list.search(name);

            } else if (c==4) {
                n=0;

            }
        }

    }
}