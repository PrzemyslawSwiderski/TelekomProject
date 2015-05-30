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

public class Onet extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.onet);
	
	String stringUrl = "http://www.onet.pl/";
	
	ListView l = (ListView) findViewById(R.id.ListView2);

	ArrayAdapter<String> a = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1);

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
	    a.add("Polaczono");
	    a.add("\n");
	    a.add(doc.title());
	    a.add("\n");
	    Elements newsHeadlines = doc.select("#boxNews > article > section:nth-child(1) .title");
	    for (Element elem : newsHeadlines)
	    {
		a.add(elem.text());
	    }
	} else
	{
	    a.add("Nie mozna polaczyc z siecia.");
	}

	l.setAdapter(a);
    }
}
