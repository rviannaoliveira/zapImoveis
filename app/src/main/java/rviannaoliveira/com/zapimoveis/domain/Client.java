package rviannaoliveira.com.zapimoveis.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rodrigo on 08/09/16.
 */
public class Client {

    @SerializedName("CodCliente")
    private String cod;
    @SerializedName("NomeFantasia")
    private String nameFantasia;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNameFantasia() {
        return nameFantasia;
    }

    public void setNameFantasia(String nameFantasia) {
        this.nameFantasia = nameFantasia;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cod='" + cod + '\'' +
                ", nameFantasia='" + nameFantasia + '\'' +
                '}';
    }
}
