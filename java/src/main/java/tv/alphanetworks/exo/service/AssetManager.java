package tv.alphanetworks.exo.service;

import org.springframework.stereotype.Service;
import tv.alphanetworks.exo.dao.DAOException;
import tv.alphanetworks.exo.dto.AssetDTO;

import java.util.List;

@Service
public interface AssetManager {

    AssetDTO trouver(long id ) throws DAOException;
    void creer( AssetDTO asset ) throws DAOException;
    List<AssetDTO> lister() throws DAOException;
    void supprimer( long id ) throws DAOException;
}
