pipeline {
    agent any
	
	tools{
	
	gradle 'gradle'
		
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

     


      	stage ('Run'){
            steps
                {
                    sh 'gradle bootRun'        
                }            
        }
      
      
 }
}



