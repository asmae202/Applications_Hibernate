
# Applications Hibernate – Exercices Pratiques

Ce dépôt contient trois applications développées avec **Java, Hibernate/JPA** et **MySQL**, chacune illustrant un scénario différent de gestion de données persistantes et multi-couches.

---

## Sommaire

1. [Lab 1 — Gestion de stock](#exercice-1-gestion-de-stock)  
2. [Lab 2 — Gestion de projets](#exercice-2-gestion-de-projets)  
3. [Lab 3 — Gestion de l’état civil](#exercice-3-gestion-de-létat-civil)  

---

## Lab 1 — Gestion de stock

### Description

Cette application permet de gérer le stock d’un magasin de produits informatiques.  
Elle illustre :

- La persistance des **produits, catégories, commandes et lignes de commande**.  
- L’utilisation de **requêtes HQL et Named Queries** pour filtrer les produits selon la catégorie, le prix ou la commande.  
- L’affichage formaté des produits commandés.

### Fonctionnalités principales

- Afficher les produits par catégorie.  
- Afficher les produits commandés entre deux dates.  
- Afficher les produits d’une commande spécifique.  
- Afficher les produits dont le prix est supérieur à 100 DH (Named Query).  
- Programmes de test pour chaque fonctionnalité.



### Exemple d’affichage attendu


https://github.com/user-attachments/assets/5b751b24-6ad3-4172-ae65-ad738b3e2034



---

## Lab 2 — Gestion de projets

### Description

Cette application permet de suivre le temps passé sur les projets et calculer les coûts globaux.  
Elle illustre :

- La persistance des **Projets, Tâches, Employés, EmployéTache**.  
- La création de services avec méthodes génériques et spécifiques.  
- L’utilisation de **requêtes HQL et Named Queries** pour filtrer les tâches par prix ou période.  
- L’affichage formaté des tâches d’un projet ou d’un employé.

### Fonctionnalités principales

- Afficher les tâches réalisées par un employé.  
- Afficher les projets gérés par un employé.  
- Afficher les tâches planifiées pour un projet.  
- Afficher les tâches réalisées avec les dates réelles.  
- Afficher les tâches dont le prix > 1000 DH.  
- Afficher les tâches réalisées entre deux dates.

### Différence avec les autres exercices

- **Focus sur la gestion de projets et tâches**.  
- Relations plus complexes : **Projet ↔ Tâche ↔ Employé**.  
- Les requêtes filtrent **par prix et dates des tâches**, pas par produit ou stock.

### Exemple d’affichage attendu


https://github.com/user-attachments/assets/d4a4176d-1860-4d96-a7b3-78db67b17c68





---

## Lab 3 — Gestion de l’état civil

### Description

Cette application gère les citoyens et leurs relations matrimoniales.  
Elle illustre :

- La persistance des **Homme, Femme, Mariage**.  
- L’utilisation de **requêtes natives, Named Queries et Criteria API**.  
- La gestion de **relations complexes et statistiques** (nombre d’enfants, mariages multiples).  
- L’affichage détaillé des mariages d’un homme et des femmes mariées plusieurs fois.

### Fonctionnalités principales

- Afficher les épouses d’un homme entre deux dates.  
- Nombre d’enfants d’une femme entre deux dates (Native Query).  
- Afficher les femmes mariées deux fois ou plus (Named Query).  
- Afficher le nombre d’hommes mariés à quatre femmes entre deux dates (Criteria API).  
- Afficher les mariages d’un homme avec tous les détails (dates, enfants, statut).

### Différence avec les autres exercices

- **Focus sur les relations humaines et l’état civil**.  
- Relations **complexes et multiples** entre entités.  
- Requêtes avancées utilisant **Criteria API et requêtes natives**.  
- Moins orienté « produit ou projet », plus orienté **statistiques et reporting familial**.

### Exemple d’affichage attendu



https://github.com/user-attachments/assets/81f945b0-347b-418d-8014-3ae932df8e8b







            
