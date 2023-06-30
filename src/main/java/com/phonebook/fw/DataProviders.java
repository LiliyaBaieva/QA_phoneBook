package com.phonebook.fw;

import com.phonebook.model.Contact;
import java.io.FileNotFoundException;
import java.sql.Array;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
  @DataProvider
  public Iterator<Object[]> addContactFromCsvFile() throws IOException {
    List<Object[]> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(new File(
        "src/test/resources/contact.csv"
    )));
     String line = reader.readLine();

     while(line != null ){
       String[] split = line.split(",");
       list.add(new Object[]{new Contact().setName(split[0]).setSecondName(split[1])
           .setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
       line = reader.readLine();
     }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> addContactFromCsvFileNegative() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(
        new File("src/test/resources/contact_negative.csv")));
    List<Object[]> list = new ArrayList<>();
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(",");
      list.add(new Object[]{new Contact()
          .setName(split[0])
          .setSecondName(split[1])
          .setPhone(split[2])
          .setEmail(split[3])
          .setAddress(split[4])
          .setDescription(split[5])
      });
      line = reader.readLine();
    }
    return list.listIterator();
  }
}
