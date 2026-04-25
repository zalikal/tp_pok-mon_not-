# Commandes utiles — Soutenance Pokémon Shop

---

## MySQL CLI

```bash
mysql -u root -p                          # Se connecter à MySQL
```

```sql
SHOW DATABASES;                           # Lister toutes les bases de données
CREATE DATABASE pokemon_shop;             # Créer la base de données
DROP DATABASE pokemon_shop;               # Supprimer la base de données
USE pokemon_shop;                         # Entrer dans la base
SHOW TABLES;                              # Lister les tables
DESCRIBE cards;                           # Voir la structure d'une table
SELECT * FROM cards;                      # Voir toutes les données d'une table
EXIT;                                     # Quitter MySQL
```

---

## Lancer l'application Spring Boot

```bash
# Depuis la racine du projet (dossier shop/)
./mvnw spring-boot:run                    # Sur Git Bash / Mac / Linux
.\mvnw spring-boot:run                    # Sur PowerShell Windows
```

---

## Git

```bash
git init                                  # Initialiser un dépôt git
git remote add origin <url>               # Lier au dépôt GitHub
git add .                                 # Ajouter tous les fichiers
git commit -m "message"                   # Créer un commit
git push -u origin main                   # Premier push vers GitHub
git push                                  # Push suivants
git status                                # Voir l'état des fichiers
git log --oneline                         # Voir l'historique des commits
git rm --cached <fichier>                 # Retirer un fichier du suivi git
```

---

## Endpoints API — Postman

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | http://localhost:9001/api/cards | Toutes les cartes |
| GET | http://localhost:9001/api/cards/{id} | Une carte par ID |
| POST | http://localhost:9001/api/cards | Créer une carte |
| PUT | http://localhost:9001/api/cards/{id} | Modifier une carte |
| DELETE | http://localhost:9001/api/cards/{id} | Supprimer une carte |
| GET | http://localhost:9001/api/customers | Tous les clients |
| POST | http://localhost:9001/api/customers | Créer un client |
| POST | http://localhost:9001/api/orders | Créer une commande |

---

## Swagger

```
http://localhost:9001/swagger-ui/index.html
```

---

## Body JSON Postman

**Créer une carte :**
```json
{
    "name": "Pikachu",
    "type": "Electric",
    "rarity": "Rare",
    "price": 25
}
```

**Créer un client :**
```json
{
    "name": "Sacha",
    "email": "sacha@pokemon.com"
}
```

**Créer une commande :**
```json
{
    "customerId": 1,
    "cardIds": "1,2"
}
```
