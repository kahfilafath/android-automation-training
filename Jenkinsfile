//Jenkinsfile (Declarative Pipeline)
/* Requires the Docker Pipeline plugin */
pipeline {
    agent  any
    //{ docker { image 'gradle:8.2.0-jdk17-alpine' } }
    stages {
        stage('build') {
            steps {
                sh './gradlew --version'
            }
        }
        stage('test'){
          steps {
            sh './gradlew clean cucumber --tags "@TC001"'
          }
        }
    }
}
