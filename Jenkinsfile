pipeline {
    agent any
    environment {
        MAVEN_HOME = tool name: 'Maven 3.8.5', type: 'maven'
        JAVA_HOME = tool name: 'OpenJDK-21', type: 'jdk'
    }
    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }
        stage('Run Tests in Parallel') {
            parallel {
                stage('API Tests') {
                    steps {
                        dir('IT-Quality-Assurance-Assignment-API-Testing') {
                            echo "MAVEN_HOME is: ${MAVEN_HOME}" // Debugging line
                            sh "${MAVEN_HOME}/bin/mvn clean verify"
                        }
                    }
                    post {
                        always {
                            publishHTML (target : [allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: 'API-Testing/target/site/serenity',
                            reportFiles: 'index.html',
                            reportName: 'API Serenity Reports',
                            reportTitles: 'API Serenity Test Report'
                            ])
                        }
                    }
                }
                stage('UI Tests') {
                    steps {
                        dir('IT-Quality-Assurance-Assignment-UI-Testing') {
                            echo "MAVEN_HOME is: ${MAVEN_HOME}" //
                            sh "${MAVEN_HOME}/bin/mvn clean install"
                        }
                    }
                    post {
                        always {
                            publishHTML (target : [allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: 'UI-Testing/target/site/serenity',
                            reportFiles: 'index.html',
                            reportName: 'UI Serenity Reports',
                            reportTitles: 'UI Serenity Test Report'
                            ])
                        }
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline execution completed!'
        }
    }
}
