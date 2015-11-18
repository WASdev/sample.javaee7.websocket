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

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

// This is coded to be a Text type decoder, and it will decode incoming messages into object of type FormatIn.
public class DecoderOne implements Decoder.Text<FormatIn> {

	public DecoderOne() {
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public FormatIn decode(String s) throws DecodeException {
        // For the incoming String, create a new FormatIn object and allow this object to decode the String data.
		FormatIn f = new FormatIn();
		f.doDecoding(s);
		return f;
	}

	@Override
	public boolean willDecode(String s) {
	    // For the sample, we will always try to encode whatever String we receive
		return true;
	}

}
