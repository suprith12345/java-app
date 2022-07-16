pipeline{
    agent any
    tools {
        maven "Maven-3.8.6"
    }
    stages{
        stage('Github'){
            steps{
                echo "cloning repo..................."
                println params.Name
                git branch: 'main', credentialsId: 'my-github-credentials', url: 'https://github.com/suprith12345/java-app.git'
            }
        }
        
        stage('Maven Build'){
            when {
                expression {params.Build}
            }
            steps{
                echo "Building project with Maven.........."
                sh "mvn clean install"
            }
        }
        
        stage('SonarQube'){
            environment{
                Sonar = tool 'Sonar'
            }
            steps{
                withSonarQubeEnv('SonarServer'){
                    sh "${Sonar}/bin/sonar-scanner -Dsonar.projectKey=suprith_app -Dsonar.sources=. -Dsonar.java.binaries=target/classes/com/mycompany/app/"
                }
            }
        }
        
        stage("Sonar Status"){
            steps{
                waitForQualityGate abortPipeline: true
            }
        }
        
        stage('Deploy'){
            when {
                expression {params.Deploy}
            }
            steps{
                script
                {
                    echo "Deploying to S3 bucket"
                    if(params.Bucket == "suprith-devops-bucket")
                    {
                        s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'suprith-devops-bucket', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, sourceFile: 'target/*.jar', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'AWS-S3', userMetadata: []
                    }
                    if(params.Bucket == "suprith-bucket")
                    {
                        s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'suprith-bucket', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, sourceFile: 'target/*.jar', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'AWS-S3', userMetadata: []
                    }
                }
            }
        }
    }
}
