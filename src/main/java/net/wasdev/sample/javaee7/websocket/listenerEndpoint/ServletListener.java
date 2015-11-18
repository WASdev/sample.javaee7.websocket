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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;

public class ServletListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext servletContext = event.getServletContext();
        ServerContainer websocketServerContainer = (ServerContainer) servletContext.getAttribute("javax.websocket.server.ServerContainer");

        try {
            websocketServerContainer.addEndpoint(new ListenerEndpointConfig());       
        } catch (DeploymentException e) {
        	Logger.getLogger(ServletListener.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
