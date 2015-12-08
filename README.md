Java EE 7 WebSocket Sample
==============

This project contains a simple WebSocket application which demonstrates the Java EE 7 technology.

These web sockets sample shows how to set up WebSocket Endpoints using annotations or programmatically. 

These samples exercise different operations on a WebSocket connection:

- Opening
- Reading 
- Writing 
- Closing 

Also shown is the use of encoders, decoders, the PathParam annotation, and Pong message processing. 

## Getting Started

Browse the code to see what it does, or build and run it yourself!


## Running in Eclipse

1. Download and install [Eclipse with the WebSphere Developer Tools](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/).
2. Create a new Liberty Profile Server.
3. Clone this repository.
4. Import the sample into Eclipse using *File -> Import -> Maven -> Existing Maven Projects* option.
5. Edit the server.xml file located in the Servers -> DefaultServer folder in EnterpriseExporer. Copy the server.xml features from this project, found under the `<featureManager>` in /src/main/wlp/server.xml
6. Deploy the sample into Liberty server. Right click on the project and select *Run As -> Run on Server* option. Find and select the Liberty profile server and press *Finish*.
7. Go to: [http://localhost:9080/sample.javaee7.websocket/](http://localhost:9080/sample.javaee7.websocket/)

## Running with Maven

This project can be build with [Apache Maven](http://maven.apache.org/). The project uses [Liberty Maven Plug-in][] to automatically download and install Liberty profile runtime from the [Liberty repository](https://developer.ibm.com/wasdev/downloads/). Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server. 

Use the following steps to run the application with Maven:

1. Execute full Maven build. This will cause Liberty Maven Plug-in to download and install Liberty profile server.
    ```bash
    $ mvn clean install
    ```

2. To run the server with the WebSocket application execute:
    ```bash
    $ mvn liberty:run-server
    ```

Once the server is running, the application will be available under [http://localhost:9080/sample.javaee7.websocket/](http://localhost:9080/sample.javaee7.websocket/).

## Deploying to Bluemix

Click the button below to deploy your own copy of this application to [Bluemix](https://bluemix.net).

[![Deploy to Bluemix](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/WASdev/sample.javaee7.websocket)

Once the application is deployed and running in bluemix, it will be available under 
[http://MYAPPNAME.mybluemix.net/sample.javaee7.websocket/](http://MYAPPNAME.mybluemix.net/sample.javaee7.websocket/).

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

[Liberty Maven Plug-in]: https://github.com/WASdev/ci.maven

