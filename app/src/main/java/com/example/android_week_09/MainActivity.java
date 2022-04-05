package com.example.android_week_09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static DatabaseHandlerList databaseHandlerList;
    private static AdapterView<ListAdapter> listView;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         databaseHandlerList = new DatabaseHandlerList(this);
        context = this;


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
    public static void loadListView(){
        List<Person> persons = databaseHandlerList.getPersons();

//        for (Person cn : persons) {
//            String log = "NAME: " + cn ;
//            // Writing Contacts to log
//            Log.d("LOG: ", log);
//        }
        ListAdapter listAdapter = new ListAdapter(persons, R.layout.activity_item_adapterd,context);
        listView.setAdapter(listAdapter);

    }
}