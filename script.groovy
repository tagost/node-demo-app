def buildApp(){
	echo "building the aplication $params.VERSION"
}

def testApp(){
	echo 'Testing the aplication...'
}

def deployApp(){
	echo "deploying TAG ${params.TAG}"
	echo 'Deploy the aplication...'
	echo "Credentials username: $USER password: $PWD"
}

return this