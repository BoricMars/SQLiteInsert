package com.example.sqliteinsert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Pass;
    myDbAdapter helper;
    Context context;
    Button ShowData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editName);
        Pass= (EditText) findViewById(R.id.editPass);
        ShowData= (Button) findViewById(R.id.button2);
        helper = new myDbAdapter(this);

        ShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowResultsActivity.class);
                startActivity(intent);
            }
        });

        Button addUser = (Button) findViewById(R.id.button);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser(view);
            }
        });
    }

    public void addUser(View view)
    {
        Toast.makeText(this,"Running", Toast.LENGTH_LONG).show();
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        long identity = helper.insertData(t1,t2);
        if(identity<0)
        {
            Message.message(this,"Unsuccessful");
        } else
        {
            Message.message(this,"Successful");
        }
    }
}
