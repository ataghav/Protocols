package javasample.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    
    private String SERVLET_ADDRESS = "http://localhost:8084/BankingWeb/GuiServlet";
    public String sendGet(String parameterVal) throws Exception {
        String query = SERVLET_ADDRESS + "?" + "number=" + parameterVal; 
        URL obj = new URL(query);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();//add reuqest header
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/html");
        con.connect();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + query);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();
        return response.toString();
    }
    
    public String sendPost(String postBody) throws Exception {
        
        URL obj = new URL(SERVLET_ADDRESS);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/html"); // Send post request
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(postBody);
        out.flush();
        out.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + SERVLET_ADDRESS);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
     
    public String sendPut(String postBody) throws Exception {
        
        URL obj = new URL(SERVLET_ADDRESS);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "text/html");// Send put request
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(postBody);
        out.flush();
        out.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'PUT' request to URL : " + SERVLET_ADDRESS);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
    
    public String sendDelete(String parameterVal) throws Exception {
        
        URL obj = new URL(SERVLET_ADDRESS);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();//add reuqest header
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type", "text/html");
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(parameterVal);
        out.flush();
        out.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'DELETE' request to URL : " + SERVLET_ADDRESS);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }  
}
