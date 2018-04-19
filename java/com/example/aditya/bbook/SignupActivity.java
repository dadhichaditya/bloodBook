package com.example.aditya.bbook;

/**
 * Created by aditya on 29/3/18.
 */
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    //  private static final String TAG = "SignupActivity";
    EditText _nameText, _emailText, _passwordText, _contact, _bloodgrp, _dob;
    Button _signupButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mydb = new DatabaseHelper(this);
        final EditText _nameText = (EditText) findViewById(R.id.input_name);
        final EditText _emailText = (EditText) findViewById(R.id.input_email);
        final EditText _passwordText = (EditText) findViewById(R.id.input_password);
        Button _signupButton = (Button) findViewById(R.id.btn_signup);
        final EditText _contact = (EditText) findViewById(R.id.contact);
        final EditText _bloodgrp = (EditText) findViewById(R.id.bloodgrp);
        final EditText _dob = (EditText) findViewById(R.id.dob);


        _signupButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = mydb.insertData(_nameText.getText().toString(), _emailText.getText().toString(), _passwordText.getText().toString(), _contact.getText().toString(), _bloodgrp.getText().toString(), _dob.getText().toString());
                        if (isInserted) {
                            Toast.makeText(SignupActivity.this, "Inserted Succesfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SignupActivity.this, "Insertion Failed...", Toast.LENGTH_LONG).show();

                        }
                        Cursor res = mydb.getData();
                        if(res.getCount()==0)
                        {
                            //show message
                            showmessage("ERROR","NO DATA FOUND");
                        }
                        else
                        {
                            StringBuffer buffer = new StringBuffer();
                            while(res.moveToNext())
                            {
                                buffer.append("Id : "+res.getString(0)+"\n");
                                buffer.append("Name : "+res.getString(1)+"\n");
                                buffer.append("Email : "+res.getString(2)+"\n");
                                buffer.append("Password : "+res.getString(3)+"\n");
                                buffer.append("Contact : "+res.getString(4)+"\n");
                                buffer.append("Blood group : "+res.getString(5)+"\n");
                                buffer.append("DOB : "+res.getString(6)+"\n\n");
                            }
                            showmessage("Data",buffer.toString());
                        }

                    }
                }
        );



    }
    public void showmessage(String Title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(message);
        builder.show();
    }
}