
def maven_script
def gradle_script

pipeline {
    agent any
	
	tools{
	
	gradle 'gradle'
	maven 'Maven'	
	}
	
	parameters {
	choice (name: 'buildTool', choices: ['maven', 'gradle'], description: 'Indicar herramienta de construcción')
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
	
	    
	    stage ('Pipeline'){
            steps{
                script{
			println "Pipeline"
			  if (params.buildTool == "maven")
			{
			mvn_script.maven_build()
			}
			else 
			{
			 gradle_script.gradle_build()
			}
                   

                }
            }
        }
	    
	    
	
   
    }  
 }
}
