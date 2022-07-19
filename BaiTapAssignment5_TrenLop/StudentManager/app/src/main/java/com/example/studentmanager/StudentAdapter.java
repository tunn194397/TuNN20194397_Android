package com.example.studentmanager;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class StudentAdapter extends BaseAdapter {

    Cursor cs;
    private Context mContext;

    public StudentAdapter(Cursor cs, Context mContext) {
        this.cs = cs;
        this.mContext = mContext;
    }

    public StudentAdapter(Cursor cs) {
        this.cs = cs;
    }

    @Override
    public int getCount() {
        return cs.getCount();
    }

    @Override
    public Object getItem(int i) {
        return cs.moveToPosition(i);
    }

    @Override
    public long getItemId(int i) {
        cs.moveToPosition(i);
        return cs.getInt(0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.student_item, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Student student = (Student) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.name_text)).setText(student.getName());
        ((TextView) viewProduct.findViewById(R.id.id_text)).setText(student.getId());

        final LinearLayout emailDetail = viewProduct.findViewById(R.id.student_detail);
        final Button buttonView = (Button) viewProduct.findViewById(R.id.read_button);
        buttonView.setText(student.getName().substring(0,1));
        int i = (int)(Integer.parseInt(student.getId())%10); // 0,1,2,3,4,5,6,7,8,9

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
