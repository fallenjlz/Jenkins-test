pipeline {
    agent any
    parameters {
        string(name: 'BRANCH', defaultValue: 'main', description: 'branch choice')
    }
    stages {


        // stage('Example') {
        //     input {
        //         message "Should we continue?"
        //         ok "Yes, we should."
        //         submitter "alice,bob"
        //         parameters {
        //             string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
        //         }
        //     }
        //     steps {
        //         echo "Hello, ${PERSON}, nice to meet you."
        //     }
        //    
        stage ("checkout"){
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${BRANCH}']], extensions: [], userRemoteConfigs: [[credentialsId: 'f3641d1f-0ffe-4732-82b2-7ec742e9a31a', url: 'git@github.com:fallenjlz/Jenkins-test.git']]])
            }
        }
         stage ("build"){
            steps {
                script{
                    sh "mvn ${buildShell}"
                }
            }
         }

         stage ("gradlebuild"){
            steps {
                script{
                    gradleHome = tool "GRADLE"
                    sh "${gradleHome}/bin/gradle ${buildShell}"
                }
            }
         }
    }
}
