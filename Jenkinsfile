pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "./mvnw clean compile -e"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "./mvnw.cmd clean test -e"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh "./mvnw.cmd clean package -e"
            }
        }
	stage ('Run'){
            steps
                {
                    echo 'TODO: run'          
                }            
        }
        
      stage('SonarQube analysis') {
    withSonarQubeEnv('My SonarQube Server') {
      sh 'mvn clean package sonar:sonar'
    } // submitted SonarQube taskId is automatically attached to the pipeline context
  }
}
      
      
      
 }
}

