@Library('jenkinslib') _
def tools = new org.devops.tools()
def build = new org.devops.build()
pipeline {
    agent any
    parameters {
        string(name: 'BRANCH', defaultValue: 'main', description: 'branch choice')
        choice(name: 'buildType', choices: ['gradle', 'maven', 'ant'], description: 'Pick something')
    }
    stages {
        
        stage ("checkout"){
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${BRANCH}']], extensions: [], userRemoteConfigs: [[credentialsId: 'f3641d1f-0ffe-4732-82b2-7ec742e9a31a', url: 'git@github.com:fallenjlz/Jenkins-test.git']]])
            }
        }
        
         stage ("invoke share library"){
            steps {
                script{
                   currentBuild.displayName = "${BUILD_TAG}-${buildType}"
                   println("share test")
                   hello()
                   tools.PrintMes("share Library")
                    
                }
            }
         }
         
         stage ("build"){
            steps {
                script{
                   
                    sh '''
                        pwd
                        ls
                        env |grep -i build
                        '''
                    build.Build(buildType,buildShell)
                }
            }
         }
        
//         stage ("antbuild"){
//             steps {
//                 script{
//                     try{
//                         sh "ant ${buildShell}"
//                     } catch(e) {
//                         println(e)
//                     }
                    
//                 }
//             }
//          }

//          stage ("gradlebuild"){
//             steps {
//                 script{
//                     gradleHome = tool "GRADLE"
//                     sh "${gradleHome}/bin/gradle ${buildShell}"
//                 }
//             }
//          }
    }
}
