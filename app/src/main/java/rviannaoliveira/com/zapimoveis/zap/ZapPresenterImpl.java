package rviannaoliveira.com.zapimoveis.zap;

import retrofit2.Call;
import rviannaoliveira.com.zapimoveis.data.ServerResponse;
import rviannaoliveira.com.zapimoveis.data.ZapClient;
import rviannaoliveira.com.zapimoveis.data.ZapService;
import rviannaoliveira.com.zapimoveis.domain.SendMessage;

/**
 * Created by rodrigo on 08/09/16.
 */
public class ZapPresenterImpl implements ZapPresenter {
    private ZapView zapView;
    private ZapClient zapClient;

    public ZapPresenterImpl(ZapView zapView) {
        this.zapView = zapView;
        this.zapClient = new ZapClient(this);
    }


    @Override
    public void response(ServerResponse serverResponse) {
        zapView.loadingZaps(serverResponse.getImmobiles());
        zapView.hideProgress();
    }

    @Override
    public void requestZaps() {
        zapView.showProgress();
        ZapService zapService = ZapClient.createService(ZapService.class);
        Call<ServerResponse> call = zapService.getZaps();
        zapClient.request(call);
    }
    @Override
    public void responseSendMessage() {
    }
}