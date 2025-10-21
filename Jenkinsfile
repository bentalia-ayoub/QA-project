pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/bentalia-ayoub/QA-project.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install -g newman newman-reporter-html'
            }
        }

        stage('Run Postman Tests') {
            steps {
                dir('Phase3_Tests_API') {
                    sh '''
                    newman run postman_collections/Reqres_Collection.json \
                    -e postman_collections/Reqres_Env.json \
                    -r cli,html \
                    --reporter-html-export reports/reqres-report.html
                    '''
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'Phase3_Tests_API/reports/*.html', allowEmptyArchive: true
        }
        failure {
            echo '❌ Tests échoués. Vérifie le rapport HTML dans les artefacts Jenkins.'
        }
        success {
            echo '✅ Tous les tests Postman ont réussi.'
        }
    }
}
