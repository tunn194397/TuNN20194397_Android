package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler dbHandler;
    SQLiteDatabase db;
    private AppBarConfiguration appBarConfiguration;
    ListView studentListView;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListView = findViewById(R.id.student_list);
        String[] columns = {"id", "name", "email", "phone", "address", "birthday"};
        Cursor cs = db.query("student", columns,null, null, null, null ,null);
        adapter = new StudentAdapter(cs, this);
        studentListView.setAdapter(adapter);

        // Open DB

        String path = getFilesDir() + "/mydb";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
            //dbHandler.onCreate(db);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Create DB
        createTable();
    }
    public void createTable() {
        db.beginTransaction();
        try {
            try {
                Faker faker = new Faker();
                for (int i = 0; i < 10; i++) {
                    String id = faker.number.number(8);
                    String name = faker.name.name();
                    String phone = faker.phoneNumber.phoneNumber();
                    String email = faker.internet.email();
                    String address = faker.address.streetAddress();
                    String birthday = (faker.date.birthday(16, 16)).toString();
                    dbHandler.addStudent(new Student(id, name, phone, email, address, birthday));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                db.setTransactionSuccessful();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }

}