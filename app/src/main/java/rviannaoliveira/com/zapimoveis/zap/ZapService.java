package rviannaoliveira.com.zapimoveis.zap;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rodrigo on 08/09/16.
 */
public interface ZapService {
    @GET("/imoveis")
    Call<ServerResponse> getZaps();
}

