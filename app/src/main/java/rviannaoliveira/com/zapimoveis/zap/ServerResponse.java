package rviannaoliveira.com.zapimoveis.zap;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import rviannaoliveira.com.zapimoveis.domain.Immobile;

/**
 * Created by rodrigo on 09/09/16.
 */
public class ServerResponse implements Serializable {
    @SerializedName("Imoveis")
    private List<Immobile> imoveis;

    public List<Immobile> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Immobile> imoveis) {
        this.imoveis = imoveis;
    }
}
