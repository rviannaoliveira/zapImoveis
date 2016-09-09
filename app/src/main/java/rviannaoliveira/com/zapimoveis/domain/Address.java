package rviannaoliveira.com.zapimoveis.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rodrigo on 08/09/16.
 */
public class Address {
    @SerializedName("Numero")
    private String number;
    @SerializedName("CEP")
    private String cep;
    @SerializedName("Bairro")
    private String neighboord;
    @SerializedName("Cidade")
    private String city;
    @SerializedName("Estado")
    private String state;
    @SerializedName("Zona")
    private String zone;
    @SerializedName("Logradouro")
    private String street;
    @SerializedName("Complemento")
    private String complementary;
    private final static String SEPARATOR = " - ";
    private final static String SPACE = " ";
    private final static String COMMAM = " , ";
    private final static String EMPTY = "";

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNeighboord() {
        return neighboord;
    }

    public void setNeighboord(String neighboord) {
        this.neighboord = neighboord;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getComplementary() {
        return complementary;
    }

    public void setComplementary(String complementary) {
        this.complementary = complementary;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street != null && !street.isEmpty()? street+COMMAM: EMPTY);
        stringBuilder.append(number != null && !number.isEmpty() ? number+SEPARATOR : EMPTY);
        stringBuilder.append(neighboord != null && !neighboord.isEmpty() ? neighboord+SEPARATOR : EMPTY);
        stringBuilder.append(city != null && !city.isEmpty() ? city : EMPTY);
        return stringBuilder.toString();
    }
}
