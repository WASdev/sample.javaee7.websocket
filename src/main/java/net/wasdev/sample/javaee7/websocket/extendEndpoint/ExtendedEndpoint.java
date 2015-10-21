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

package net.wasdev.sample.javaee7.websocket.extendEndpoint;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class ExtendedEndpoint extends Endpoint {

    // onOpen will get called by WebSockets when the connection has been established successfully using WebSocket handshaking with
    // the HTTP Request - Response processing.
    @Override
    public void onOpen(final Session session, EndpointConfig ec) {
    	// Set up the object that will receive messages sent from the other side of this connection.
        MessageHandler.Whole<String> handler = new EEMessageHandler(session);
        session.addMessageHandler(handler);
    }

    // onClose will be called when the WebSocket Session is being closed.
    @Override
    public void onClose(Session session, CloseReason reason) {}

    // onError will be called when the WebSocket Session has an error to report. For the Alpha version
    // of the WebSocket implentation on Liberty, this will not be called on error conditions.
    @Override
    public void onError(Session session, Throwable thr) {}

}
