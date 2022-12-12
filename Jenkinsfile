pipeline{
    agent any

    stages{

       stage('Getting project from Github') {
            steps {
                git branch : 'spring' ,
                url : 'https://github.com/dhaferjlassi/Examen-Devops.git';
            }
        }
        
        stage('cleanig the project') {
            steps{
             sh 'mvn clean'
             sh'mvn install'
            }
       }
        stage('Compile'){
            steps {
             sh 'mvn compile -DskipTests'
            }
            
        }
        
        stage('JUNIT-MOCKITO'){
            steps{
             sh 'mvn test'
            }
        }
        
        stage('SonarQube Analysis'){
            steps {
             sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.16:9000 -Dsonar.login=admin -Dsonar.password=SonarQube'    
            }
        }
       
        stage('Nexus'){
            steps{
             sh 'mvn deploy'
            }
        }
        
        stage("Building image") {
            steps {
             sh 'docker build -t dhafer01/gestion .'
            }
        }
        
        stage('Docker Login') {
            steps {
		     sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u="dhafer01" -p="dhaferdhafer123" '
			}
		} 
	    
	    stage('Push') {
            steps {
		     sh 'docker push dhafer01/gestion'
			}
     	}
        
        stage('DOCKER COMPOSE') {
            steps {
             sh 'docker-compose up -d'
            }
        }
    }

}
