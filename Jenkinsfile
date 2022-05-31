@Library('Jenkins-test') _
def tools = new org.devops.tools()

pipeline {
    agent any
    parameters {
        string(name: 'BRANCH', defaultValue: 'main', description: 'branch choice')
    }
    stages {
        
        stage ("checkout"){
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${BRANCH}']], extensions: [], userRemoteConfigs: [[credentialsId: 'f3641d1f-0ffe-4732-82b2-7ec742e9a31a', url: 'git@github.com:fallenjlz/Jenkins-test.git']]])
            }
        }
         stage ("build"){
            steps {
                script{
                    currentBuild.displayName = "${BUILD_TAG}"
                    sh '''
                        pwd
                        ls
                        env |grep -i build
                        '''
                    sh "mvn ${buildShell}"
                    tools.PrintMes("share library")
                }
            }
         }
        
        stage ("antbuild"){
            steps {
                script{
                    try{
                        sh "ant ${buildShell}"
                    } catch(e) {
                        println(e)
                    }
                    
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
