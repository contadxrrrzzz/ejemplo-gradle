pipeline {
    agent any
	
	tools{
	gradle 'grdl'
		maven 'maven'
	}

    stages {
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
        stage('Check') {
            steps {
                sh 'gradle check'
            }
        }

     
      stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      sh './gradlew sonarqube'
    } // submitted SonarQube taskId is automatically attached to the pipeline context
  }

      	stage ('Run'){
            steps
                {
                    sh 'gradle run'        
                }            
        }
      
      
 }
}



