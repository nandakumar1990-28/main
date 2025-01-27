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
                    bat 'docker build -t myimage/devops-integration:latest .'
		    bat 'docker tag myimage/devops-integration:latest nandakumar1990/myapp:latest'
                }
            }
        }
        stage('Push image to dockerhub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerpwd')]) {
			   		bat 'docker logout'
    					bat 'docker login https://registry.hub.docker.com -u nandakumardj1990 -p Lithu@2025'
    					bat 'docker push nandakumar1990/myapp:latest'
				}
              }
          }
       }
    }
}
