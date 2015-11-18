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

package net.wasdev.sample.javaee7.websocket.annotated;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.wasdev.sample.javaee7.websocket.coders.FormatIn;

//The ServerEndpoint annotation value is the name of the WebSocket Endpoint for this application/endpoint. 
//JavaScript to access from a WebSocket capable browser would be:  ws://<Host Name>:<port>/<Context-Root>/DecodeEncode
// there is an application defined Decoder and an application defined Encoder for messages of the given Decoder and Encoder type for this endpoint. 
@ServerEndpoint(value = "/DecodeEncode", decoders = { net.wasdev.sample.javaee7.websocket.coders.DecoderOne.class }, encoders = { net.wasdev.sample.javaee7.websocket.coders.EncoderOne.class })
public class DecodeEncode {
    Session currentSession = null;
    int count = 0;

    // OnOpen will get called by WebSockets when the connection has been established successfully using WebSocket handshaking with
    // the HTTP Request - Response processing.  
    @OnOpen
    public void onOpen(Session session, EndpointConfig ec) {
    	// Store the WebSocket session for later use.
        currentSession = session;
    }

    // using the OnMessage annotation for this method will cause this method to get called by WebSockets when this connection has received 
    // a WebSocket message from the other side of the connection that could be decoded into an application defined FormatIn object.
    // The message is derived from the WebSocket frame payloads of one, and only one, WebSocket message.
    @OnMessage
    public void decodeTextSendBackEncodedText(FormatIn decodedObject) {

        count++;
        String message = decodedObject.getDecodedString();

        try {
            if (message.equals("STOP")) {

                // use sendText to avoid the encoder that is looking for String types on sendObject to encode.
            	// send a WebSocket message back to the other endpoint that says we will stop.
                currentSession.getBasicRemote().sendText("ok, I will stop");

                // Sleep to let the other side get the message before stopping - a bit kludgy, but this is just a sample!
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                currentSession.close();

            } else {

                // WebSockets will identify the "String" type as a type to encode by EncoderOne class, and call the encoder
                currentSession.getBasicRemote().sendObject(message);
            }
        } catch (IOException e) {
            System.out.println("Caught unexpected IOException: " + e);
        } catch (EncodeException e) {
            System.out.println("Caught unexpected EncodeException: " + e);
        }
    }

    // Using the OnClose annotation will cause this method to be called when the WebSocket Session is being closed.
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        // no clean up is needed here for this sample
    }

    // Using the OnError annotation will cause this method to be called when the WebSocket Session has an error to report. For the Alpha version
    // of the WebSocket implentation on Liberty, this will not be called on error conditions.
    @OnError
    public void onError(Throwable t) {
        // no error processing will be done for this sample
    }

}
