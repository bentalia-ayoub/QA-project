# 🌐 Scénarios de test API – Reqres.in

API test : https://reqres.in/

## 🎯 Objectif
Vérifier les principales opérations CRUD de l’API REST Reqres.

---

### 🔹 Scénario 1 : GET /users
| Élément | Description |
|----------|--------------|
| **ID** | API-001 |
| **Objectif** | Vérifier la récupération de la liste des utilisateurs |
| **Méthode** | GET |
| **URL** | https://reqres.in/api/users?page=2 |
| **Résultat attendu** | Code 200, structure JSON correcte, liste d’utilisateurs présente |

---

### 🔹 Scénario 2 : POST /users
| Élément | Description |
|----------|--------------|
| **ID** | API-002 |
| **Objectif** | Créer un nouvel utilisateur |
| **Méthode** | POST |
| **Corps JSON** | `{ "name": "Ayoub", "job": "QA Engineer" }` |
| **Résultat attendu** | Code 201, retour JSON contenant `id` et `createdAt` |

---

### 🔹 Scénario 3 : PUT /users/2
| Élément | Description |
|----------|--------------|
| **ID** | API-003 |
| **Objectif** | Modifier les informations d’un utilisateur |
| **Méthode** | PUT |
| **Corps JSON** | `{ "name": "Ayoub", "job": "Senior QA" }` |
| **Résultat attendu** | Code 200, retour JSON avec `updatedAt` |

---

### 🔹 Scénario 4 : DELETE /users/2
| Élément | Description |
|----------|--------------|
| **ID** | API-004 |
| **Objectif** | Supprimer un utilisateur existant |
| **Méthode** | DELETE |
| **Résultat attendu** | Code 204 (no content) |

---

### 🔹 Scénario 5 : GET /users/23 (inexistant)
| Élément | Description |
|----------|--------------|
| **ID** | API-005 |
| **Objectif** | Vérifier la gestion des erreurs pour un utilisateur inexistant |
| **Méthode** | GET |
| **URL** | https://reqres.in/api/users/23 |
| **Résultat attendu** | Code 404, message d’erreur approprié |
