package com.example.bai2_myemailbox;

import java.util.ArrayList;
import java.util.Collections;

public class EmailUtils {
    public static ArrayList<Email> getEmails()  {
        Email em1 = new Email(0,"James", "Smith", "Receptionist", "20:00 PM", "james.jpg", true, false);
        Email em2 = new Email(1,"Google", "Learning", "Hello, Tu", "05:00 AM", "google.jpg", false, true);
        Email em3 = new Email(2,"Riot Games", "Entertainment", "GGG", "08:17 AM", "riot.jpg", false, true);
        Email em4 = new Email(3,"Leetcode", "Learning", "Receptionist", "20:03 PM", "leetcode.jpg", true, false);
        Email em5 = new Email(4,"Hackthebox", "Learning", "Receptionist", "15:06 PM", "hackthebox.jpg", true, false);
        Email em6 = new Email(5,"Blockchain", "Learning", "Receptionist", "08:55 AM", "james.jpg", true, false);
        Email em7 = new Email(6,"CareHealthy", "Healthy", "Receptionist", "12:20 PM", "james.jpg", true, true);
        Email em8 = new Email(7,"Youtube", "Entertainment", "Receptionist", "00:50 AM", "james.jpg", false, false);
        Email em9 = new Email(8,"Facebook", "Entertainment", "Receptionist", "18:23 PM", "james.jpg", false, true);
        Email em10 = new Email(9,"Google", "Learning", "Receptionist", "20:07 PM", "james.jpg", true, true);
        Email em11 = new Email(10,"Google", "Learning", "Receptionist", "21:37 PM", "james.jpg", false, true);

        Email[] emailArray = new Email[]{em1, em2, em3, em4, em5, em6, em7, em8, em9, em10, em11};
        ArrayList<Email> emails = new ArrayList<>();
        Collections.addAll(emails, emailArray);
        return emails;
    }

}
