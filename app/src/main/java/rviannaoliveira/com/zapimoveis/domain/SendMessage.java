package rviannaoliveira.com.zapimoveis.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rodrigo on 09/09/16.
 */
public class SendMessage {
    @SerializedName("nome")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("telefone")
    private String phone;

    public SendMessage(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
