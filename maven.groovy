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
  

return this
