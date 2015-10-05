package com.example.listex;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONConnector {
	
	static int CONNECTION_TIMEOUT = 5;
	static int READ_TIMEOUT = 5;
	
	public static JSONObject connect_object(String url_string, String query_string) throws IOException, JSONException {
		HttpURLConnection   conn    = null;
		 
		OutputStream          os   = null;
		InputStream           is   = null;
		ByteArrayOutputStream baos = null;
		JSONObject responseJSON = null;
		
		URL url = new URL(url_string);
		
		conn = (HttpURLConnection)url.openConnection(); 
		conn.setConnectTimeout(CONNECTION_TIMEOUT * 1000);
		conn.setReadTimeout(READ_TIMEOUT * 1000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setDefaultUseCaches(false);
		 
		os = conn.getOutputStream();
		os.write(query_string.getBytes());
		os.flush();
		os.close();
		 
		String response;
		 
		int responseCode = conn.getResponseCode();
		 
		if(responseCode == HttpURLConnection.HTTP_OK) {
		 
		    is = conn.getInputStream();
		    baos = new ByteArrayOutputStream();
		    byte[] byteBuffer = new byte[1024];
		    byte[] byteData = null;
		    int nLength = 0;
		    while((nLength = is.read(byteBuffer, 0, byteBuffer.length)) != -1) {
		        baos.write(byteBuffer, 0, nLength);
		    }
		    byteData = baos.toByteArray();
		     
		    response = new String(byteData);
		     
		    responseJSON = new JSONObject(response);
		     
		}
		
		return responseJSON;

		
	}
	
	public static JSONArray connect_array(String url_string, String query_string) throws IOException, JSONException {
		HttpURLConnection   conn    = null;
		 
		OutputStream          os   = null;
		InputStream           is   = null;
		ByteArrayOutputStream baos = null;
		JSONArray responseJSON = null;
		
		URL url = new URL(url_string);
		
		conn = (HttpURLConnection)url.openConnection(); 
		conn.setConnectTimeout(CONNECTION_TIMEOUT * 1000);
		conn.setReadTimeout(READ_TIMEOUT * 1000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setDefaultUseCaches(false);
		 
		os = conn.getOutputStream();
		os.write(query_string.getBytes());
		os.flush();
		os.close();
		 
		String response;
		 
		int responseCode = conn.getResponseCode();
		 
		if(responseCode == HttpURLConnection.HTTP_OK) {
		 
		    is = conn.getInputStream();
		    baos = new ByteArrayOutputStream();
		    byte[] byteBuffer = new byte[1024];
		    byte[] byteData = null;
		    int nLength = 0;
		    while((nLength = is.read(byteBuffer, 0, byteBuffer.length)) != -1) {
		        baos.write(byteBuffer, 0, nLength);
		    }
		    byteData = baos.toByteArray();
		     
		    response = new String(byteData);
		     
		    responseJSON = new JSONArray(response);
		     
		}
		
		return responseJSON;

		
	}

}
