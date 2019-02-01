/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Esben
 */
public class HttpClient {
  String uri=null;
  public HttpClient(String uri) {
    this.uri = uri;
  }
  
  public String makeHttpRequest(String params) throws MalformedURLException,IOException {
    URL url = new URL(uri+params);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Accept", "text/plain;charset=UTF-8");
    String result;
    try (Scanner scan = new Scanner(con.getInputStream())) {
      result = null;
      if (scan.hasNext()) {
        result = scan.nextLine();
      }
    }
    return result;
  }
}
