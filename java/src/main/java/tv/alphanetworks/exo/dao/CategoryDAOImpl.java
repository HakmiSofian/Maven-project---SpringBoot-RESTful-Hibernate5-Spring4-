package tv.alphanetworks.exo.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tv.alphanetworks.exo.model.Category;

import java.util.List;

@Repository("assetDao")
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Category trouver(long id) throws DAOException {

        Session session = sessionFactory.getCurrentSession();
        try {

            return session.load(Category.class, id);


        } catch ( Exception e ) {

            throw new DAOException( e );

        }


    }

    @Override
    public void creer(Category category) throws DAOException {

        Session session = sessionFactory.getCurrentSession();
        Category c = trouver(category.getId());
        if( c == null) {
            try {


                session.save(c);

            } catch (Exception e) {

                throw new DAOException(e);

            }
        }

    }

    @Override
    public List<Category> lister() throws DAOException {

        Session session = sessionFactory.getCurrentSession();

        try {

            return session.createCriteria(Category.class).list();

        } catch ( Exception e ) {

            throw new DAOException( e );

        }

    }

    @Override
    public void supprimer(long id) throws DAOException {

        Session session = sessionFactory.getCurrentSession();
        Category c = trouver(id);

        if( c != null) {
            try {
                c.getAssets().clear();
                session.delete(c);

            } catch (Exception e) {

                throw new DAOException(e);

            }
        }

    }
}
