package rviannaoliveira.com.zapimoveis.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rodrigo on 08/09/16.
 */
public class Immobile {

    @SerializedName("CodImovel")
    private String cod;
    @SerializedName("TipoImovel")
    private String type;
    @SerializedName("PrecoVenda")
    private String  priceSell;
    @SerializedName("Dormitorios")
    private String  dorms;
    @SerializedName("Suites")
    private String  suites;
    @SerializedName("Vagas")
    private String  vacancy;
    @SerializedName("AreaUtil")
    private String  areaUtil;
    @SerializedName("AreaTotal")
    private String  areaTotal;
    @SerializedName("UrlImagem")
    private String  urlImagem;
    @SerializedName("SubTipoOferta")
    private String  subTypeSale;
    @SerializedName("SubtipoImovel")
    private String  subType;
    @SerializedName("DataAtualizacao")
    private String dateRefresh;
    @SerializedName("Observacao")
    private String observation;
    @SerializedName("Cliente")
    private Client client;
    @SerializedName("Endereco")
    private Address address;
    @SerializedName("Fotos")
    private List<String> Photos;
    private final static String COMMAM = ", ";
    private final static String EMPTY = "";
    private final static String DORMS = " dorms";
    private final static String VACANCY = " vagas";
    private final static String MQ = " M²";
    private final static String SEPARATOR = " a ";

    public String getCod() {
        return cod;
    }

    public String getType() {
        return type;
    }

    public String getPriceSell() {
        return priceSell;
    }

    public String getDorms() {
        return dorms;
    }

    public String getSuites() {
        return suites;
    }

    public String getVacancy() {
        return vacancy;
    }

    public String getAreaUtil() {
        return areaUtil;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getSubTypeSale() {
        return subTypeSale;
    }

    public String getSubType() {
        return subType;
    }

    public String getDateRefresh() {
        return dateRefresh;
    }

    public String getObservation() {
        return observation;
    }

    public Client getClient() {
        return client;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getPhotos() {
        return Photos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dorms != null && !dorms.isEmpty()? dorms+DORMS+COMMAM: EMPTY);
        stringBuilder.append(vacancy != null && !vacancy.isEmpty() ? vacancy+VACANCY+COMMAM : EMPTY);
        stringBuilder.append(areaTotal != null && !areaTotal.isEmpty() ? areaTotal+MQ : EMPTY);
        return stringBuilder.toString();
    }

    public String getArea(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(areaUtil != null && !areaUtil.isEmpty()? areaUtil+SEPARATOR: EMPTY);
        stringBuilder.append(areaTotal != null && !areaTotal.isEmpty()? areaTotal: EMPTY);
        return stringBuilder.toString();
    }
}
