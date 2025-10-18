#!/bin/bash
echo "🚀 Lancement des tests API Reqres avec Newman..."

newman run ../collections/Reqres_Collection.json \
  -e ../environments/Reqres_Env.json \
  -r cli,htmlextra \
  --reporter-htmlextra-export ../reports/report.html

echo "✅ Tests terminés. Rapport généré dans le dossier reports/"
