def call(String repoUrl){
pipeline {
    agent any 
    tools {
        maven 'maven'
    }
    stages {
        stage("Tools initialization") {
            steps {
                sh 'mvn --version'
                sh 'java -version'
            }
        }
        stage("Checkout Code") {
            steps {
                git branch: 'main',
                        url: "${repoUrl}"
            }
        }
        stage("demo-newapp") {
            steps {
                sh 'cat /etc/passwd'
                echo "jenkins was an easy module"
            }
        }
        stage("to-test-maven") {
            steps {
                sh 'mvn -v'
            }
        }
    }
}
}
