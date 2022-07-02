pipeline {
    agent any

    tools {
        // auto installed maven
        maven "Maven"
    }

    stages {
        stage('cleanup')
        {
            steps{
                deleteDir()
            }
        }
        stage('Git Checkout') {
            steps {
                
                git credentialsId: 'my-bitbucket-creds', url: 'https://dineshtoon@bitbucket.org/dineshtoon/java_maven.git'
            }

        }
        stage('maven and jacoco') {
            steps {
                sh 'mvn clean install'
                //sh 'mvn sonar:sonar'
            }

        }
        stage('Sonarqube') {
    environment {
        scannerHome = tool 'Sonar'
    }
    steps {
        withSonarQubeEnv('SonarServer') {
            sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=java_maven -Dsonar.sources=. -Dsonar.java.binaries=target/classes/com/mycompany/app/ "
            //sh "${scannerHome}/bin/sonar-scanner"
          echo 'some'
        }
        }
    }
    stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
               echo 'some'
            }
        }
    
        stage('Deploy') {
            steps {
                //sh 'mvn test'
                echo 'deploying to nexus of target server'
            }

        }
    }
}


