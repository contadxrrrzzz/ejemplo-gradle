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
		  sh './gradle sonarqube'
    }
    
}
def gradle_sonarQuality(){
    timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
    }
}


return this;
