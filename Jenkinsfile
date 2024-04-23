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
          options {
            catchError(message: "Test failed", stageResult: 'UNSTABLE', buildResult: 'UNSTABLE')
          }
          steps {
            bat './gradlew clean cucumber --tags "@TC001 or @TC002"'
          }
        }
        stage('Generate Report'){
           steps{
             cucumber buildStatus: 'UNSTABLE',
                      reportTitle: 'cucumber-report',
                      fileIncludePattern: '**/cucumber.json',
                      jsonReportDirectory: 'build',
                      trendsLimit: 10,
                      classifications: [
                        [
                           'key': 'Browser',
                           'value': 'Chrome'
                        ]
                      ]
           }
           post {
             always {
                 emailext subject: ''${env.PROJECT_NAME} '- Build' [${env.BUILD_NUMBER}]'-'${env.BUILD_STATUS},
                          to: 'qagli037@gmail.com',
                          body: '<p>'${env.PROJECT_NAME}' - Build # '[${env.BUILD_NUMBER}]'-'${env.BUILD_STATUS}'</p>'
                          '<p> Check console output at' ${env.BUILD_URL}' to view the results.</p>'
             }
           }
        }
    }
}
