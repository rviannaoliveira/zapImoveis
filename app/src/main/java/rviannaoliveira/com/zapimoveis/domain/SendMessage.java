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

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    @Override
    public String toString() {
        return "SendMessage{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
