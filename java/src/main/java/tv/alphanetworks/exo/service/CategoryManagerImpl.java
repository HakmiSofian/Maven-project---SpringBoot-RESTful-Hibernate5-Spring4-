package tv.alphanetworks.exo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.alphanetworks.exo.dao.CategoryDAO;
import tv.alphanetworks.exo.dao.DAOException;
import tv.alphanetworks.exo.dto.CategoryDTO;
import tv.alphanetworks.exo.model.Category;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CategoryManagerImpl implements CategoryManager {

    @Autowired
    private CategoryDAO categoryDAO;



    @Override
    public CategoryDTO trouver(long id) throws DAOException {

        return categoryTOcategoryDTO(categoryDAO.trouver(id));

    }

    @Transactional
    @Override
    public void creer(CategoryDTO categoryDTO) throws DAOException{

        this.categoryDAO.creer(categoryDTOTOcategory(categoryDTO));

    }

    @Override
    public List<CategoryDTO> lister() throws DAOException{

        return this.categoryDAO.lister()
                .stream()
                .map(category -> categoryTOcategoryDTO(category))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void supprimer(long id) throws DAOException{

        this.categoryDAO.supprimer(id);

    }


    private Category categoryDTOTOcategory(CategoryDTO categoryDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoryDTO, Category.class);

    }

    private CategoryDTO categoryTOcategoryDTO(Category category){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(category, CategoryDTO.class);

    }
}
