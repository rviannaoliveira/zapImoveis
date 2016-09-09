package rviannaoliveira.com.zapimoveis.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import rviannaoliveira.com.zapimoveis.domain.Immobile;

/**
 * Created by rodrigo on 09/09/16.
 */
public class ServerResponse implements Serializable {
    @SerializedName("Imoveis")
    private List<Immobile> immobiles;
    @SerializedName("Imovel")
    private Immobile immobile;

    public List<Immobile> getImmobiles() {
        return immobiles;
    }

    public Immobile getImmobile() {
        return immobile;
    }
}
