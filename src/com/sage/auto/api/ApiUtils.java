package com.sage.auto.api;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiUtils
{
  public static byte[] readInputStream(InputStream inStream)
    throws Exception
  {
    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int len = 0;
    while ((len = inStream.read(buffer)) != -1) {
      outStream.write(buffer, 0, len);
    }
    inStream.close();
    return outStream.toByteArray();
  }

  public static String post(String urlParam, String requestString)
  {
    String result = "";
    StringBuffer urlStr = new StringBuffer(urlParam);
    URL url = null;
    HttpURLConnection conn = null;
    try {
      url = new URL(urlStr.toString());
      conn = (HttpURLConnection)url.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setUseCaches(false);

      conn.setRequestProperty("Content-Type", "application/xml;charset=UTF-8");
      
      if (requestString != null) {
        OutputStream os = conn.getOutputStream();
        os.write(URLEncoder.encode(requestString, "UTF-8").getBytes("UTF-8"));
        os.flush();
        os.close();
      }

      if (conn.getResponseCode() == 200) {
        InputStream inStream = conn.getInputStream();
        result = new String(readInputStream(inStream), "UTF-8");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      conn.disconnect();
    }
    return result;
  }
  
  public static String sendPost(String url, String param) {
      PrintWriter out = null;
      BufferedReader in = null;
      String result = "";
      try {
          URL realUrl = new URL(url);
          // 打开和URL之间的连接
          URLConnection conn = realUrl.openConnection();
          // 设置通用的请求属性
          conn.setRequestProperty("Content-Type", "application/xml;charset=UTF-8");
          // 发送POST请求必须设置如下两行
          conn.setDoOutput(true);
          conn.setDoInput(true);
          // 获取URLConnection对象对应的输出流
          out = new PrintWriter(conn.getOutputStream());
          // 发送请求参数
          out.print(param);
          // flush输出流的缓冲
          out.flush();
          // 定义BufferedReader输入流来读取URL的响应
          in = new BufferedReader(
                  new InputStreamReader(conn.getInputStream()));
          String line;
          while ((line = in.readLine()) != null) {
              result += line;
          }
      } catch (Exception e) {
          System.out.println("发送 POST 请求出现异常！"+e);
          e.printStackTrace();
      }
      //使用finally块来关闭输出流、输入流
      finally{
          try{
              if(out!=null){
                  out.close();
              }
              if(in!=null){
                  in.close();
              }
          }
          catch(IOException ex){
              ex.printStackTrace();
          }
      }
      return result;
  }    
  
  
}