package com.bridgelabz;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSV {
    public String addressBookCsvName;

    public AddressBookCSV(String addressBookCsvName)
    {
        super();
        this.addressBookCsvName = addressBookCsvName;
    }

    public void writeContactDetailsInAFile(List<Contact> contacts)
    {
        try (Writer writer = Files.newBufferedWriter(Paths.get(this.addressBookCsvName));)
        {
            StatefulBeanToCsv<Contact> beanToCSV = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            beanToCSV.write(contacts);
        }
        catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public List<Contact> readAddressBookFromAFile()
    {
        List<Contact> list = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(this.addressBookCsvName));)
        {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> contactStrings = csvReader.readAll();
            contactStrings.remove(0);
            contactStrings.stream().forEach(contactsArray -> {
                String firstName = contactsArray[3];
                String lastName = contactsArray[4];

                String email = contactsArray[2];

                String city = contactsArray[1];

                String address = contactsArray[0];

                String zip = contactsArray[7];

                String state = contactsArray[6];

                String phone = contactsArray[5];
                Contact contactObj = new Contact(firstName, lastName,email, city,address, zip,state, phone);
                list.add(contactObj);
            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
