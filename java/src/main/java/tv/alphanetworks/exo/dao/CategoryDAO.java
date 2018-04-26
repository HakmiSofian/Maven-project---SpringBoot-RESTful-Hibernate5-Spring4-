package tv.alphanetworks.exo.dao;

import tv.alphanetworks.exo.model.Category;

import java.util.List;

public interface CategoryDAO {
    Category trouver(long id) throws DAOException;

    void creer(Category category) throws DAOException;

    List<Category> lister() throws DAOException;

    void supprimer(long id) throws DAOException;
}
