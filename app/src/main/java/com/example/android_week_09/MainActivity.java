package com.example.android_week_09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private    ListView listView;
    private DatabaseHandlerList databaseHandlerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         databaseHandlerList = new DatabaseHandlerList(this);
//
//        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
//        db.addContact(new Contact("Tommy", "9522222222"));
//        db.addContact(new Contact("Karthik", "9533333333"));
//
//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<Contact> contacts = db.getAllContacts();
//
//        for (Contact cn : contacts) {
//            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
//                    cn.getPhoneNumber();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }

         listView = findViewById(R.id.listView);
        EditText  name = findViewById(R.id.editTextTextPersonName);
        Button addBtn = findViewById(R.id.save);
//        Button removeBtn = findViewById(R.id.remove);
        Button cancelBtn = findViewById(R.id.cancel);

        loadListView();


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHandlerList.addPerson(name.getText().toString());
                loadListView();
            }
        });

    }
    public  void loadListView( ){
        List<Person> persons = databaseHandlerList.getPersons();

//        for (Person cn : persons) {
//            String log = "NAME: " + cn ;
//            // Writing Contacts to log
//            Log.d("LOG: ", log);
//        }
        ListAdapter listAdapter = new ListAdapter(persons, R.layout.activity_item_adapterd,this);
        listView.setAdapter(listAdapter);

    }
}