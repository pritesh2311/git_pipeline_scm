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
                sh "cp ./target/*.war /opt/tomcat/webapps/"
                sh "cd /opt/tomcat/webapps"
                sh "chmod 777 *.war"
                sh "cd /opt/tomcat/bin"
                sh "./startup.sh"
            }
        }
    }
}