pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '📦 Clonage du dépôt...'
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                echo '⚙️ Installation des dépendances Maven...'
                dir('Phase3_Tests_API/restassured_scripts') {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Run REST Assured Tests') {
            steps {
                echo '🧪 Exécution des tests REST Assured...'
                dir('Phase3_Tests_API/restassured_scripts') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Run Postman Tests') {
            steps {
                echo '📬 Exécution des tests Postman via Newman...'
                dir('Phase3_Tests_API/postman_collections') {
                    sh '''
                    newman run Reqres_Collection.json \
                        -e Reqres_Env.json \
                        -r cli,html \
                        --reporter-html-export newman_reports/report.html
                    '''
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'Phase3_Tests_API/postman_collections/newman_reports/report.html', fingerprint: true
                }
            }
        }
    }

    post {
        always {
            echo '✅ Pipeline terminé !'
        }
        failure {
            echo '❌ Le pipeline a échoué.'
        }
    }
}
