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
        stage('stop docker container'){
            steps{
                script{
                    bat 'docker rm -f devops-integration || true'
                }
            }
        }
        stage('start docker container'){
            steps{
                script{
                    bat 'docker run --name devops-integration -p 8081:8081'
                }
            }
        }
    }
}
