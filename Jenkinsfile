pipeline {

  environment {
    registry = 'aterefe/ordering-system'
    registryCredential = 'dockerhub'
    dockerImage = ''
  }

  agent any

  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/abelbryo/hello-akka-http'
      }
    }

    stage('Test'){
      steps {
        echo '[ SBT TEST ]'
          sh 'sbt test'
      }
    }

    stage('Docker Stage') {
      steps {
        echo '[ DOCKER BUILD ]'
          sh 'sbt docker:stage'
      }
    }

    stage('Docker build') {
      steps {
        script {
          sh 'sbt docker:publishLocal'
          // sh """docker build -t foo-bar-$BUILD_NUMBER target/docker/stage/"""
        }
      }
    }
  }

}
