pipeline {
    agent any
	
	tools{
	
	gradle 'gradle'
		
	}

    stages {
        stage('Publicar Nexus') {
            steps {
                sh 'gradle build publish'
            }
        }
      

    
      
      
 }
}



