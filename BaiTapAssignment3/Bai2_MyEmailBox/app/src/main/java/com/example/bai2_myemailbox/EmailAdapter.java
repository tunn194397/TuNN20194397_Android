package com.example.bai2_myemailbox;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class EmailAdapter extends BaseAdapter {
    private List<Email> mEmails;
    private Context mContext;

    public EmailAdapter(List mEmails, Context mContext) {
        this.mEmails = mEmails;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return this.mEmails.size();
    }

    @Override
    public Object getItem(int position) {
        return mEmails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mEmails.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.email_detail, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Email email = (Email) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.from_text)).setText(email.getFrom());
        ((TextView) viewProduct.findViewById(R.id.subject_text)).setText(email.getSubject());
        ((TextView) viewProduct.findViewById(R.id.message_text)).setText(email.getMessage());
        ((TextView) viewProduct.findViewById(R.id.timestamp_text)).setText(email.getTimestamp());

        final LinearLayout emailDetail = viewProduct.findViewById(R.id.email_detail);
        if (!email.isRead()) emailDetail.setBackgroundColor(Color.parseColor("#d9d9d9"));

        final ImageView starImage = viewProduct.findViewById(R.id.imageView);
        if (!email.isImportant()) starImage.setVisibility(View.INVISIBLE);
        final Button buttonView = (Button) viewProduct.findViewById(R.id.read_button);
        buttonView.setText(email.getFrom().substring(0,1));
        int i = (int)(email.getId()%10); // 0,1,2,3,4,5,6,7,8,9

        switch (i) {
            case 0:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_0));
                break;
            case 1:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_1));
                break;
            case 2:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_2));
                break;
            case 3:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_3));
                break;
            case 4:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_4));
                break;
            case 5:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_5));
                break;
            case 6:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_6));
                break;
            case 7:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_7));
                break;
            case 8:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_8));
                break;
            case 9:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_9));
                break;
            default:
                buttonView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.avt_button_0));
                break;

        }
        return viewProduct;
    }
}
