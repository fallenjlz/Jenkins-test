package org.devops

def deploy(hosts,func){
  sh "ansible ${hosts} func"
}
