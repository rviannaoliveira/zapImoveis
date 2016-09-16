package rviannaoliveira.com.zapimoveis.detail;

import retrofit2.Call;
import rviannaoliveira.com.zapimoveis.data.ServerResponse;
import rviannaoliveira.com.zapimoveis.data.ZapClient;
import rviannaoliveira.com.zapimoveis.data.ZapService;
import rviannaoliveira.com.zapimoveis.domain.SendMessage;

/**
 * Created by rodrigo on 09/09/16.
 */
public class DetailPresenterImpl implements DetailPresenter {
    private DetailView detailView;
    private ZapClient zapClient;

    public DetailPresenterImpl(DetailView detailView) {
        this.detailView = detailView;
        this.zapClient  = new ZapClient(this);
    }

    @Override
    public void getZap(String cod) {
        ZapService zapService = ZapClient.createService(ZapService.class);
        Call<ServerResponse> call = zapService.getZap(cod);
        zapClient.request(call);
    }

    @Override
    public void postContact(String name, String phone, String email) {
        detailView.showProgressRequest();
        SendMessage sendMessage = new SendMessage(name,email,phone);
        ZapService zapService = ZapClient.createService(ZapService.class);
        Call<SendMessage> call = zapService.sendMessage(sendMessage);
        zapClient.sendMessage(call);
    }

    @Override
    public void response(ServerResponse serverResponse) {
        detailView.setComponents(serverResponse.getImmobile());
    }

    @Override
    public void responseSendMessage() {
        detailView.hideProgressResponse();
        detailView.sendMessageSuccess();
    }

    @Override
    public void error() {
        detailView.error();
    }
}
