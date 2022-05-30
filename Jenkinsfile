pipeline {
    agent any
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
        // }

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
