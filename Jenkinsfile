//Jenkinsfile (Declarative Pipeline)
/* Requires the Docker Pipeline plugin */
pipeline {
    agent any
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
