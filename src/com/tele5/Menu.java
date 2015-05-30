package com.tele5;

import com.tele5.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button wikipediaPrzycisk = (Button)findViewById(R.id.wikipediaPrzycisk);
        wikipediaPrzycisk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Menu.this, Wikipedia.class);
				startActivity(intent);
			}
		});
        
        Button autorzyPrzycisk = (Button)findViewById(R.id.autorzyPrzycisk);
        autorzyPrzycisk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Menu.this, Autorzy.class);
				startActivity(intent);
			}
		});
        
        Button onetPrzycisk = (Button)findViewById(R.id.onetPrzycisk);
        onetPrzycisk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Menu.this, Onet.class);
				startActivity(intent);
			}
		});
        
        Button tempPrzycisk = (Button)findViewById(R.id.temp_warszawaPrzycisk);
        tempPrzycisk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Menu.this, Temperatura.class);
				startActivity(intent);
			}
		});
        Button czasPrzycisk = (Button)findViewById(R.id.czasTokioPrzycisk);
        czasPrzycisk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Menu.this, CzasTokio.class);
				startActivity(intent);
			}
		});
    }
}