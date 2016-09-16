package rviannaoliveira.com.zapimoveis.zap;

import java.util.List;

import rviannaoliveira.com.zapimoveis.domain.Immobile;

/**
 * Created by rodrigo on 08/09/16.
 */
public interface ZapView {
    void showProgress();
    void hideProgress();
    void showProgressBar();
    void hideProgressBar();
    void loadingZaps(List<Immobile> zaps);
    void sortCheapList();
    void sortDormsList();
    void sortRelevantList();
    void error(String error);
}
