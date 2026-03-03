
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

### Différence avec les autres exercices

- **Focus sur les stocks et produits**.  
- Gestion simple des relations **Produit ↔ Commande**.  
- Requêtes centrées sur le **prix, la catégorie et la date de commande**.

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



https://github.com/user-attachments/assets/d4a4176d-1860-4d96-a7b3-78db67b17c68

























## Sommaire

1. [Exercice 1 — Gestion de stock](#exercice-1-gestion-de-stock)  
2. [Exercice 2 — Gestion de projets](#exercice-2-gestion-de-projets)  
3. [Exercice 3 — Gestion de l’état civil](#exercice-3-gestion-de-létat-civil)  

---
RUN EX1:

TEST LIGNECOMMANDE:


![EX1 EVALUATION TEST LIGNECOMMANDE SERVICE1](https://github.com/user-attachments/assets/cb544a42-9ed8-481a-ace5-7c8ba7475d5e)


![EX1 EVALUATION TEST LIGNECOMMANDE SERVICE2](https://github.com/user-attachments/assets/3cc01a99-7b23-4ff9-b443-4a4c85f73f31)

![EX1 EVALUATION TEST LIGNECOMMANDE SERVICE3](https://github.com/user-attachments/assets/ccf0aaae-a227-46ef-9678-9910d5caf559)


![EX1 EVALUATION TEST LIGNECOMMANDE SERVICE4](https://github.com/user-attachments/assets/b93d1d49-8fe0-46ac-b8af-8889a4087f6c)



TEST PRODUIT:

![EX1 EVALUATION TEST PRODUIY SERVICE1](https://github.com/user-attachments/assets/c97f6f09-9e67-4e7b-a29d-1868761466e1)

![EX1 EVALUATION TEST PRODUIY SERVICE2](https://github.com/user-attachments/assets/112b0f0a-265a-40e9-9e15-629973553eff)


![EX1 EVALUATION TEST PRODUIY SERVICE3](https://github.com/user-attachments/assets/91a33921-0e31-4de3-8632-9d8d69ee5f6e)


![EX1 EVALUATION TEST PRODUIY SERVICE4](https://github.com/user-attachments/assets/9b283413-dc6b-4eec-91f2-b74eed85941a)


![EX1 EVALUATION TEST PRODUIY SERVICE5](https://github.com/user-attachments/assets/d0d00398-b275-483d-ada3-b5584e95de9d)


 ![EX1 EVALUATION TEST PRODUIY SERVICE6](https://github.com/user-attachments/assets/8402efeb-1eeb-415b-98ad-6e51ccbe797b)

![EX1 EVALUATION TEST PRODUIY SERVICE7](https://github.com/user-attachments/assets/b8c0f36a-f4dc-49ba-a946-0831851816e9)

TEST CATEGORIE:

![TEST CATEGORIESERVICE 1](https://github.com/user-attachments/assets/ed79cf21-1557-4792-a75c-21ddad12c26f)



![EX1 TEST CATEGORIE SERVICE2](https://github.com/user-attachments/assets/54f2bc02-1c9d-4ff5-9a25-7a5ef2329dd9)

TEST COMMANDE:


![EX1 EVALUATION TEST COMMANDE SERVICE1](https://github.com/user-attachments/assets/ea172ee0-3b5d-47aa-9555-02d47e7d4ce6)


![EX1 EVALUATION TEST COMMANDE SERVICE2](https://github.com/user-attachments/assets/a6f31408-af94-46ff-be27-54a5f87f3703)

BASE DE DONNES:

![BD EX1 SC1](https://github.com/user-attachments/assets/11013ecd-7301-487a-9441-d4e2129a9515)


![BD EX1 SC2](https://github.com/user-attachments/assets/9c77a124-5feb-4c7f-a21a-790d6a213783)



![BD EX1 SC3](https://github.com/user-attachments/assets/2eef47fb-de21-4f1f-ab0e-e85977438956)


![BD EX1 SC4](https://github.com/user-attachments/assets/77ce7a3a-6f02-44c3-a09e-7bf14a92739e)

RUN EX2:
TEST EMPLOYE:

![EX2 TEST EMPLOYE SC1](https://github.com/user-attachments/assets/f88af733-f909-49ea-969a-a244f1d84584)



![EX2 TEST EMPLOYE SC2](https://github.com/user-attachments/assets/ac447bfa-7564-47df-8a6e-9f36d6e70131)



![EX2 TEST EMPLOYE SC3](https://github.com/user-attachments/assets/b181b4b3-43d1-40e2-9bde-3dd6a5d8d818)



![EX2 TEST EMPLOYE SC4](https://github.com/user-attachments/assets/6bdee061-085e-4896-b157-64e4768648a5)

TEST EMPLOYETACHE:

![EX2 TEST EMPLOYE TACHE SERVICE SC1](https://github.com/user-attachments/assets/f95e5ee1-9376-4be5-be44-5a27ff25fb9b)


TEST PROJET:

![EX2 TEST PROJET SERVICE SC1](https://github.com/user-attachments/assets/c822b049-0a09-42c4-8b6f-123117328203)


![EX2 TEST PROJET SERVICE SC2](https://github.com/user-attachments/assets/69ade139-1260-4569-b318-b71d36703c1a)


TEST TACHE:



![EX2 TEST TACHE SERVICE SC2](https://github.com/user-attachments/assets/cfda8a9c-8d37-4042-967a-b1268ff028c6)



![EX2 TEST TACHE SERVICE SC3](https://github.com/user-attachments/assets/0b297e99-8033-4105-a992-fddc1158e390)

BASE DE DONNEES:


![DB EX2 SC1](https://github.com/user-attachments/assets/5ff04046-fe75-439b-9688-47f617a36758)



![BD EX2 SC2](https://github.com/user-attachments/assets/d7b5fffd-0d56-4e33-bb83-f1c0bee27253)


![BD EX2 SC3](https://github.com/user-attachments/assets/26ceb951-0b04-4c2f-9dd0-3b1f59cd4218)


<img width="1557" height="597" alt="BD EX2 SC 4" src="https://github.com/user-attachments/assets/0a4b916f-b10d-46dc-9c6d-98cfbfa602f4" />

 
 
 RUN TEST HOMME EX3:

https://github.com/user-attachments/assets/497f7c6f-4f85-4d41-80df-149f7a1ad4e1



RUN TEST MARRIAGE EX3:


https://github.com/user-attachments/assets/172184ce-c3c3-442d-9b4c-5bdd75dcc14a

RUN TEST FEMME EX3:
![EX3 TEST FEMME 1](https://github.com/user-attachments/assets/609dd7cd-2a03-4415-a922-f6adac61662e)
![EX3 TEST FEMME 2](https://github.com/user-attachments/assets/0ea94e7e-dc41-4c5d-8823-6e62e43d77a2)
![EX3 TEST FEMME 3](https://github.com/user-attachments/assets/fc003506-75a5-4d87-93e8-e7939c6c2edc)
![EX3 TEST FEMME 4](https://github.com/user-attachments/assets/1b328bfe-cc05-46c6-b599-17595ab64d4b)
![EX3 TEST FEMME 5](https://github.com/user-attachments/assets/3daf7038-76f8-4cc6-ac9c-a79046b73aca)
![EX3 TEST FEMME 6](https://github.com/user-attachments/assets/907917d1-514b-4d18-895d-d82bfeb6877b)





![EX3 TEST FEMME 7](https://github.com/user-attachments/assets/3250b7db-7635-4698-846f-8b007ba9d870)



![EX3 TEST FEMME 8](https://github.com/user-attachments/assets/2060c9d1-d8f2-438e-a071-c0bea7aeb6a2)





![EX3 TEST FEMME 9](https://github.com/user-attachments/assets/182dd27d-a93f-40f0-900e-c7e66df83660)



![EX3 TEST FEMME 10](https://github.com/user-attachments/assets/d81dfa05-c6e0-48d5-94cf-5d40c934adf6)



![EX3 TEST FEMME 11](https://github.com/user-attachments/assets/848d54d6-c928-45aa-94ff-8c3eacf2cfaa)


![EX3 TEST FEMME 12](https://github.com/user-attachments/assets/72fb9c9f-d4e1-4c02-ac7b-ebad0c3a8ae5)



![EX3 TEST FEMME 13](https://github.com/user-attachments/assets/dc67936a-3930-4a8d-acff-d6fa6c9d92e8)






            
