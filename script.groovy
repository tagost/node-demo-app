def buildApp(){
	echo 'building the aplication...'
}

def testApp(){
	echo 'Testing the aplication...'
}

def deployApp(){
	echo "deploying version ${params.VERSION}"
	echo 'Deploy the aplication...'
	echo "Credentials username: $USER password: $PWD"
}

return this