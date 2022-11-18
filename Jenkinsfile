
def maven_script
def gradle_script

pipeline {
    agent any
	
	tools{
	
	gradle 'gradle'
	maven 'Maven'	
	}
	
	parameters {
	choice (name: 'Build_Tool', choices: ['maven', 'gradle'], description: '')
	booleanParam (name: 'PushToNexus', defaultValue: false, description: '')
	
	}

    stages {

        stage ('Load Scripts'){
            steps{
                script{
                    maven_script= load "maven.groovy"
                    gradle_script= load "gradle.groovy"

                }
            }
        }

     if (params.Build_Tool.equals('maven'))
        {

            steps
            {
            script 
            {
                mvn_script.maven_build()
            }

        }
        }
        else
        {

            steps{
            script {
                gradle_script.gradle_build()
            }



        }
	
   
    }  
 }
}
