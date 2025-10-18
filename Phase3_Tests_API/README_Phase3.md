# Phase 3 – Automatisation des Tests API avec Postman & Newman

## 🎯 Objectif
Automatiser les tests des endpoints REST publics de **Reqres.in** à l’aide de **Postman** et **Newman**, afin de valider le bon fonctionnement de l’API et d’obtenir un rapport d’exécution automatisé.

---

## 🧩 Outils utilisés
- **Postman** : Création et exécution des requêtes API.
- **Newman** : Exécution automatisée des tests Postman en ligne de commande.
- **newman-reporter-htmlextra** : Génération d’un rapport HTML détaillé.
- **Node.js / npm** : Gestion des dépendances et environnement d’exécution.

---

## 🧱 Structure du dossier


---

## ⚙️ Étapes principales

1. Création des requêtes Postman :
   - `GET https://reqres.in/api/users?page=2`
   - `GET https://reqres.in/api/users/2`
   - `POST https://reqres.in/api/users`
   - `PUT https://reqres.in/api/users/2`
   - `DELETE https://reqres.in/api/users/2`
   - `POST https://reqres.in/api/login` (succès et échec)
2. Ajout des tests Postman pour vérifier :
   - Statut HTTP (200, 201, 204…)
   - Structure JSON (`data`, `id`, `token`, etc.)
3. Export de la collection et de l’environnement.
4. Exécution automatisée avec :
   ```bash
   newman run collections/Reqres_Collection.json -e environments/Reqres_Env.json -r cli,htmlextra
