pipeline {
    agent any
	
	tools{
	
	gradle 'gradle'
	maven 'maven'	
	}
	
	parameters {
	choice (name: 'Build_Tool', choices: ['maven', 'gradle'], description: '')
	booleanParam (name: 'PushToNexus', defaultValue: false, description: '')
	
	}

    stages {
        stage('Build-MVN') {
		when{
			expression {
			params.Build_Tool = 'maven'
			}
		}
		
		
            steps {
                echo 'Building..'
                sh "mvn clean install -e"
            }
        }
	      stage('Build-Gradle') {
            steps {
                echo 'Building..'
                sh "gradle build"
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
    withSonarQubeEnv('Sonar') {
      sh 'mvn clean package sonar:sonar'
    } // submitted SonarQube taskId is automatically attached to the pipeline context
  }

	
	stage('uploadNexus') {
		when {
			expression {
			params.PushToNexus
			}
		}
            steps {
                echo 'Uploading Nexus'
				   nexusPublisher nexusInstanceId: 'nsx01', nexusRepositoryId: 'taller4-clases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/var/jenkins_home/workspace/taller4-clases_maven-gradle/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

      
            }
        }
	
	
   
    }  
 }


