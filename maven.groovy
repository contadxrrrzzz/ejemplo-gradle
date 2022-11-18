def maven_build()
{
    sh 'mvn clean install -e'
}
return this

def maven_compile()
{
    sh "./mvnw clean compile -e"
}
return this
def maven_test()
{
    sh "./mvnw clean test -e"
}
return this