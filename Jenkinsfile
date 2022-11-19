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
	
	    
	    stage ('Build'){
            steps{
                script{
			println "Build"
			if (params.buildTool == "maven")
			{
			maven_script.maven_compile()
			}
			else 
			{
			 gradle_script.gradle_build()
			}
                   

                }
            }
        }
	        stage ('SonarQube analysis'){
			 
            
             
               script{
			println "Build"
			if (params.buildTool == "maven")
			{
			steps{
		    		withSonarQubeEnv('Sonar')
				maven_script.maven_sonar()
			}
			}
			else 
			{
			
			 gradle_script.gradle_sonar()
			}
	       }

                
            }
        }
	    
	    
	    
	
   
    }  
 }
