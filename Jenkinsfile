pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='ratnakar007/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialId:'dockerhub', passwordVariable:'Password', usernameVariable:'Username')])
                echo Username + " -- " Password
                sh "docker login --username=${user} --password=${pass}"
                sh "docker push ratnakar007/selenium-docker:latest"
            }
        }
    }
}