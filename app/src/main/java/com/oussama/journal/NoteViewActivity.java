package com.oussama.journal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * created by oussama ben hmida 29/06/2018
 */

public class NoteViewActivity extends AppCompatActivity {

    public static SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_view);

        EditText titleview=(EditText)findViewById(R.id.title_view);
       EditText textview=(EditText)findViewById(R.id.text_view);

        String sub_id = getIntent().getStringExtra("id");
        String title=getIntent().getStringExtra("title");
        String text=getIntent().getStringExtra("text");
        titleview.setText(title);
        textview.setText(text);



    }

    public void updatefct(View view) {
        EditText titleview=(EditText)findViewById(R.id.title_view);
        EditText textview=(EditText)findViewById(R.id.text_view);
        String sub_id = getIntent().getStringExtra("id");
        String title=titleview.getText().toString();
        String text=textview.getText().toString();
        ExampleDBHelper db=new ExampleDBHelper(getApplicationContext());
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        if ( text.length() == 0 ||title.length() == 0 ){
            Toast.makeText(getApplicationContext(), "title or text box is empty !!!",
                    Toast.LENGTH_SHORT).show();}
            else {
                if(db.updateNote(sub_id,title,text)){
            Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG)
                    .show();
            Intent i = new Intent(NoteViewActivity.this, MainActivity.class);

            startActivity(i);
        }

            }


}}