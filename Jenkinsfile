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
                    bat 'docker build -t myimage/devops-integration .'
                }
            }
        }
        stage('Push image to dockerhub'){
            steps{
                script{
                   withDockerRegistry(credentialsId: 'registryCredentials') {
    					bat 'docker push myimage/devops-integration:latest'
				}
              }
          }
       }
    }
}
