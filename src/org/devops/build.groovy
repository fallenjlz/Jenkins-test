package org.devops

def Build(buildType,buildShell){
    def buildTools = ["mvn":"M2","ant":"ant","gradle":"GRADLE"]
    
    
    println("当前选择的构建类型为 ${buildType}")
    if ("${buildType}" == "ant "){
        sh "${buildTools[buildType]} ${buildShell}"
    }else {
         buildHome= tool buildTools[buildType]
         sh "${buildHome}/bin/${buildType}  ${buildShell}"
    }
 }
