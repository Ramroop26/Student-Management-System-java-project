
# Dockerfile
# And let's make our Dockerfile. Open yourproject/Dockerfile and copy&paste these:

FROM tomcat:9.0.1-jre8-alpine

ADD ./webapp /usr/local/tomcat/webapps/webapp

CMD ["catalina.sh", "run"]
# That's everything we need. Let me explain each line:

# Apache Tomcat Image
FROM tomcat:9.0.1-jre8-alpine
# We use official tomcat:9.0.1-jre8-alpine image for our base image. You can choose any other images you want, like tomcat:8.5.23-jre8. But tomcat:9.0.1-jre8-alpine is the latest release of Apache Tomcat image on Docker Hub now and has much smaller(~113MB) size than tomcat:9.0.1-jre8(~557MB) so I'll stick to use it.

# Copying Website and Start up Tomcat
ADD ./webapp /usr/local/tomcat/webapps/webapp
# The ADD instruction copies our files(in our case, yourproject/webapp folder) to container's file system(/usr/local/tomcat/webapps/webapp). I tried to use a WAR file instead of plain source codes, but it didn't work for me for some reason. If someone knows how to pre-compile all the JSP files and copy it into image, please leave a comment.

CMD ["catalina.sh", "run"]
# Finally, the CMD instruction will start up Apache Tomcat, which runs our web application.

# Build Docker Image and Run
# Go to yourproject/ in terminal, and type it to build a Docker image:

# $ docker build -t mywebapp .
# And then run:

# $ docker run --rm -it -p 8888:8080 mywebapp
