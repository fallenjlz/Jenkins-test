package org.devops

def Build(buildType,buildShell){
    def buildTools = ["mvn":"mnv","ant":"ant","gradle":"GRADLE"]
    
    
    println("当前选择的构建类型为 ${buildType}")
    if ("${buildType}" == "gradle"){
        buildHome= tool buildTools[buildType]
        sh "${buildHome}/bin/${buildType}  ${buildShell}"
    }else {
        sh "${buildType} -v"
    }
 }
