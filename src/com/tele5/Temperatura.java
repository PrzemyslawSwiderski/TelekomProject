package com.tele5;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Temperatura extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.temperatura);

	String stringUrl = "http://www.meteoprog.pl/pl/weather/Warszawa/";

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
	    t.setText(doc
		    .select("body > div > div.main > div.center > div.leftPart.floatL > div.weatherInCity.weatherInCityMain.floatL > div.blockWeather > div.actualitem.actualday.actualdayTabs > div.actualdayWrapper.active > div:nth-child(1) > div > div.detailWeather.floatL > div.temp")
		    .text());

	} else
	{
	    t.setText("Nie mozna polaczyc z siecia.");
	}

    }
}
