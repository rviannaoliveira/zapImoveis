package rviannaoliveira.com.zapimoveis.zap;

import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rodrigo on 08/09/16.
 */
public class ZapClient {
    public static final String API_BASE_URL = " http://demo4573903.mockable.io";
    private ZapPresenter zapPresenter;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder()
                                                          .baseUrl(API_BASE_URL)
                                                          .addConverterFactory(GsonConverterFactory.create());

    public ZapClient(ZapPresenter zapPresenter) {
        this.zapPresenter = zapPresenter;
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public void requestZaps(Call<ServerResponse> call){
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                zapPresenter.responseZaps(response.body());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.i(">>>> ", t.getMessage());
            }
        });
    }
}
