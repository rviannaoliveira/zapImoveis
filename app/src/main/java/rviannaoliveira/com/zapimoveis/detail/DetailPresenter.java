package rviannaoliveira.com.zapimoveis.detail;

import rviannaoliveira.com.zapimoveis.data.ResponseZap;

/**
 * Created by rodrigo on 09/09/16.
 */
public interface DetailPresenter extends ResponseZap {
    void getZap(String cod);
    void postContact(String name, String phone, String email, String codAnnouncement);
}
