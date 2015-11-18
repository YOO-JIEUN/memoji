package com.yoojieun.memoji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editMemo;
    private Button savebtn;
    private Button cancelbtn;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("editTitle", MODE_PRIVATE);
        pref = getSharedPreferences("editMemo", MODE_PRIVATE);
        editor = pref.edit();

        savebtn = (Button)findViewById(R.id.savebtn);
        cancelbtn = (Button)findViewById(R.id.cancelbtn);
        editTitle = (EditText)findViewById(R.id.editTitle);
        editMemo = (EditText)findViewById(R.id.editMemo);

        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String t = editTitle.getText().toString();
                String m = editMemo.getText().toString();

                editor.putString("editTitle", t);
                editor.putString("editMemo", m);
                editor.commit();

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String t = pref.getString("editTitle","");
        String m = pref.getString("editMemo", "");

        editTitle.setText(t);
        editMemo.setText(m);
    }

}
