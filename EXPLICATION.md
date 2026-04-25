# Explication complète du projet Pokémon Shop

---

## C'est quoi ce projet ?

Une **API REST** = un programme qui reçoit des requêtes HTTP (GET, POST, PUT, DELETE)
et répond en JSON. On l'a construit avec **Spring Boot** (framework Java) connecté à une
base de données **MySQL**.

---

## ÉTAPE 1 — Créer le projet avec Spring Initializr

On est allé sur start.spring.io et on a coché les dépendances dont on avait besoin :

- **Spring Web** → pour faire une API REST (recevoir des requêtes HTTP)
- **Spring Data JPA** → pour parler à la base de données sans écrire de SQL
- **MySQL Driver** → pour se connecter à MySQL
- **Lombok** → pour ne pas écrire les getters/setters à la main

On a téléchargé le projet et ouvert le dossier `shop` dans l'IDE.

---

## ÉTAPE 2 — Corriger le pom.xml

Le `pom.xml` = le fichier qui liste toutes les librairies du projet (comme un `package.json` en JS).

Spring Initializr avait généré de mauvais noms. On a corrigé :
- `spring-boot-starter-webmvc` → `spring-boot-starter-web`
- Les dépendances de test incorrectes → `spring-boot-starter-test`
- On a ajouté **Swagger** : `springdoc-openapi-starter-webmvc-ui`

---

## ÉTAPE 3 — Créer la base de données MySQL

On a ouvert le terminal et tapé `mysql -u root -p` pour se connecter.

On a créé la base et les 3 tables :
- **cards** → stocke les cartes Pokémon (nom, type, rareté, prix)
- **customers** → stocke les clients (nom, email)
- **orders** → stocke les commandes (id client, ids des cartes, prix total)

---

## ÉTAPE 4 — Configurer application.properties

C'est le fichier de configuration de Spring Boot. On y a mis :
- Le nom de l'application
- Le port : **9001** (au lieu de 8080 par défaut)
- L'URL de connexion MySQL + identifiants
- `ddl-auto=update` → Spring crée/met à jour les tables automatiquement

On a caché ce fichier du git car il contient le mot de passe.

---

## ÉTAPE 5 — Les 4 couches (architecture)

On a créé 4 packages avec 3 fichiers chacun (Card, Customer, Order) :

### model/ — "C'est quoi ?"
Représente les tables MySQL en Java.
- `@Entity` = cette classe est une table en base
- `@Table(name="cards")` = le nom de la table
- `@Id` + `@GeneratedValue` = clé primaire auto-incrémentée
- `@Data` (Lombok) = génère automatiquement les getters/setters

### repository/ — "Comment accéder aux données ?"
Interface qui parle directement à MySQL.
- Extend `JpaRepository<Card, Long>` = Spring génère automatiquement toutes les requêtes SQL (findAll, findById, save, deleteById...)
- On n'écrit aucune requête SQL manuellement

### service/ — "Que faire avec les données ?"
Contient la logique métier.
- CardService : findAll, findById, save, delete
- CustomerService : findAll, save
- OrderService : calcule automatiquement le totalPrice en additionnant le prix de chaque carte

### controller/ — "Qui appelle depuis l'extérieur ?"
Reçoit les requêtes HTTP et répond en JSON.
- `@RestController` = ce controller répond en JSON
- `@RequestMapping("/api/cards")` = toutes les routes commencent par /api/cards
- `@GetMapping` = répond aux GET
- `@PostMapping` = répond aux POST
- `@PutMapping` = répond aux PUT
- `@DeleteMapping` = répond aux DELETE

---

## ÉTAPE 6 — Le chemin d'une requête

Quand Postman envoie `GET /api/cards` :

```
Postman
   ↓
CardController    → reçoit la requête HTTP
   ↓
CardService       → appelle findAll()
   ↓
CardRepository    → fait SELECT * FROM cards
   ↓
MySQL             → retourne les données
   ↓
CardController    → retourne la liste en JSON
   ↓
Postman           → affiche le résultat
```

---

## ÉTAPE 7 — Lancer et tester

On a lancé l'application avec `.\mvnw spring-boot:run`.
On a vu `Started ShopApplication on port 9001` → tout fonctionne.

On a testé avec **Postman** :
- POST /api/cards → créé Pikachu (25€) et Charizard (300€)
- POST /api/customers → créé Sacha et Ondine
- POST /api/orders → commande avec cardIds="1,2", totalPrice calculé automatiquement = 325€
- GET /api/cards → retourne les 2 cartes

On a vérifié **Swagger** sur `http://localhost:9001/swagger-ui/index.html` → tous les endpoints visibles.

---

## ÉTAPE 8 — Git et GitHub

- Initialisé un dépôt git propre dans le dossier `shop/`
- Caché `application.properties` dans `.gitignore` (contient le mot de passe)
- Créé `application.properties.example` avec des valeurs vides pour GitHub
- Pushé sur https://github.com/zalikal/tp_pok-mon_not-

---

## Résumé des annotations importantes

| Annotation | Rôle |
|---|---|
| `@SpringBootApplication` | Point d'entrée de l'application |
| `@Entity` | Classe = table en base de données |
| `@Table(name="x")` | Nom de la table |
| `@Id` | Clé primaire |
| `@GeneratedValue(IDENTITY)` | Auto-incrément |
| `@Data` | Lombok : génère getters/setters |
| `@RequiredArgsConstructor` | Lombok : injection par constructeur |
| `@Service` | Composant de logique métier |
| `@RestController` | Controller qui répond en JSON |
| `@RequestMapping` | Préfixe des routes |
| `@GetMapping` | Route GET |
| `@PostMapping` | Route POST |
| `@PutMapping` | Route PUT |
| `@DeleteMapping` | Route DELETE |
| `@PathVariable` | Récupère l'id dans l'URL (/api/cards/1) |
| `@RequestBody` | Récupère le JSON du body |
