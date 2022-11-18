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
    sh 'mvn clean package sonar:sonar'
  }

  


return this
