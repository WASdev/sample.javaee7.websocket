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

package net.wasdev.sample.javaee7.websocket.coders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

// This is coded to be a Text type encoder, and it will encode outgoing Strings that we sent using the sendObject method.
public class EncoderOne  implements Encoder.Text<String> {

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public String encode(String s) throws EncodeException {
		
		// encoding will be to replace the upper case vowels with numbers.
		// A = 4, E = 3, I = 1, O = 0, and U = 6.
		String output = null;
		
		if (s == null) {
			return "";
		}
		
		output = s.replace("A", "4");
		output = output.replace("E", "3");
		output = output.replace("I", "1");
		output = output.replace("O", "0");
		output = output.replace("U", "6");
		
		return output;
	}

}
