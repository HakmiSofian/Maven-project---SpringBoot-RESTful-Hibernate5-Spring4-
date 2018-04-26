package tv.alphanetworks.exo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tv.alphanetworks.exo.model.Asset;

@Repository
public class AssetDAOImpl implements AssetDAO {


    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Asset trouver(long id ) throws DAOException {

        Session session = sessionFactory.getCurrentSession();
        try {

            return session.load(Asset.class, id);


        } catch ( Exception e ) {

            throw new DAOException( e );

        }


    }

    @Override
    public void creer( Asset asset ) throws DAOException {

        Session session = sessionFactory.getCurrentSession();
        Asset a = trouver(asset.getId());
        if( a == null) {
            try {

                session.save(a);

            } catch (Exception e) {

                throw new DAOException(e);

            }
        }

    }

    @Override
    public List<Asset> lister() throws DAOException {

        Session session = sessionFactory.getCurrentSession();

        try {

            return session
                    .createCriteria(Asset.class)
                    .list();

        } catch ( Exception e ) {

            throw new DAOException( e );

        }

    }

    @Override
    public void supprimer( long id ) throws DAOException {

        Session session = sessionFactory.getCurrentSession();
        Asset a = trouver(id);

        if (a != null) {
            try {

                session.delete(a);

            } catch (Exception e) {

                throw new DAOException(e);

            }
        }

    }


}
