package rviannaoliveira.com.zapimoveis.data;

/**
 * Created by rodrigo on 09/09/16.
 */
public interface ResponseZap {
    void response(ServerResponse serverResponse);
    void responseSendMessage();
    void error();
}
