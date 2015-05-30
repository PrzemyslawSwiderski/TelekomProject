package com.tele5;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CzasTokio extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.czas_tokio);
	getCzas();
	Button odswiezPrzycisk = (Button) findViewById(R.id.odswiezButton);
	odswiezPrzycisk.setOnClickListener(new View.OnClickListener()
	{

	    @Override
	    public void onClick(View v)
	    {
		getCzas();
	    }
	});
    }

    private void getCzas()
    {
	String stringUrl = "http://24timezones.com/pl_czas/tokyo_czas_lokalny.php";

	TextView t = (TextView) findViewById(R.id.textView2);

	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	Document doc = null;
	try
	{
	    doc = Jsoup.connect(stringUrl).get();
	} catch (IOException e1)
	{
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	if (networkInfo != null && networkInfo.isConnected())
	{
	    t.setText(doc.select("#currentTime").text());

	} else
	{
	    t.setText("Nie mozna polaczyc z siecia.");
	}
    }
}
