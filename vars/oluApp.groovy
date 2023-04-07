ef call(String repoUrl){
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
        stage("testing jenkins") {
            steps {
                sh 'dh -f'
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