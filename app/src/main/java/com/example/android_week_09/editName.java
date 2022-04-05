package com.example.android_week_09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        Person person = (Person) getIntent().getSerializableExtra("person");
        EditText editText = findViewById(R.id.nameEdit);
        Button button = findViewById(R.id.update);
        editText.setText(person.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setName(editText.getText().toString());
                MainActivity.databaseHandlerList.updatePerson(person);
                onBackPressed();
                MainActivity.loadListView();
            }
        });

    }
}