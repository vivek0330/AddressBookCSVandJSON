package com.bridgelabz;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestAddressBookCSV {
    @Test
    public void given3ContactsWhenWrittenToCSVFileShouldMatchContactEntries() {
        Contact jeff = new Contact("nandu", "Poorna", "nandu@gmail.com", "America", "Address", "120012", "Germany", "+23-1234567890");
        Contact mark = new Contact("Lali", "Lakshmi", "lali@gmail.com", "New York City", "Address", "123456", "New York", "+12-9874563210");
        Contact satya = new Contact("Satya", "Nadela", "satya@gmail.com", "Los Angeles", "Address", "120546", "California", "+11-5463217890");
        List<Contact> contacts = Arrays.asList(new Contact[]{jeff, mark, satya});
        AddressBookCSV addressBookCSVIOService = new AddressBookCSV("addressCsvTest.csv");
        addressBookCSVIOService.writeContactDetailsInAFile(contacts);
        List<Contact> readContacts = addressBookCSVIOService.readAddressBookFromAFile();
        assertEquals(jeff.toString(), readContacts.get(0).toString());
        assertEquals(mark.toString(), readContacts.get(1).toString());
        assertEquals(satya.toString(), readContacts.get(2).toString());
    }
}
