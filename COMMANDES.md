# Commandes utiles — Soutenance Pokémon Shop

---

## Lancer l'application Spring Boot

```bash
.\mvnw spring-boot:run        # PowerShell Windows
./mvnw spring-boot:run        # Git Bash / Mac / Linux
```

---

## Swagger

```
http://localhost:9001/swagger-ui/index.html
```

---

## Endpoints API

### Cartes

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | http://localhost:9001/api/cards | Toutes les cartes |
| GET | http://localhost:9001/api/cards/{id} | Une carte par ID |
| POST | http://localhost:9001/api/cards | Créer une carte |
| PUT | http://localhost:9001/api/cards/{id} | Modifier une carte |
| DELETE | http://localhost:9001/api/cards/{id} | Supprimer une carte |

### Clients

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | http://localhost:9001/api/customers | Tous les clients |
| POST | http://localhost:9001/api/customers | Créer un client |

### Commandes

| Méthode | URL | Description |
|---------|-----|-------------|
| POST | http://localhost:9001/api/orders | Créer une commande |

---

## Body JSON

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

---

## MySQL CLI

```bash
mysql -u root -p              # Se connecter à MySQL
```

```sql
SHOW DATABASES;               # Lister les bases
CREATE DATABASE pokemon_shop; # Créer la base
USE pokemon_shop;             # Entrer dans la base
SHOW TABLES;                  # Lister les tables
DESCRIBE cards;               # Structure d'une table
SELECT * FROM cards;          # Voir les données
DROP DATABASE pokemon_shop;   # Supprimer la base
EXIT;                         # Quitter
```

---

## Git

```bash
git status                        # État des fichiers
git add .                         # Ajouter tous les fichiers
git commit -m "message"           # Créer un commit
git push                          # Envoyer sur GitHub
git log --oneline                 # Historique des commits
git init                          # Initialiser un dépôt
git remote add origin <url>       # Lier au dépôt GitHub
git push -u origin main           # Premier push
git rm --cached <fichier>         # Retirer un fichier du suivi
```
