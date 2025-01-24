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
                sh 'mvn clean install'
            }
        }
        stage('Build docker image')
            steps
            {
                script
                {
                    sh 'docker build -t 'myimage/devops-integration'
                }
            }
    }
}
