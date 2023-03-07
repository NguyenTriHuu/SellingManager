/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import client.Message;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCtr {
    private int port;
    private String host;
    private Socket clientsocket ;
    public ClientCtr(){
        this.port=  8888;
        this.host="localhost";
    }
    
    public void Connect(){
        try {
            clientsocket = new Socket(host,port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SendMes(String mes){
        try {
            PrintWriter pr =new PrintWriter(clientsocket.getOutputStream());
            pr.println(mes);
            pr.flush();
        } catch (Exception e) {
        }
    }
    
    public String ResultMes() throws IOException{
            String Message="";
            InputStreamReader in = new InputStreamReader(clientsocket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            Message=(String)bf.readLine();
     return Message;
    }
    
    public void closeConnect(){
        try {
            clientsocket.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
        }
}
