package tv.alphanetworks.exo.dto;



public class AssetDTO {

    private long   id;
    private String name;
    private long   downloads;



    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public long getDownloads() {
        return downloads;
    }

    public void setDownloads( long downloads ) {
        this.downloads = downloads;
    }


    public String toString() {
        return "AssetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", downloads=" + downloads +
                '}';
    }
}
