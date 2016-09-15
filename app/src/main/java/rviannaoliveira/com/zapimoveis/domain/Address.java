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
    private final static String COMMAM = ", ";
    private final static String EMPTY = "";

    public String getNumber() {
        return number;
    }

    public String getCep() {
        return cep;
    }

    public String getNeighboord() {
        return neighboord;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZone() {
        return zone;
    }

    public String getStreet() {
        return street;
    }

    public String getComplementary() {
        return complementary;
    }

    public static String getSEPARATOR() {
        return SEPARATOR;
    }

    public static String getSPACE() {
        return SPACE;
    }

    public static String getCOMMAM() {
        return COMMAM;
    }

    public static String getEMPTY() {
        return EMPTY;
    }

    public String getTextAddress() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street != null && !street.isEmpty()? street+COMMAM: EMPTY);
        stringBuilder.append(number != null && !number.isEmpty() ? number+SEPARATOR : EMPTY);
        stringBuilder.append(complementary != null && !complementary.isEmpty() ? complementary+SEPARATOR : EMPTY);
        stringBuilder.append(neighboord != null && !neighboord.isEmpty() ? neighboord+SEPARATOR : EMPTY);
        stringBuilder.append(city != null && !city.isEmpty() ? city+SEPARATOR : EMPTY);
        stringBuilder.append(state != null && !state.isEmpty() ? state+SEPARATOR : EMPTY);
        stringBuilder.append(zone != null && !zone.isEmpty() ? zone+SEPARATOR : EMPTY);
        stringBuilder.append(cep != null && !cep.isEmpty() ? cep : EMPTY);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", cep='" + cep + '\'' +
                ", neighboord='" + neighboord + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zone='" + zone + '\'' +
                ", street='" + street + '\'' +
                ", complementary='" + complementary + '\'' +
                '}';
    }
}
