# 🧪 Scénarios de test UI – Formy Project

Application test : https://formy-project.herokuapp.com/

## 🎯 Objectif
Vérifier le bon fonctionnement des principaux éléments de l’interface utilisateur :
- Formulaires
- Boutons
- Pop-ups
- Sélecteurs (liste déroulante, radio, checkbox)

---

### 🧩 Scénario 1 : Test de connexion (Login)
| Élément | Description |
|----------|--------------|
| **ID** | UI-001 |
| **Objectif** | Vérifier que l’utilisateur peut se connecter avec des identifiants valides |
| **Préconditions** | L’utilisateur dispose d’un compte valide |
| **Étapes** | 1. Accéder à la page Login<br>2. Entrer `user@test.com` / `password123`<br>3. Cliquer sur "Login" |
| **Résultat attendu** | L’utilisateur est redirigé vers la page d’accueil avec un message de bienvenue |

---

### 🧩 Scénario 2 : Test du formulaire d’inscription
| Élément | Description |
|----------|--------------|
| **ID** | UI-002 |
| **Objectif** | Vérifier que le formulaire d’inscription fonctionne correctement |
| **Étapes** | 1. Accéder à la page “Form”<br>2. Remplir les champs obligatoires<br>3. Soumettre le formulaire |
| **Résultat attendu** | Message “Form successfully submitted” affiché |

---

### 🧩 Scénario 3 : Vérification des boutons
| Élément | Description |
|----------|--------------|
| **ID** | UI-003 |
| **Objectif** | Vérifier que les boutons de navigation fonctionnent |
| **Étapes** | Cliquer sur chaque bouton du menu |
| **Résultat attendu** | Chaque bouton redirige vers la page correspondante sans erreur |

---

### 🧩 Scénario 4 : Test des pop-ups
| Élément | Description |
|----------|--------------|
| **ID** | UI-004 |
| **Objectif** | Vérifier que les pop-ups s’ouvrent et se ferment correctement |
| **Étapes** | 1. Cliquer sur le bouton "Modal"<br>2. Fermer la pop-up |
| **Résultat attendu** | La pop-up s’ouvre et se ferme sans bug |

---

### 🧩 Scénario 5 : Test des listes déroulantes
| Élément | Description |
|----------|--------------|
| **ID** | UI-005 |
| **Objectif** | Vérifier que les listes déroulantes affichent les bonnes options |
| **Étapes** | 1. Accéder à la page Dropdown<br>2. Sélectionner une option |
| **Résultat attendu** | L’option sélectionnée est affichée correctement |
