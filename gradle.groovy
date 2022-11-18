def gradle_build()
{
     sh 'gradle build'
}
return this

def gradle_check()
{
   sh 'gradle check'
}
return this
def gradle_clean()
{
    sh "gradle clean"
}
return this

def gradle_run()
{
    sh "gradle run"
}
return this
