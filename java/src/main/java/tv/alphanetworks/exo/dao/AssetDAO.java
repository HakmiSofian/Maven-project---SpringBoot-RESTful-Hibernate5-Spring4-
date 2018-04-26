package tv.alphanetworks.exo.dao;

import tv.alphanetworks.exo.model.Asset;

import java.util.List;


public interface AssetDAO {

    Asset trouver(long id ) throws DAOException;
    void creer( Asset asset ) throws DAOException;
    List<Asset> lister() throws DAOException;
    void supprimer( long id ) throws DAOException;
}

