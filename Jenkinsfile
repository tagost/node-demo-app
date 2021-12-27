//CODE_CHANGES = getGitChanges()
pipeline {
	agent any
	environment {
		NEW_VERSION = '1.3.0'
		SERVER_CREDENTIALS = credentials('')
	}
	tools{
		maven 'maven'
	}
	parameters {
		string (name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
		choice(name: 'VERSION', choices: ['1.1.0', '1.1.2', '1.2.0'], description: '')
		booleanParam(name: 'executeTests', defaultValue: true, description: '')
	}
	stages {
		stage ("build"){
			when {
				expression {
					params.executeTests
				}
			}
			steps {
				echo 'building the aplication...'
				echo "building new version ${NEW_VERSION}"
			}
		}
		
		stage ("test"){
			when {
				expression {
					env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'dev'
				}
			}
			steps {
				echo 'testing the aplication...'
			}
		}
		
		stage ("deploy"){
			steps {
				echo 'deploying the aplication...'
				echo "deploying version ${params.VERSION}"
				withCredentials([
					usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
				]){
					sh "some script ${USER} ${PWD}"
				}
			}
		}
	}
	post {
		always {
			//
		}
		success {
			
		}
		failure {
		
		}
	}
}