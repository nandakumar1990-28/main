/* Requires the Docker Pipeline plugin */
pipeline {
    agent any
    tools
    {
        maven 'maven_build'
    }
    stages {
        stage('build') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nandakumar1990-28/main.git']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t devops-integration .'
		    bat 'docker tag devops-integration nandakumardj1990/myapp:v1'
                }
            }
        }
	stage('Push image to dockerhub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerpwd')]) {
    					bat 'docker login -u nandakumardj1990 -p ${dockerhubpwd}'
    					bat 'docker push nandakumardj1990/myapp:v1'
				}
              }
          }
       }    
    }
}
