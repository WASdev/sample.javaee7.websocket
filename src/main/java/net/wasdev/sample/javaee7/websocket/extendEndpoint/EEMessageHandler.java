/*
* COPYRIGHT LICENSE: This information contains sample code provided in source
* code form. You may copy, modify, and distribute these sample programs in any 
* form without payment to IBM for the purposes of developing, using, marketing 
* or distributing application programs conforming to the application programming 
* interface for the operating platform for which the sample code is written. 
* 
* Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE 
* ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, INCLUDING, 
* BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, 
* SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR 
* CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR
* OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO OBLIGATION TO PROVIDE
* MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE
* SOURCE CODE.
* 
* (C) Copyright IBM Corp. 2015.
* 
* All Rights Reserved. Licensed Materials - Property of IBM. 
*/

package net.wasdev.sample.javaee7.websocket.extendEndpoint;

import java.io.IOException;

import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class EEMessageHandler implements MessageHandler.Whole<String> {

    int count = 0;
    Session currentSession = null;

    public EEMessageHandler(Session session) {
    	// store the session so our onMessage method can use it later
        currentSession = session;
    }

    // onMessage will be called by WebSockets when this connection has received 
    // a WebSocket message from the other side of the connection.  
    // The message is derived from the WebSocket frame payloads of one, and only one, WebSocket message.
    @Override
    public void onMessage(String message) {
        try {
            count++;

            if (message.toLowerCase().equals("stop")) {
                // send a WebSocket message back to the other endpoint that says we will stop.
                currentSession.getBasicRemote().sendText("OK. I will stop.");

                // Sleep to let the other side get the message before stopping - a bit kludgy, but this is just a sample!
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                currentSession.close();
            } else {
                // send the message back to the other side with the iteration count.  Notice we can send multiple message without having
                // to receive messages in between.
                currentSession.getBasicRemote().sendText("From: " + this.getClass().getSimpleName() + "  Iteration count: " + count);
                currentSession.getBasicRemote().sendText(message);
            }

        } catch (IOException ex) {
            // no error processing will be done for this sample
        }

    }

}
