Java EE 7 WebSocket Sample
==============

This project contains a simple WebSocket application which demonstrates the Java EE 7 technology.

These web sockets sample shows how to set up WebSocket Endpoints using annotations or programmatically. 

These samples exercise different operations on a WebSocket connection:

- Opening
- Reading 
- writing 
- closing 

Also shown is the use of encoders, decoders, the PathParam annotation, and Pong message processing. 

## Getting Started

Browse the code to see what it does, or build and run it yourself!


## Running in Eclipse

1. Download and install [Eclipse with the WebSphere Developer Tools](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/).
2. Create a new Liberty Profile Server.
3. Clone this repository.
4. Import the sample into Eclipse using *File -> Import -> Maven -> Existing Maven Projects* option.
5. Deploy the sample into Liberty server. Right click on the *servlet* sample and select *Run As -> Run on Server* option. Find and select the Liberty profile server and press *Finish*. 
6. Go to: [http://localhost:9080/servlet](http://localhost:9080/servlet)

## Building

The sample can be build using [Apache Maven](http://maven.apache.org/).

```bash
$ mvn install
```

## Deploying to Bluemix

Click the button below to deploy your own copy of this application to [Bluemix](https://bluemix.net).

[![Deploy to Bluemix](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/WASdev/sample.javaee7.websocket)

# Notice

© Copyright IBM Corporation 2015.

# License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
