package tv.alphanetworks.exo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.alphanetworks.exo.dao.AssetDAO;
import tv.alphanetworks.exo.dao.DAOException;
import tv.alphanetworks.exo.dto.AssetDTO;
import tv.alphanetworks.exo.model.Asset;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AssetManagerImpl implements AssetManager{

    @Autowired
    private AssetDAO assetDAO;



    @Override
    public AssetDTO trouver(long id) throws DAOException {

        return assetTOassetDTO(assetDAO.trouver(id));

    }

    @Transactional
    @Override
    public void creer(AssetDTO assetDTO ) throws DAOException{

        this.assetDAO.creer(assetDTOTOasset(assetDTO));

    }

    @Override
    public List<AssetDTO> lister() throws DAOException{

        return this.assetDAO.lister()
                .stream()
                .map(asset -> assetTOassetDTO(asset))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void supprimer( long id ) throws DAOException{

        this.assetDAO.supprimer(id);

    }


    private Asset assetDTOTOasset(AssetDTO assetDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(assetDTO, Asset.class);

    }

    private AssetDTO assetTOassetDTO(Asset asset){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(asset, AssetDTO.class);

    }
}
