/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author Jose Luis
 */
public class UsuarioD {
    
    private ArrayList<String> DatosPersona = new ArrayList<String>();


    public ArrayList<String> resPersona(String dni){
        DatosPersona.clear();
        try {
            String webService = "https://api.reniec.cloud/dni/"+dni;
            URL url = new URL(webService);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            
            if (conn.getResponseCode() == 200) {                 
                
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String Respuesta,resul="";
                
                while ((Respuesta = br.readLine()) != null) {
                    resul += Respuesta;                   
                }
                      
                JSONObject obj = new JSONObject(resul);
                String nombre = obj.getString("nombres");
                String apellido = obj.getString("apellido_paterno") + " " + obj.getString("apellido_materno"); 
                
                                
                DatosPersona.add(nombre);
                DatosPersona.add(apellido);
                
                return DatosPersona;

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
    
}
