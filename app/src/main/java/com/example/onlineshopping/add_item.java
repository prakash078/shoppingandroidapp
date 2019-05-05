package com.example.onlineshopping;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class add_item extends AppCompatActivity {

    EditText itemName,itemPrice,itemImageName,itemDesc;
    Button btnAddItem;

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Add Item");

        itemName=findViewById(R.id.inputItemName);
        itemPrice=findViewById(R.id.inputItemPrice);
        itemImageName=findViewById(R.id.inputItemImageName);
        itemDesc=findViewById(R.id.inputItemDescription);
        btnAddItem=findViewById(R.id.addItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(itemName.getText().toString()))
                {
                    itemName.setError("Please enter item name");
                    itemName.requestFocus();
                }
                else if(TextUtils.isEmpty(itemPrice.getText().toString()))
                {
                    itemPrice.setError("Please enter price of the item");
                    itemPrice.requestFocus();
                }
                else if(TextUtils.isEmpty(itemImageName.getText().toString()))
                {
                    itemImageName.setError("Please enter image name of the item");
                    itemImageName.requestFocus();
                }
                else if (TextUtils.isEmpty(itemDesc.getText().toString()))
                {
                    itemDesc.setError("Please enter item description");
                    itemDesc.requestFocus();
                }
                else
                {
                    Save();
                }
            }
        });

    }

    private void Save()
    {
        try {
            PrintStream printStream=new PrintStream(openFileOutput("items.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(itemName.getText().toString()+"->"+itemPrice.getText().toString()+"->"
            +itemImageName.getText().toString()+"->"+itemDesc.getText().toString());
            Toast.makeText(this, "Item saved to "+getFilesDir(), Toast.LENGTH_SHORT).show();
            itemName.setText("");
            itemPrice.setText("");
            itemImageName.setText("");
            itemDesc.setText("");
        } catch (FileNotFoundException e) {
            Log.d("Shopping App","Error" +e.toString());
            e.printStackTrace();
        }

    }
}
