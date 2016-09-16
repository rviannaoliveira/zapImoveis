package rviannaoliveira.com.zapimoveis.detail;

import rviannaoliveira.com.zapimoveis.domain.Immobile;

/**
 * Created by rodrigo on 09/09/16.
 */
public interface DetailView {
    void setComponents(Immobile immobile);
    void sendMessageSuccess();
    void showProgressRequest();
    void hideProgressResponse();
    void error(String s);
}
