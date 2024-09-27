package dao;

import entities.Contact;

import java.util.Iterator;
import java.util.List;

public class ContactManager {

    private List<Contact> contactList;

    public ContactManager(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return this.contactList;
    }

    public Contact searchContact(int idContact) {
        Iterator var3 = this.contactList.iterator();

        while(var3.hasNext()) {
            Contact contact = (Contact)var3.next();
            if (contact.getId() == idContact) {
                return contact;
            }
        }

        return null;
    }

    public void addContact(Contact newContact) {
        this.contactList.add(newContact);
    }

    public boolean removeContact(int idContato) {
        boolean contactRemoved = false;

        for(int i = 0; i < this.contactList.size(); ++i) {
            Contact contact = (Contact)this.contactList.get(i);
            if (contact.getId() == idContato) {
                this.contactList.remove(i);
                contactRemoved = true;
                break;
            }
        }

        return contactRemoved;
    }
    public void clear() {
        this.contactList.clear();
    }


}
