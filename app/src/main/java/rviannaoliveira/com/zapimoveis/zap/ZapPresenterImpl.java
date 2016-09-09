package rviannaoliveira.com.zapimoveis.zap;

import retrofit2.Call;

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
    public void responseZaps(ServerResponse serverResponse) {
        zapView.loadingZaps(serverResponse.getImoveis());
        zapView.hideProgress();
    }

    @Override
    public void requestZaps() {
        zapView.showProgress();
        ZapService zapService = ZapClient.createService(ZapService.class);
        Call<ServerResponse> call = zapService.getZaps();
        zapClient.requestZaps(call);
    }
}