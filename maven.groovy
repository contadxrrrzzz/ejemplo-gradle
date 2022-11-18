def maven_build()
{

stage('Compile') {
    sh './mvnw clean compile -e'
  }

  stage('Test') {
    sh './mvnw clean test -e'
  }

  stage('Jar') {
    sh './mvnw clean package -e'
  }
  
  stage('Run') {
    sh 'nohup bash mvnw spring-boot:run &'
    sleep 20
  }
  
}
}
return this
