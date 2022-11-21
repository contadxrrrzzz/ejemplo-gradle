pipeline {
    agent any
	
	tools{
	
	gradle 'gradle'
		
	}

    stages {
        stage('Publicar Nexus') {
            steps {
                sh 'gradle clean build publish'
            }
        }
      

    
      
      
 }
}



