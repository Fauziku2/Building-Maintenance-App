pipeline {
	agent any
	tools {
		maven 'maven 3.9.9'
		jdk 'Java JDK 17'
	}
	stages {
		stage("clean") {
			steps {
				echo "Start Clean"
				sh "mvn clean"
			}
		}
		stage("test") {
			steps {
				echo "Start Test"
				sh "mvn test"
			}
			
		}
		stage("build") {
			steps {
				echo "Start build"
				sh "mvn install -DskipTests"
			}
		}
		stage("sonar") {
            steps {
                script {
                    // Prepare SonarQube environment
                    def sonarProperties = """
                        sonar.projectKey=maven-project-jenkins-lab
                        sonar.projectName=maven-project-jenkins-lab
                        sonar.projectVersion=1.0
                        sonar.sources=src/main
                        sonar.sourceEncoding=UTF-8
                        sonar.language=java
                        
                        sonar.tests=src/test
                        sonar.junit.reportsPath=target/surefire-reports
                        sonar.surefire.reportsPath=target/surefire-reports
                        sonar.jacoco.reportPath=target/jacoco.exec
                        
                        sonar.java.binaries=target/classes
                        sonar.java.coveragePlugin=jacoco
                    """

                    // Create sonar-project.properties file
                    writeFile file: 'sonar-project.properties', text: sonarProperties

                    // Run SonarQube scan using the properties file
                    withSonarQubeEnv('sonarqube_server') {
                    	sh "mvn sonar:sonar"
                	}
                }
             }
 		}
 		/*
		stage('sonar') {
            environment {
                SONAR_HOST_URL = "http://localhost:9000"
                SONAR_AUTH_TOKEN = credentials("sonarqube_token")
            }
            steps {
				echo "Start sonar"
              	sh "mvn sonar:sonar -Dsonar.projectKey=maven-project-jenkins-lab -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN"
            }
        }
        */
        stage('deployment') {
			steps {
				deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8090')], contextPath: "BuildingMaintenanceApp", war: '**/*.war'
			}
		}
		/*
		stage('Deploy to Tomcat') {
			steps {
				script {
					// Find the WAR file
            		//def warFile = findFiles(glob: 'target/*.war')[0]
            		def warFile = 'target\\inventory-project.war'
            		//echo "Deploying WAR file: ${warFile.path}"
 
					// Tomcat Manager URL and credentials
					def tomcatUrl = 'http://localhost:8090/manager/text'
					def tomcatUser = 'tomcat'
					def tomcatPassword = 'password'
 
					// Deploy the WAR file using curl
					bat """
					curl -v -u ${tomcatUser}:${tomcatPassword} \
					-T ${warFile} \
					${tomcatUrl}/deploy?path=/InventoryProject
					"""
				}
			}
		}
		*/
	}
}