package ma.projet.dao;

import java.util.List;

// Interface générique CRUD
public interface IDao<T> {

    // Ajouter un objet en base
    boolean create(T o);

    // Mettre à jour un objet existant
    boolean update(T o);

    // Supprimer un objet
    boolean delete(T o);

    // Trouver un objet par son ID
    T findById(int id);

    // Lister tous les objets
    List<T> findAll();
}
