package tv.alphanetworks.exo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tv.alphanetworks.exo.dao.AssetDAO;
import tv.alphanetworks.exo.dao.AssetDAOImpl;
import tv.alphanetworks.exo.dao.CategoryDAO;
import tv.alphanetworks.exo.dao.CategoryDAOImpl;
import tv.alphanetworks.exo.model.Category;

@Configuration
public class ConfTest {

    @Bean
    public CategoryDAO categoryDAO(){
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        return categoryDAO;
    }

    @Bean
    public AssetDAO assetDAO(){
        AssetDAO assetDAO = new AssetDAOImpl();
        return assetDAO;
    }
}
