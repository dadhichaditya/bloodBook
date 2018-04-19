package com.example.aditya.bbook;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

public class SeekActivity extends AppCompatActivity {
    EditText blood_grp,units;
    Button seek;
    String bl_gr,uni;
    MapsActivity map_instance;
    GoogleMap mMap;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek2);
        mydb = new DatabaseHelper(this);
        blood_grp = (EditText) findViewById(R.id.editText1);
        units = (EditText) findViewById(R.id.editText2);
        seek = (Button) findViewById(R.id.seek);
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bl_gr = blood_grp.getText().toString();
                uni = units.getText().toString();
                Toast.makeText(SeekActivity.this, "Request added", Toast.LENGTH_LONG).show();
//                Boolean done=mydb.insertseeker(blood_grp.getText().toString(), Integer.parseInt(units.getText().toString()));
//                if(done) {
                    Toast.makeText(SeekActivity.this, "Request added", Toast.LENGTH_LONG).show();
//                }

//                Cursor res1 = mydb.getseekerdata();
//                if(res1.getCount()==0)
//                {
//                    //show message
//                    showmessage("ERROR","NO DATA FOUND");
//                }
//                else
//                {
//                    StringBuffer buffer = new StringBuffer();
//                    while(res1.moveToNext())
//                    {
//                        buffer.append("Blood Group : "+res1.getString(0)+"\n");
//                        buffer.append("Units : "+res1.getString(1)+"\n\n");
//
//                    }
//                    showmessage("Data",buffer.toString());
//                }
//
            }
        });


    }
    public void showmessage(String Title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(message);
        builder.show();
    }

}
