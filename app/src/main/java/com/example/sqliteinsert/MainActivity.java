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
    Button ShowData, addUser, btnUpdate, btnDelete;
    EditText editOldField, editUpdateField, editDel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context= getApplicationContext();
        Name= (EditText) findViewById(R.id.editName);
        Pass= (EditText) findViewById(R.id.editPass);
        editOldField = (EditText) findViewById(R.id.editText3);
        editUpdateField = (EditText) findViewById(R.id.editText5);
        editDel = (EditText) findViewById(R.id.editText6);
        ShowData= (Button) findViewById(R.id.button2);
        addUser= (Button) findViewById(R.id.button);
        btnUpdate = (Button) findViewById(R.id.button3);
        btnDelete = (Button) findViewById(R.id.button4);
        
        
        

        helper = new myDbAdapter(this);

        ShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowResultsActivity.class);
                startActivity(intent);
            }
        });

        //Button addUser = (Button) findViewById(R.id.button);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser(view, context);
            }
        });
        
        //ButtonUpdateUser
        btnUpdate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                try {
                    String oldField = editOldField.getText().toString();
                    String Update = editUpdateField.getText().toString();
                    helper.UpdateData(oldField, Update);
                    Toast.makeText(MainActivity.this, "Update Successful", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Update Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name = editDel.getText().toString();
                    helper.deleteData(name);
                    Toast.makeText(MainActivity.this, "Delete Successful", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "Delete Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
       

    }

    public void addUser(View view, Context context)
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
