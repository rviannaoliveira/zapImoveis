package rviannaoliveira.com.zapimoveis.zap;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.fabric.sdk.android.Fabric;
import rviannaoliveira.com.zapimoveis.R;
import rviannaoliveira.com.zapimoveis.domain.Immobile;

/**
 * Created by rodrigo on 08/09/16.
 */
public class ZapFragment extends Fragment implements ZapView{
    @BindView(R.id.zap_list)    RecyclerView recyclerView;
    @BindView(R.id.progress)    ProgressBar progressBar;
    private Unbinder unbinder;
    private ZapPresenter zapPresenter;
    private ZapAdapter zapAdapter;
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.zap_fragment, container, false);
        unbinder = ButterKnife.bind(this, layout);
        zapPresenter = new ZapPresenterImpl(this);
        this.setHasOptionsMenu(true);
        zapAdapter= new ZapAdapter(getActivity());
        recyclerView.setAdapter(zapAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
       zapPresenter.requestZaps();
    }
    public void onStop(){
        zapAdapter.clear();
        super.onStop();
    }

    @Override public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_zap, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View menuItemView = getActivity().findViewById(R.id.menu_item_sort);
        PopupMenu popup = new PopupMenu(getActivity(), menuItemView);
        popup.getMenuInflater().inflate(R.menu.menu_zap_sort, popup.getMenu());

        popup.setOnMenuItemClickListener(onMenuItemClickListener);
        popup.show();
        return super.onOptionsItemSelected(item);
    }

    private PopupMenu.OnMenuItemClickListener onMenuItemClickListener =   new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(item.getItemId() == R.id.cheap_item){
                zapPresenter.sortCheapList();
            }else if(item.getItemId() == R.id.dorms_item){
                zapPresenter.sortDormsList();
            }else{
                zapPresenter.sortRelevantList();
            }
            return false;
        }
    };


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if(progressBar != null){
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showProgressBar() {
        dialog = ProgressDialog.show(getActivity(), getString(R.string.wait),getString(R.string.sort_itens), true, false);
    }

    @Override
    public void hideProgressBar() {
        dialog.cancel();
    }

    @Override
    public void loadingZaps(List<Immobile> zaps) {
        zapAdapter.addAll(zaps);
    }

    @Override
    public void sortCheapList() {
        zapAdapter.sortCheap();
    }

    @Override
    public void sortDormsList() {
        zapAdapter.sortDorms();
    }

    @Override
    public void sortRelevantList() {
        zapAdapter.sortRelevant();
    }

    @Override
    public void error(String error) {
        Toast.makeText(getActivity(), R.string.txt_error,Toast.LENGTH_LONG).show();
        Crashlytics.logException(new RuntimeException(error));
    }
}
