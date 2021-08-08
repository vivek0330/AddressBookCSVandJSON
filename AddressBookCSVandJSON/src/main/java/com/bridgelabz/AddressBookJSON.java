package com.bridgelabz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;


public class AddressBookJSON {
    public String addressJsonFileName;

    public AddressBookJSON(String addressBookJsonFileName) {
        super();
        this.addressJsonFileName = addressBookJsonFileName;
    }

    public void writeContactDetailsInAFile(List<Contact> list) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            FileWriter writer = new FileWriter(this.addressJsonFileName);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Contact> readAddressBookFromAFile() {
        List<Contact> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.addressJsonFileName));
            Contact[] contactsArray = gson.fromJson(bufferedReader, Contact[].class);
            list = new LinkedList<Contact>(Arrays.asList(contactsArray));
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
