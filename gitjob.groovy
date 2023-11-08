pipeline{
    agent any
    stages{
        stage('code-pull'){
            steps{
                git 'https://github.com/pritesh2311/student-ui.git'
            }
        }
        stage('listing'){
            steps{
                sh "pwd"
                sh "ls -lart"
            }
        }
        stage('build'){
            steps{
                sh "mvn clean package"
                sh "ls -lart"
            }
        }
    }
}