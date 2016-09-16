package rviannaoliveira.com.zapimoveis.detail;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rviannaoliveira.com.zapimoveis.R;
import rviannaoliveira.com.zapimoveis.Tools;
import rviannaoliveira.com.zapimoveis.domain.Immobile;
import rviannaoliveira.com.zapimoveis.zap.ZapActivity;

/**
 * Created by rodrigo on 09/09/16.
 */
public class DetailFragment extends Fragment implements DetailView {
    private Unbinder unbinder;
    private DetailPresenter detailPresenter;
    private ProgressDialog progress;
    private ImageView[] dots;
    private int dotsCount;

    @BindView(R.id.detail_address)TextView address;
    @BindView(R.id.detail_area)TextView area;
    @BindView(R.id.detail_description)TextView description;
    @BindView(R.id.detail_dorms)TextView dorms;
    @BindView(R.id.detail_suite)TextView suite;
    @BindView(R.id.detail_type_immobile)TextView type;
    @BindView(R.id.detail_vacancy)TextView vacancy;
    @BindView(R.id.detail_price)TextView price;
    @BindView(R.id.detail_name_fantasy)TextView nameFantasy;
    @BindView(R.id.detail_sub_type_sale)TextView subTypeSale;
    @BindView(R.id.detail_feature_common)TextView feature;
    @BindView(R.id.detail_date_refresh)TextView dateRefresh;
    @BindView(R.id.detail_information_complementary)TextView informationComplementary;
    @BindView(R.id.detail_price_condominium)TextView priceCondominium;
    @BindView(R.id.detail_view_pager_count_dots)LinearLayout pagerIndicator;
    @BindView(R.id.detail_view_pager)ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.detail_fragment, container, false);
        unbinder = ButterKnife.bind(this, layout);
        this.setHasOptionsMenu(true);

        detailPresenter = new DetailPresenterImpl(this);
        if(getArguments().containsKey(ZapActivity.KEY)){
            detailPresenter.getZap(getArguments().get(ZapActivity.KEY).toString());
        }

        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_item_done){
            DialogFragment dialogFragment = new DialogSendFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(getActivity().getFragmentManager(), getActivity().getString(R.string.send_message));
        }else{
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void setComponents(Immobile immobile) {
        address.setText(immobile.getAddress().getTextAddress());
        type.setText(immobile.getType());
        vacancy.setText(immobile.getVacancy());
        area.setText(immobile.getTextArea());
        dorms.setText(immobile.getDorms());
        price.setText(Tools.getPriceFormat(immobile.getPriceSell()));
        description.setText(immobile.getObservation());
        nameFantasy.setText(immobile.getClient().getNameFantasia());
        subTypeSale.setText(immobile.getSubTypeSale());
        priceCondominium.setText(Tools.getPriceFormat(immobile.getPriceCondominium()));
        this.hideFeatures(immobile);

        if(immobile.getPhotos() != null && !immobile.getPhotos().isEmpty()){
            this.loadingViewPager(immobile.getPhotos());
        }
    }

    private void hideFeatures(Immobile immobile) {
        if(!Tools.stringNotNullNotEmpty(immobile.getTextFeatures())){
            feature.setVisibility(View.GONE);
        }else{
            feature.setText(getActivity().getString(R.string.txt_feature_common).concat(immobile.getTextFeatures()));
        }
        if(!Tools.stringNotNullNotEmpty(immobile.getInformationComplementary())){
            informationComplementary.setVisibility(View.GONE);
        }else{
            informationComplementary.setText(getActivity().getString(R.string.txt_information_complementary).concat(immobile.getInformationComplementary()));
        }
    }

    private void loadingViewPager(List<String> photos) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPagerAdapter.addAllItem(photos);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(eventChangePager);
        this.setUiPageViewController(viewPagerAdapter.getCount());
    }

    @Override
    public void sendMessageSuccess() {
        new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), android.R.style.Theme_DeviceDefault_Light))
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setTitle(getActivity().getString(R.string.alert))
                .setMessage(getActivity().getString(R.string.sendSuccess))
                .setPositiveButton(getActivity().getString(R.string.ok),null).show();
    }

    @Override
    public void showProgressRequest() {
        progress = ProgressDialog.show(getActivity(), getActivity().getString(R.string.please_wait),getActivity().getString(R.string.wait), true);
    }

    @Override
    public void hideProgressResponse() {
        progress.dismiss();
    }

    @Override
    public void error(String error) {
        Toast.makeText(getActivity(), R.string.txt_error,Toast.LENGTH_LONG).show();
        Crashlytics.logException(new RuntimeException(error));
        getActivity().finish();
    }

    private ViewPager.OnPageChangeListener eventChangePager = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonselecteditem_dot));
            }
            dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.selecteditem_dot));
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private void setUiPageViewController(int count) {
        dotsCount = count;
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(4, 0, 4, 0);
            pagerIndicator.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.selecteditem_dot));
    }


    class DialogSendFragment extends DialogFragment {
        @BindView(R.id.name_dialog)
        EditText name;
        @BindView(R.id.email_dialog)
        EditText email;
        @BindView(R.id.phone_dialog)
        EditText phone;

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_send_message, null);
            ButterKnife.bind(this,view);

            builder.setView(view)
                    .setTitle(R.string.send_message)
                    .setNegativeButton(R.string.cancel, null)
                    .setPositiveButton(R.string.ok, null);
            return builder.create();
        }


        @Override
        public void onStart() {
            super.onStart();
            AlertDialog alertDialog = (AlertDialog) getDialog();
            Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            okButton.setOnClickListener(eventOkData);
        }

        private View.OnClickListener eventOkData = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valid()) {
                    DetailFragment.this.detailPresenter.postContact(name.getText().toString(),
                            email.getText().toString(),
                            phone.getText().toString());
                    dismiss();
                }
            }
        };

        private boolean valid(){
            boolean email = validEmail();
            boolean name  = validName();
            boolean phone = validPhone();
            return email && name && phone;
        }

        private boolean validEmail() {
            if(!Tools.stringNotNullNotEmpty(email.getText().toString())){
                email.setError(getActivity().getString(R.string.required));
            }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                email.setError(getActivity().getString(R.string.valid_email));
            }

            return Tools.stringNotNullNotEmpty(email.getText().toString()) && android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches();
        }

        private boolean validName() {
            if(!Tools.stringNotNullNotEmpty(name.getText().toString())){
                name.setError(getActivity().getString(R.string.required));
            }
            return Tools.stringNotNullNotEmpty(name.getText().toString());
        }
        private boolean validPhone() {
            if(!Tools.stringNotNullNotEmpty(phone.getText().toString())){
                phone.setError(getActivity().getString(R.string.required));
            }else if(phone.getText().toString().length() != 11){
                phone.setError(getActivity().getString(R.string.valid_phone));
            }
           return Tools.stringNotNullNotEmpty(phone.getText().toString()) && phone.getText().toString().length() == 11;
        }
    }

}