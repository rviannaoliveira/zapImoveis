package rviannaoliveira.com.zapimoveis.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import rviannaoliveira.com.zapimoveis.Tools;

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
    private String  urlImage;
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
    @SerializedName("EstagioObra")
    private String stageWork;
    @SerializedName("StatusQualidadeTotal")
    private String statusQuality;
    @SerializedName("Fotos")
    private List<String> Photos;
    @SerializedName("Caracteristicas")
    private List<String> feature;
    @SerializedName("InformacoesComplementares")
    private String informationComplementary;
    @SerializedName("PrecoCondominio")
    private String priceCondominium;

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

    public String getUrlImage() {
        return urlImage;
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

    public String getStageWork() {
        return stageWork;
    }

    public String getStatusQuality() {
        return statusQuality;
    }

    public List<String> getPhotos() {
        return Photos;
    }

    public List<String> getFeature() {
        return feature;
    }

    public String getInformationComplementary() {
        return informationComplementary;
    }

    public String getPriceCondominium() {
        return priceCondominium;
    }

    public String getTextImmobile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Tools.stringNotNullNotEmpty(dorms)? dorms+DORMS+COMMAM: EMPTY);
        stringBuilder.append(Tools.stringNotNullNotEmpty(vacancy) ? vacancy+VACANCY+COMMAM : EMPTY);
        stringBuilder.append(Tools.stringNotNullNotEmpty(areaTotal)? areaTotal+MQ : EMPTY);
        return stringBuilder.toString();
    }

    public String getTextArea(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Tools.stringNotNullNotEmpty(areaUtil)? areaUtil+SEPARATOR: EMPTY);
        stringBuilder.append(Tools.stringNotNullNotEmpty(areaTotal)? areaTotal: EMPTY);
        return stringBuilder.toString();
    }

    public String getTextFeatures(){
        StringBuilder stringBuilder = new StringBuilder();
        String word = null;

        for (int i = 0; i < feature.size(); i++) {
            word = feature.get(i);
            if(i+1 == feature.size()){
                stringBuilder.append(Tools.stringNotNullNotEmpty(word)? word: EMPTY);
            }else{
                stringBuilder.append(Tools.stringNotNullNotEmpty(word)? word+COMMAM: EMPTY);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Immobile{" +
                "cod='" + cod + '\'' +
                ", type='" + type + '\'' +
                ", priceSell='" + priceSell + '\'' +
                ", dorms='" + dorms + '\'' +
                ", suites='" + suites + '\'' +
                ", vacancy='" + vacancy + '\'' +
                ", areaUtil='" + areaUtil + '\'' +
                ", areaTotal='" + areaTotal + '\'' +
                ", urlImagem='" + urlImage + '\'' +
                ", subTypeSale='" + subTypeSale + '\'' +
                ", subType='" + subType + '\'' +
                ", dateRefresh='" + dateRefresh + '\'' +
                ", observation='" + observation + '\'' +
                ", client=" + client +
                ", address=" + address +
                ", Photos=" + Photos +
                '}';
    }
}
