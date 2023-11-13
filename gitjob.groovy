pipeline{
    agent any
    stages{
        stage('code-pull'){
            steps{
                git 'https://github.com/pritesh2311/onlinebookstore.git'
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
        stage('deploy'){
            steps{
                sh "chmod 777 ./target/*.war"
                sh "chmod 777 /opt/tomcat"
                sh "sudo cp ./target/*.war /opt/tomcat/webapps/"
                sh "sudo cd /opt/tomcat/bin"
                sh "sudo ./startup.sh"
            }
        }
    }
}