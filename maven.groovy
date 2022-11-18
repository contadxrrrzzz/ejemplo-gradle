def maven_build()
{
    sh 'mvn clean install -e'
}
return this
