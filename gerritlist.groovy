 
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.1')

import groovyx.net.http.RESTClient
import static groovyx.net.http.Method.*
import static groovyx.net.http.ContentType.*
import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import hudson.model.Environment
import groovy.io.FileType
import java.io.File
import hudson.FilePath
import groovy.xml.MarkupBuilder
import java.text.SimpleDateFormat
import  hudson.*
import hudson.model.* 

def getGerritChangeList(){
  def host = "androidhub.harman.com"
  def proc = "ssh -p 29418 svc_cpmshint@androidhub.harman.com gerrit query --format=JSON status:open branch:titan_platform_oCar ".execute()
  def buffer = new StringBuffer()
  proc.consumeProcessErrorStream(buffer)
  println proc.text.split("status ")
  def result = []
  def jsonSlurper = new JsonSlurper()
  def json =  jsonSlurper.parseText(proc.text)
  result.add(json)
      

//  println result
  return result
}
getGerritChangeList()
