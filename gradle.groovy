def call(String pipelineType){
    
 stage('Build) {
   sh 'gradle build'
  }

  stage('Check') {
   sh 'gradle check'
  }

  stage('Clean') {
    sh "gradle clean"
  }
  
  stage('Run') {
    sh "gradle run"
    sleep 20
  }
  
}
return this

