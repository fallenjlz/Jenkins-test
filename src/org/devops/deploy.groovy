package org.devops

def Deploy(hosts,func){
  sh "ansible ${hosts} func"
}
