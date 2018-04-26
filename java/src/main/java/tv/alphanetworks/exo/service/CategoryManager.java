package tv.alphanetworks.exo.service;

import tv.alphanetworks.exo.dao.DAOException;
import tv.alphanetworks.exo.dto.CategoryDTO;

import java.util.List;

public interface CategoryManager {
    CategoryDTO trouver(long id) throws DAOException;
    void creer(CategoryDTO categoryDTO) throws DAOException;
    List<CategoryDTO> lister() throws DAOException;
    void supprimer(long id) throws DAOException;
}
