package Phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Karl", "Adams", "1234567890", "adam@gm.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Karl1", "Adams", "12345678901", "adam@gm.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Karl2", "Adams", "123456789012345", "adam@gm.com", "Berlin", "goalkeeper"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFormCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
