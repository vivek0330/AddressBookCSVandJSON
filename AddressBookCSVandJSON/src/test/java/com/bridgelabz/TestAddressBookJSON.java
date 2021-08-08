package com.bridgelabz;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class TestAddressBookJSON {
    @Test
    public void given3ContactsWhenWrittenToJSonFileShouldMatchContactEntries()
    {
        Contact nandu=new Contact("nandu","Poorna","nandu@gmail.com","America","Address","120012","Germany","+23-1234567890");
        Contact Lali=new Contact("Lali","Lakshmi","lali@gmail.com","New York City","Address","123456","New York","+12-9874563210");
        Contact satya=new Contact("Satya", "Nadela","satya@gmail.com","Los Angeles","Address","120546","California","+11-5463217890");
        List<Contact> contacts=Arrays.asList(new Contact[] {nandu, Lali, satya});
        AddressBookJSON addressBookJsonIOService=new AddressBookJSON("addressJSonTest.csv");
        addressBookJsonIOService.writeContactDetailsInAFile(contacts);
        List<Contact> readContacts=addressBookJsonIOService.readAddressBookFromAFile();
        assertEquals(nandu.toString(),readContacts.get(0).toString());
        assertEquals(Lali.toString(),readContacts.get(1).toString());
        assertEquals(satya.toString(),readContacts.get(2).toString());
    }
}
