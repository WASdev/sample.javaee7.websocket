Java EE 7 WebSocket Sample [![Build Status](https://travis-ci.org/WASdev/sample.javaee7.websocket.svg?branch=master)](https://travis-ci.org/WASdev/sample.javaee7.websocket)
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
2. Clone this repository.
3. Import the sample into Eclipse using *File -> Import -> Maven -> Existing Maven Projects* option.
4. Right click on the project and select *Run As -> Run on Server* option. Find and select the Liberty profile server and press *Finish*.
5. Go to: [http://localhost:9080/sample.javaee7.websocket/](http://localhost:9080/sample.javaee7.websocket/)

## Running with Maven

This project can be built with [Apache Maven](http://maven.apache.org/). The project uses [Liberty Maven Plug-in] to automatically download and install Liberty profile runtime from the [Liberty repository](https://developer.ibm.com/wasdev/downloads/). Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server.

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

## Running with Gradle

This project can also be built and run with [Gradle]. The provided `build.gradle` file applies the [Liberty Gradle Plug-in] and is configured to automatically download and install the Liberty Java EE7 Web Profile 7 runtime from Maven Central. The Liberty Gradle Plug-in has built-in tasks that can be used to create, configure, and run the application on the Liberty server.

Use the following steps to run the application with Gradle:

1. Execute the full Gradle build. The Liberty Gradle Plug-in will download and install the Liberty server.
    ```bash
    $ ./gradlew clean build
    ```

2. To start the server with the Servlet sample execute:
    ```bash
    $ ./gradlew libertyStart
    ```

    Alternatively, execute the run command:
    ```bash
    $ ./gradlew libertyRun --no-daemon
    ```

Once the server has started, the application will be available under [http://localhost:9080/sample.javaee7.jsonp](http://localhost:9080/sample.javaee7.jsonp).

3. To stop the server, execute:
    ```bash
    $ ./gradlew libertyStop
    ```  

Please refer to the [ci.gradle] repository for documentation about using the Liberty Gradle Plug-in.


## Deploying to Bluemix

Click the button below to deploy your own copy of this application to [Bluemix](https://bluemix.net).

[![Deploy to Bluemix](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/WASdev/sample.javaee7.websocket)

Once the application is deployed and running in bluemix, it will be available under
[http://MYAPPNAME.mybluemix.net/sample.javaee7.websocket/](http://MYAPPNAME.mybluemix.net/sample.javaee7.websocket/).

# Notice

© Copyright IBM Corporation 2015, 2017.

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
[Liberty Gradle Plug-in]: https://github.com/WASdev/ci.gradle
[ci.gradle]: https://github.com/WASdev/ci.gradle
[Gradle]: https://gradle.org
