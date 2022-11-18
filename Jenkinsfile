def call(){
  
	pipeline {

		agent any
		
		environment {
		    STAGE = ''
		}

		parameters {
			choice(name: 'buildTool', choices: ['gradle', 'maven'], description: 'Indicar herramienta de construcción')
		}

		stages{
			stage('Pipeline'){
				steps{
					script{
						println 'Pipeline'

						if (params.buildTool == "gradle") {
							println "gradle"
						} else {
							println "maven"
						}

					}
				}
			}
		}
    }
}
