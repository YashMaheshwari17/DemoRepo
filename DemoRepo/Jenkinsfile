pipeline{
	agent any
	environment{
		PATH = "D:/Software/apache-maven-3.9.5/bin$PATH"

	}
	stages{
		stage('Checkout'){
			steps{
				checkout scm
			}
		}
		stage('Build'){
			steps{
				bat "C:\\System32\\cmd.exe /c mvn clean test"
			}
		}
	}
}
