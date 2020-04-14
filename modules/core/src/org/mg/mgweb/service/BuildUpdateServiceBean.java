package org.mg.mgweb.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service(BuildUpdateService.NAME)
public class BuildUpdateServiceBean implements BuildUpdateService {
    public void build(){
        try {
            URL url = new URL ("http://localhost:8080/jenkins/job/mgweb/build"); // Jenkins URL localhost:8080, job named 'test'
            String user = "auto"; // username
            String pass = "auto"; // password or API token
            String authStr = user +":"+  pass;
            String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}