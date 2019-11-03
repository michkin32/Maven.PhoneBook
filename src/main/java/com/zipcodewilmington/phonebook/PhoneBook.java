package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    public static final Logger logger = Logger.getGlobal();

    Map<String, List<String>> phoneBook = new HashMap<>();
    Map<String, List<String>> dependency = new HashMap<>();
    public PhoneBook(Map<String, List<String>> map) {
        dependency = map;
    }

    public PhoneBook() {


    }

    public void add(String name, String phoneNumber) {
        phoneBook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phoneBook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        Boolean entry = phoneBook.containsKey(name);
        return entry;
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String phoneName = "";
        for (String name :phoneBook.keySet()){
            if (phoneBook.get(name).contains(phoneNumber)){
                 phoneName = name;
        }

        }
       return phoneName;
    }

    public ArrayList getAllContactNames() {
        ArrayList allContacts = new ArrayList();
        allContacts.addAll(phoneBook.keySet());

       Collections.sort(allContacts);
        //logger.info();
        return allContacts;
    }

    public Map<String, List<String>> getMap() {
        return phoneBook;
    }
}
