package com.VishalRaj.roulette;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrivateTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrivateTabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //my variables
    int degree_old = 0, degree = 0;
    int[] arr = new int[]{18, 54, 90, 125, 162, 198, 234, 270, 306, 342};
    int count = 0;
    int money = 10000, bid_money=0;
    private static final float FACTOR = 18.0f;
    Boolean b[] = new Boolean[]{false,false,false,false,false,false,false,false,false,false};
    TextView no, amount;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PrivateTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrivateTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PrivateTabFragment newInstance(String param1, String param2) {
        PrivateTabFragment fragment = new PrivateTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_private_tab, container, false);

        final Button play_btn = v.findViewById(R.id.play_btn);
        final ImageView spinner = v.findViewById(R.id.spinner);
        final TextView txt0 = v.findViewById(R.id.txt0);
        final TextView txt1 = v.findViewById(R.id.txt1);
        final TextView txt2 = v.findViewById(R.id.txt2);
        final TextView txt3 = v.findViewById(R.id.txt3);
        final TextView txt4 = v.findViewById(R.id.txt4);
        final TextView txt5 = v.findViewById(R.id.txt5);
        final TextView txt6 = v.findViewById(R.id.txt6);
        final TextView txt7 = v.findViewById(R.id.txt7);
        final TextView txt8 = v.findViewById(R.id.txt8);
        final TextView txt9 = v.findViewById(R.id.txt9);
        final EditText btn[]= new EditText[]{ v.findViewById(R.id.edit_txt0), v.findViewById(R.id.edit_txt1),v.findViewById(R.id.edit_txt2),
                v.findViewById(R.id.edit_txt3),v.findViewById(R.id.edit_txt4),v.findViewById(R.id.edit_txt5),
                v.findViewById(R.id.edit_txt6), v.findViewById(R.id.edit_txt7), v.findViewById(R.id.edit_txt8),
                v.findViewById(R.id.edit_txt9)};

        final TextView total =v.findViewById(R.id.total);
        final TextView bid = v.findViewById(R.id.bid);

        play_btn.setEnabled(false);

        btn[0].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[0].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[0]=true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[0]= false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[1].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[1].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[1] = true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[1]= false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[2].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[2].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[2]= true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[2]=false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[3].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[3].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[3] = true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[3]= false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[4].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[4].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[4]= true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[4]= false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[5].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }
            public void afterTextChanged(Editable editable) {
                String str = btn[5].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[5] = true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[5]= false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[6].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[6].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[6] = true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[6]= false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[7].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[7].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[7]=true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[7]=false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[8].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[8].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[8] = true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[8] = false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });
        btn[9].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (btn[0].getText().toString().trim().length()>0)
                    btn[0].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[0].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[1].getText().toString().trim().length()>0)
                    btn[1].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[1].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[2].getText().toString().trim().length()>0)
                    btn[2].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[2].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[3].getText().toString().trim().length()>0)
                    btn[3].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[3].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[4].getText().toString().trim().length()>0)
                    btn[4].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[4].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[5].getText().toString().trim().length()>0)
                    btn[5].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[5].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[6].getText().toString().trim().length()>0)
                    btn[6].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[6].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[7].getText().toString().trim().length()>0)
                    btn[7].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[7].setBackgroundColor(Color.parseColor("#0099CC"));
                if (btn[8].getText().toString().trim().length()>0)
                    btn[8].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[8].setBackgroundColor(Color.parseColor("#33b5E5"));
                if (btn[9].getText().toString().trim().length()>0)
                    btn[9].setBackgroundColor(Color.parseColor("#AEEA00"));
                else
                    btn[9].setBackgroundColor(Color.parseColor("#0099CC"));
            }


            public void afterTextChanged(Editable editable) {
                String str = btn[9].getText().toString().trim();
                int editnum= 0;
                if(str.length()>0){
                    editnum = Integer.parseInt(str);
                    b[9] = true;
                }
                else {
                    editnum=0;
                    bid_money+=0;
                    b[9] =false;
                }
                if(editnum > 0 && editnum<money){
                    play_btn.setEnabled(true);
                    bid_money+= editnum;
                }
            }
        });


        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bid_money=0;
                for (int i =0 ; i<=9;i++){
                    if(b[i]){
                        bid_money = Integer.parseInt(btn[i].getText().toString())+ bid_money;
                    }
                }
                bid.setText("Total Bid Amount:\n"+bid_money);
                if(bid_money<money && bid_money>0){

                    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(R.string.app_name);
                    builder.setMessage("Do you want to continue with "+bid_money+" coins ?");
                    builder.setIcon(R.drawable.ic_baseline_attach_money_24);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();

                            // code part
                            degree_old = degree % 360;
                            degree = arr[new Random().nextInt(arr.length)] + 1440;
                            RotateAnimation rotate = new RotateAnimation(degree_old, degree, RotateAnimation.RELATIVE_TO_SELF,
                                    0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                            rotate.setDuration(3600);
                            rotate.setFillAfter(true);
                            rotate.setInterpolator(new DecelerateInterpolator());
                            rotate.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    int n = count % 10;
                                    int f=0;
                                    int no = Integer.parseInt(currentNumber(360 - (degree % 360)));
                                    for (int i=0;i<=9;i++){
                                        if(b[i]){
                                            if (i==no){
                                                f++;
                                                AlertDialog.Builder builder1 =new AlertDialog.Builder(getContext());
                                                builder1.setTitle("Winner");
                                                builder1.setIcon(R.drawable.ic_baseline_monetization_on_24);
                                                builder1.setMessage("Congratulations, you've won!\n"+btn[i].getText().toString()+"Coins!");
                                                builder1.setNegativeButton("close", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                                AlertDialog d = builder1.create();
                                                d.show();
                                                money = money - bid_money + 2*Integer.parseInt(btn[i].getText().toString()) ;
                                                break;
                                            }
                                        }
                                    }
                                    if (f==0){
                                        money = money - bid_money;
                                        AlertDialog.Builder builder1 =new AlertDialog.Builder(getContext());
                                        builder1.setTitle("Sorry");
                                        builder1.setIcon(R.drawable.ic_baseline_money_off_24);
                                        builder1.setMessage("Opps, you've lost\n"+bid_money+" Coins!");
                                        builder1.setNegativeButton("close", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                        AlertDialog d = builder1.create();
                                        d.show();
                                    }
                                    total.setText("Total amount:\n"+money);
                                    bid_money=0;
                                    for (int j =0; j<=9; j++) {
                                        btn[j].setText("");
                                        b[j]=false;
                                        play_btn.setEnabled(false);
                                    }
                            /*if (no == bid){
                                money = money+ bid_money;
                                total.setText("Total amount:\n"+money);
                            }
                            else{
                                money = money- bid_money;
                                total.setText("Total amount:\n"+money);
                            }*/
                                    switch (n) {
                                        case 0:
                                            txt9.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 1:
                                            txt8.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 2:
                                            txt7.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 3:
                                            txt6.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 4:
                                            txt5.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 5:
                                            txt4.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 6:
                                            txt3.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 7:
                                            txt2.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 8:
                                            txt1.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                        case 9:
                                            txt0.setText(currentNumber(360 - (degree % 360)));
                                            break;
                                    }
                                    count++;
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            spinner.startAnimation(rotate);

                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                else {
                    Toast.makeText(getActivity(), "Enter a valid amount under your coins", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return v;
    }

    private String currentNumber(int degrees) {

        String text = "";
        if (degrees >= (0) && degrees < (FACTOR * 2)) {
            text = "0";
        }
        if (degrees >= (2 * FACTOR) && degrees < (FACTOR * 4)) {
            text = "1";
        }
        if (degrees >= (4 * FACTOR) && degrees < (FACTOR * 6)) {
            text = "2";
        }
        if (degrees >= (6 * FACTOR) && degrees < (FACTOR * 8)) {
            text = "3";
        }
        if (degrees >= (8 * FACTOR) && degrees < (FACTOR * 10)) {
            text = "4";
        }
        if (degrees >= (10 * FACTOR) && degrees < (FACTOR * 12)) {
            text = "5";
        }
        if (degrees >= (12 * FACTOR) && degrees < (FACTOR * 14)) {
            text = "6";
        }
        if (degrees >= (14 * FACTOR) && degrees < (FACTOR * 16)) {
            text = "7";
        }
        if (degrees >= (16 * FACTOR) && degrees < (FACTOR * 18)) {
            text = "8";
        }
        if (degrees >= (18 * FACTOR) && degrees < (FACTOR * 20)) {
            text = "9";
        }

        return text;
    }

}