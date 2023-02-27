package org.example;

import java.util.logging.Logger;

public class  Contactop{
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
            this.current=this.head;
            while(current!=null){
                if(current.name.equals(name)) {
                    String z="Match found:"+current.name+" "+current.phonenumber+" "+current.emailaddress;
                    logger.info(z);
                }
                current = current.nextnode;
            }
        }
    }
}
