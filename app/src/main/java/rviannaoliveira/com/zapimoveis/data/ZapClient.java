package rviannaoliveira.com.zapimoveis.data;

import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rviannaoliveira.com.zapimoveis.domain.SendMessage;
import rviannaoliveira.com.zapimoveis.zap.ZapPresenter;

/**
 * Created by rodrigo on 08/09/16.
 */
public class ZapClient {
    public static final String API_BASE_URL = " http://demo4573903.mockable.io";
    private ResponseZap responseZap;
    private static final int RESULT_OK = 200;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder()
                                                          .baseUrl(API_BASE_URL)
                                                          .addConverterFactory(GsonConverterFactory.create());

    public ZapClient(ResponseZap responseZap) {
        this.responseZap = responseZap;
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public void request(Call<ServerResponse> call){
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if(response.code() == RESULT_OK && response.body() != null){
                    responseZap.response(response.body());
                }else{
                    responseZap.error();
                }
            }
            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.i(">>>> ", t.getMessage());
            }
        });
    }
    public void sendMessage(Call<SendMessage> call){
        call.enqueue(new Callback<SendMessage>() {
            @Override
            public void onResponse(Call<SendMessage> call, Response<SendMessage> response) {
                if(response.code() == RESULT_OK){
                    responseZap.responseSendMessage();
                }else{
                    responseZap.error();
                }
            }
            @Override
            public void onFailure(Call<SendMessage> call, Throwable t) {
                Log.i(">>>> ", t.getMessage());
            }
        });
    }
}
