# README #

Simple example micro service written using Java 8 & Spring.  Should be used as a template.  Includes health check endpoint for use with DC/OS.

### How do I get set up? ###

This project requires Gradle.

To run: `gradle run`

To build: `gradle build`

To build docker image: `gradle buildDocker`

* may require `docker login` to push image.  Be sure to update `groupName` in gradle file.
* also includes a configuration file for Marathon @ src/main/marathon/application.json.

### Contribution guidelines ###

Don't contribute.  Use it as a starting point for other projects.
