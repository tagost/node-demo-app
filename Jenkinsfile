//CODE_CHANGES = getGitChanges()
pipeline {
	agent any
	environment {
		NEW_VERSION = '1.3.0'
		SERVER_CREDENTIALS = credentials('tagost')
	}
	tools{
		ant 'ant'
	}
	parameters {
		string (name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
		choice(name: 'VERSION', choices: ['1.1.0', '1.1.2', '1.2.0'], description: '')
		booleanParam(name: 'executeTests', defaultValue: true, description: '')
	}
	stages {
		stage ("init"){
			steps {
				script {
					gv = load "script.groovy"
				}
			}
		}
		stage ("build"){
			when {
				expression {
					params.executeTests
				}
			}
			steps {
				script{
					gv.buildApp()
				}
			}
		}
		
		stage ("test"){
			when {
				expression {
					env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'dev'
				}
			}
			steps {
				script{
					gv.testApp()
				}
			}
		}
		
		stage ("deploy"){
			steps {
				withCredentials([
					usernamePassword(credentialsId: 'tagost', usernameVariable: 'USER', passwordVariable: 'PWD')
				]){
					script{
						gv.deployApp()
					}
				}
			}
		}
	}
	post {
		always {
			echo 'Post always printing'
		}
		success {
			echo 'Post success printing'
		}
		failure {
			echo 'Post failure printing'
		}
	}
}