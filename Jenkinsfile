pipeline {
    agent any

    tools {
        maven 'Maven 3.5.2'
        jdk 'JDK 21'
    }

    environment {
        LANG = "en_US.UTF-8"
    }
    stages{
        stage('Checkout') {
                steps {
                    git branch: 'master', url: 'https://github.com/MariuszSolvd/native-test-2'
                }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Start Simulator') {
            steps{
                sh '''
                    xcrun simctl shutdown all
                    xcrun simctl erase all
                    xcrun simctl boot "iPhone 15 Pro Max"
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test -Dsuite=testng'
            }
        }
    }



}