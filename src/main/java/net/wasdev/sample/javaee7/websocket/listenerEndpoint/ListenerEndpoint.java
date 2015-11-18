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
package net.wasdev.sample.javaee7.websocket.listenerEndpoint;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.PongMessage;
import javax.websocket.Session;


/**
 *  Any incoming text message will trigger a ping request to the client.  Upon receipt of the PongMessage
 *  we will send a text message back to the client with a prepended "Server process pong msg : <msg data>"
 */
public  class ListenerEndpoint extends Endpoint {
  
    @Override
    public void onOpen(final Session session, EndpointConfig ec) {
    	
        session.addMessageHandler(new MessageHandler.Whole<PongMessage>() {

            // Some browsers, for example some verions of Internet Explorer v10, may send unsolicited Websocket Pong messages from
            // the browser's Websocket Client Endpoint to the Websocket Server Endpoint.  Those unsolicited messages will normally be discarded if a PongMessage
            // MessageHandler is not defined for the Websocket Server Endpoint.  Here we are defining a PongMessage MessageHandler, so we will receive the 
            // unsolicited Pong messages and then the code below will return an empty Pong responses.  Therefore on the browser an empty Pong response message will 
            // be displayed. Other PongMessage listeners may choose to deal with this in a different way, for example, by detecting that an empty Pong message has been
            // received and not sending back a Pong response.
            @Override
            public void onMessage(PongMessage msg) {
            	ByteBuffer retBuf = msg.getApplicationData();
            	String value=new String(retBuf.array());
            	
            	if (value.equals("stop")){
            		 try {
            			
						session.getBasicRemote().sendText("OK. I will stop.");
						session.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  		
            	}
            	else{
                try {
                    
                    session.getBasicRemote().sendText("Server processed pong msg :" + value);
                } catch (Exception ex) {
                    Logger.getLogger(ListenerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
            }
                     	
        });

        session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String data) {

                try {                   
                    session.getBasicRemote().sendPing(ByteBuffer.wrap(data.getBytes()));
                } catch (Exception ex) {
                    Logger.getLogger(ListenerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason reason) {

    }

    @Override
    public void onError(Session session, Throwable thr) {
    	  Logger.getLogger(ListenerEndpoint.class.getName()).log(Level.SEVERE, "OnError", thr);
    }
}
