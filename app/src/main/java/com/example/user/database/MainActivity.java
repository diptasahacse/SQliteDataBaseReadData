package com.example.user.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    StringBuffer stringBuffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textid);

        DataBase dataBase = new DataBase(this);

        SQLiteDatabase data = dataBase.getReadableDatabase();

        Cursor cursor = data.rawQuery("SELECT * FROM PRODUCTS",null);

        if (cursor!= null)
        {
            cursor.moveToFirst();
        }

        do {
            String id = cursor.getString(0);
            String name = cursor.getString(1);;
            String des = cursor.getString(2);;
            String price = cursor.getString(3);;


            stringBuffer.append("ID  ="+id+"\n");
            stringBuffer.append("NAME  ="+name+"\n");
            stringBuffer.append("DES  ="+des+"\n");
            stringBuffer.append("PRICE  ="+price+"\n\n");
        }

        while (cursor.moveToNext());



    }

    public void Click(View view) {

        textView.setText(stringBuffer.toString());

    }
}
