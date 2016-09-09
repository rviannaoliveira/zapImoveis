package rviannaoliveira.com.zapimoveis.domain;

import com.google.gson.annotations.SerializedName;

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
    private String  subTypeOferta;
    @SerializedName("SubtipoImovel")
    private String  subType;
    @SerializedName("DataAtualizacao")
    private String dateRefresh;
    @SerializedName("Cliente")
    private Client client;
    @SerializedName("Endereco")
    private Address address;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(String priceSell) {
        this.priceSell = priceSell;
    }

    public String getDorms() {
        return dorms;
    }

    public void setDorms(String dorms) {
        this.dorms = dorms;
    }

    public String getSuites() {
        return suites;
    }

    public void setSuites(String suites) {
        this.suites = suites;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(String areaUtil) {
        this.areaUtil = areaUtil;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(String areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getSubTypeSale() {
        return subTypeOferta;
    }

    public void setSubTypeOferta(String subTypeOferta) {
        this.subTypeOferta = subTypeOferta;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDateRefresh() {
        return dateRefresh;
    }

    public void setDateRefresh(String dateRefresh) {
        this.dateRefresh = dateRefresh;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
