/*
 * COPYRIGHT LICENSE: This information contains sample code provided in source code form.
 * You may copy, modify, and distribute these sample programs in any form without payment
 * to IBM for the purposes of developing, using, marketing or distributing application
 * programs conforming to the application programming interface for the operating platform
 * for which the sample code is written.
 * 
 * Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE ON 
 * AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, INCLUDING,
 * BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY,
 * SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR
 * CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF
 * THE SAMPLE SOURCE CODE. IBM HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT,
 * UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE SOURCE CODE.
 * 
 * (C) Copyright IBM Corp. 2013.
 * All Rights Reserved. Licensed Materials - Property of IBM.
 */

package net.wasdev.sample.javaee7.websocket.annotated;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * This sample shows how to use @PathParam annotation in WebSocket application. Please read "Section 4.3 @PathParam" of JSR 356 Java™ API for WebSocket
 * specification for more information
 */
@ServerEndpoint(value = "/SimplePathParam/rentals/{name}/{building}/{home-number}/{no-of-rooms}/{property-val}/{pets-allowed}/{maintenance-fee}")
public class PathParamEndpoint {
    private Session currentSession = null;
    int count = 0;

    @OnMessage
    public String echoText(String message, @PathParam("pets-allowed") Boolean isPetsAllowed, @PathParam("property-val") Double propertyValue, @PathParam("name") String name,
                           @PathParam("building") char building, @PathParam("home-number") Integer homeNumber,
                           @PathParam("no-of-rooms") short noOfRooms, @PathParam("maintenance-fee") float maintFee
                    ) {
        String returnText = null;
        try {
            if (message.toLowerCase().equals("stop")) {
                currentSession.getBasicRemote().sendText("OK. I will stop.");
                // Sleep to let the other side get the message before stopping - a bit kludgey, but this is just a sample! 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                currentSession.close();
            } else {
                // send the message back to the other side with the iteration count.  Notice we can send multiple message without having
                // to receive messages in between.
                count++;
                returnText = "Message: " + message + " PathParam values ==> " + " name: " + name + " building: " + building + " home-number: " + homeNumber + " building: "
                             + building
                             + " no-of-rooms: " + noOfRooms + " property-val: " +
                             propertyValue + " maintenance-fee: " + maintFee + " pets-allowed: " + isPetsAllowed;
            }
        } catch (IOException ex) {
            // no error processing will be done for this sample
        }
        return returnText;
    }

    @OnOpen
    public void onOpen(final Session session, EndpointConfig ec, @PathParam("no-of-rooms") short noOfRooms) {
        String paramValues = " PathParam value is: " + " no-of-rooms: " + noOfRooms;

        System.out.println("PathParamEndpoint.onOpen() invoked." + paramValues);
        currentSession = session;
    }

    @OnClose
    public void onClose(Session session, CloseReason reason, @PathParam("maintenance-fee") float maintFee) {
        String paramValues = " PathParam value is: " + " maintance-fee: " + maintFee;
        System.out.println("PathParamEndpoint.onClose() invoked. Session: CloseReason: " + reason.getReasonPhrase() + paramValues);
        try {
            if (session != null) {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(final Session session, Throwable error, @PathParam("pets-allowed") Boolean isPetsAllowed) {
        String paramValues = " PathParam value is: " + " pets-allowed: " + isPetsAllowed;
        System.out.println("PathParamEndpoint.onError() invoked.  Throwable message: " + error.getMessage() + paramValues);
        try {
            if (session != null) {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
