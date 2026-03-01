package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    void create(T t);          // Ajouter un objet
    void update(T t);          // Modifier un objet
    void delete(T t);          // Supprimer un objet
    T findById(int id);        // Trouver un objet par son ID
    List<T> findAll();         // Retourner tous les objets
}