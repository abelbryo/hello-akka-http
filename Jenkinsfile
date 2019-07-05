pipeline {

  environment {
    registryCredential = 'dockerhub'
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
          docker.withRegistry('', registryCredential) {
            sh 'sbt docker:publish'
          }
        }
      }
    }
  }

}
