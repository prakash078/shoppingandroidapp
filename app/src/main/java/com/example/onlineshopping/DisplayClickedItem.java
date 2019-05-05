package com.example.onlineshopping;

import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayClickedItem extends AppCompatActivity {

    TextView itemName,itemPrice,itemDesc;
    ActionBar actionBar;
    ImageView iImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_clicked_item);

        itemName=findViewById(R.id.displayItemName);
        itemPrice=findViewById(R.id.displayItemPrice);
        itemDesc=findViewById(R.id.displayItemDesc);
        iImageView=findViewById(R.id.displayItemImage);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Description of Item");

        Bundle bundle=getIntent().getExtras();

        if(bundle != null)
        {
            itemName.setText(bundle.getString("name"));
            itemPrice.setText(bundle.getString("price"));
            itemDesc.setText(bundle.getString("desc"));
            iImageView.setImageResource(bundle.getInt("image"));
        }
    }

}
