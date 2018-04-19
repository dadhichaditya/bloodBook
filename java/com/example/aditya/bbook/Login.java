package com.example.aditya.bbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aditya on 14/4/18.
 */

public class Login extends AppCompatActivity {
    EditText memail,mpassword;
    Button login_btn,signup_btn;
    DatabaseHelper mydb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText memail = (EditText)findViewById(R.id.input_email);
        final EditText mpassword = (EditText)findViewById(R.id.input_password);
        Button login_btn =(Button)findViewById(R.id.login_btn);
        Button signup_btn = (Button)findViewById(R.id.btn_signup);
        mydb = new DatabaseHelper(this);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(attemptlogin(memail.getText().toString(),mpassword.getText().toString())==true)
                {
                    Intent map_intent= new Intent(Login.this,MapsActivity.class);
                    startActivity(map_intent);
                }

            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignupActivity.class);
                startActivity(intent);

            }
        });


    }
    public Boolean  attemptlogin(String email, String password)
    {   Boolean bool = null;
        int error = isLoginValid(email,password);
        if(error==0)
        {   bool=false;
            Toast.makeText(Login.this,"Login Credentials not found..",Toast.LENGTH_LONG).show();
        }
        if(error==1)
        {   bool=true;
            Toast.makeText(Login.this,"Login Succesfull",Toast.LENGTH_LONG).show();

        }
        if(error==2)
        {   bool=false;
            Toast.makeText(Login.this,"Incorrect Password",Toast.LENGTH_LONG).show();

        }
        return bool;

    }

    public int isLoginValid(String email, String password)
    {

//        Cursor user = mydb.checkLogin(email, password);
//        if(user.getCount()==0)
//        {
//            return 0;
//        }
//        while(user.moveToNext()) {
//            if (password.compareTo(user.getString(3))==0) {
//                return 1;//success
//            } else {
//                return 2;
//            }
//        }

    return 1;
    }
//    public void showmessage(String Title, String message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(Title);
//        builder.setMessage(message);
//        builder.show();
//    }
}
