package rviannaoliveira.com.zapimoveis.data;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rviannaoliveira.com.zapimoveis.data.ServerResponse;
import rviannaoliveira.com.zapimoveis.domain.SendMessage;

/**
 * Created by rodrigo on 08/09/16.
 */
public interface ZapService {
    @GET("/imoveis")
    Call<ServerResponse> getZaps();
    @GET("/imoveis/{cod}")
    Call<ServerResponse> getZap(@Path("cod") String cod);
    @POST("/imoveis/contato")
    Call<SendMessage> sendMessage(@Body SendMessage sendMessage);
}

