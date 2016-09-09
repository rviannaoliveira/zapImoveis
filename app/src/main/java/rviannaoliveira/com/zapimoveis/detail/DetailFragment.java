package rviannaoliveira.com.zapimoveis.detail;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
import android.widget.TextView;

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
    @BindView(R.id.detail_image) ImageView image;
    @BindView(R.id.detail_address)TextView address;
    @BindView(R.id.detail_area)TextView area;
    @BindView(R.id.detail_description)TextView description;
    @BindView(R.id.detail_dorms)TextView dorms;
    @BindView(R.id.detail_suite)TextView suite;
    @BindView(R.id.detail_type_immobile)TextView type;
    @BindView(R.id.detail_vacancy)TextView vacancy;
    @BindView(R.id.detail_price)TextView price;

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
        DialogFragment dialogFragment = new DialogSendFragment();
        dialogFragment.show(getActivity().getFragmentManager(), getActivity().getString(R.string.send_message));
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void setComponents(Immobile immobile) {
        address.setText(immobile.getAddress().toString());
        type.setText(immobile.getType());
        vacancy.setText(immobile.getVacancy());
        area.setText(immobile.getArea());
        dorms.setText(immobile.getDorms());
        price.setText(Tools.getPriceFormat(immobile.getPriceSell()));
        description.setText(immobile.getObservation());
        if(immobile.getPhotos() != null && !immobile.getPhotos().isEmpty()){
            Tools.getImageUrl(getActivity(),immobile.getPhotos().get(0),image);
        }
    }

    @Override
    public void sendMessageSuccess() {
        new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), android.R.style.Theme_DeviceDefault_Light))
                .setIcon(R.drawable.ic_warning_white_24dp)
                .setTitle(getActivity().getString(R.string.alert))
                .setMessage(getActivity().getString(R.string.sendSuccess))
                .setPositiveButton(getActivity().getString(R.string.ok),null).show();
    }


    class DialogSendFragment extends DialogFragment {
        private EditText name;
        private EditText email;
        private EditText phone;

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_send_message, null);
            name = (EditText) view.findViewById(R.id.name_dialog);
            email = (EditText) view.findViewById(R.id.email_dialog);
            phone = (EditText) view.findViewById(R.id.phone_dialog);

            builder.setView(view)
                    .setTitle(R.string.send_message)
                    .setNegativeButton(R.string.cancel,null)
                    .setPositiveButton(R.string.ok,null);
            return builder.create();
        }


        @Override
        public void onStart() {
            super.onStart();
            AlertDialog alertDialog = (AlertDialog) getDialog();
            Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            okButton.setOnClickListener(eventOkDataMap);
        }

        private View.OnClickListener eventOkDataMap = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DialogSendFragment.this.valid()){
                    DetailFragment.this.detailPresenter.postContact(name.getText().toString(),
                                                                    email.getText().toString(),
                                                                    phone.getText().toString());
                }else{
                    name.setError(getActivity().getString(R.string.required));
                    email.setError(getActivity().getString(R.string.required));
                    phone.setError(getActivity().getString(R.string.required));
                }
            }
        };
        private boolean valid(){
            boolean nameValid  = Tools.stringNotNullNotEmpty(name.getText().toString());
            boolean emailValid = Tools.stringNotNullNotEmpty(email.getText().toString());
            boolean phoneValid = Tools.stringNotNullNotEmpty(phone.getText().toString());
            return nameValid && emailValid && phoneValid;
        }
    }
}