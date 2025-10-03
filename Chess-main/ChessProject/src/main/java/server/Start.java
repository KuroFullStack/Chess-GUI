/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.logging.Level;
import java.util.logging.Logger;

// This is the main class of server to start the server.
public class Start {

    public static void main(String[] args) {
        Server server = new Server(4000);
        server.ListenClientConnectionRequests();

        while (!server.socket.isClosed()) {

            try {
                System.out.println("I'm waiting for client."+Server.clients.size()+" to start.");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
