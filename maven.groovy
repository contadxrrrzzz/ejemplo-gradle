def maven_compile() {
    sh './mvnw clean compile -e'
  }

def maven_test()  {
    sh './mvnw clean test -e'
  }

def maven_jar() {
    sh './mvnw clean package -e'
  }
  
def maven_run() {
    sh 'nohup bash mvnw spring-boot:run &'
    sleep 20
  }
def maven_sonar() {
    withSonarQubeEnv('Sonar'){
		sh 'mvn clean package sonar:sonar'
    }
  }
def maven_sonarQuality() {
    timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
    }
  }

def maven_nexus(){

	nexusPublisher nexusInstanceId: 'nsx01', nexusRepositoryId: 'taller4-clases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/var/jenkins_home/workspace/tallerm4-clases_maven-gradle/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]


}
  

return this;
