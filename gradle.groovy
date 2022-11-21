def gradle_build() {
   sh 'gradle build'
  }

def gradle_check(){
   sh 'gradle check'
  }

def gradle_clean(){
    sh "gradle clean"
  }
  
def gradle_run(){
    sh "gradle run"
    sleep 20
  }
  
def gradle_sonar()
{
      withSonarQubeEnv('Sonar'){
		  sh "gradle sonarqube"
    }
    
}
def gradle_sonarQuality(){
    timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
    }
}
def gradle_nexus(){
nexusPublisher nexusInstanceId: 'nsx01', nexusRepositoryId: 'taller4-clases', packages: [[$class: 'MavenPackage', mavenAssetList: [], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.0']]]
}


return this;
