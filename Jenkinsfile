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
    withSonarQubeEnv('Sonar') {
      sh 'mvn clean package sonar:sonar'
    } // submitted SonarQube taskId is automatically attached to the pipeline context
  }
}
      nexusPublisher nexusInstanceId: 'nsx01', nexusRepositoryId: 'taller4-clases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/var/jenkins_home/workspace/taller4-clases/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

      
      
 }
}

