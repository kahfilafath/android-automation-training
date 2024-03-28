//Jenkinsfile (Declarative Pipeline)
/* Requires the Docker Pipeline plugin */
pipeline {
    agent //{ docker { image 'gradle:8.2.0-jdk17-alpine' } }
    stages {
        stage('build') {
            steps {
                sh './gradlew --version'
            }
        }
        stage('test'){
          steps {
            echo 'This is stage test'
          }
        }
    }
}
