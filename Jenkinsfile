//Jenkinsfile (Declarative Pipeline)
/* Requires the Docker Pipeline plugin */
pipeline {
    agent  any
    //{ docker { image 'gradle:8.2.0-jdk17-alpine' } }
    stages {
        stage('build') {
            steps {
                bat './gradlew --version'
            }
        }
        stage('test'){
          steps {
            bat './gradlew test cucumber'
          }
        }
    }
}
