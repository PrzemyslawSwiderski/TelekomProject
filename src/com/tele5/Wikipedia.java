package com.tele5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Wikipedia extends Activity
{

    // Vector<wikipedia> wszystkieWaluty = new Vector<wikipedia>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

	super.onCreate(savedInstanceState);
	setContentView(R.layout.wikipedia);
	String stringUrl = "http://en.wikipedia.org/wiki/Main_Page";
	ListView l = (ListView) findViewById(R.id.ListView01);

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
	    a.add("News:");
	    a.add("\n");
	    Elements newsHeadlines = doc.select("#mp-itn");
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
