package tv.alphanetworks.exo.dao;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tv.alphanetworks.exo.configuration.ConfTest;
import tv.alphanetworks.exo.configuration.DatabaseConfiguration;
import tv.alphanetworks.exo.model.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguration.class, ConfTest.class})
public class CategoryDAOImplTest  {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CategoryDAO categoryDAO;

    @Test
    void testTrouver() {

        long id1 = 8;
        long id2 = 2;

        Category category1 = categoryDAO.trouver(id1);
        Category category2 = categoryDAO.trouver(id1);

        assertNotNull("Category 1 should be not null", category1);
        assertEquals(id1 , category1.getId() );
        assertNotNull("Category 2 should be not null", category1);
        assertEquals(id2, category2.getId() );

    }
    @Test
    void testCreer() {
    }

    void testLister() {
    }

    void testSupprimer() {
    }
}
