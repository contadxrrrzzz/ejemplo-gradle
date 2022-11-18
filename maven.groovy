def maven_compile()
{
    sh './mvnw clean compile -e'
}

def maven_test()
{
   sh './mvnw clean test -e'
}

def maven_jar()
{
   sh './mvnw clean package -e'
}

def maven_run()
{
    sh 'nohup bash mvnw spring-boot:run &'
}
def maven_testApp()
{
    sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
}


return this
