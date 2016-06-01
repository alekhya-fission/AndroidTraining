package com.fisstion.sample.insertdetailsusingdatabse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alekhya on 1/6/16.
 */
public class StudentData extends BaseAdapter {
    Context ctx;
    private static LayoutInflater inflater=null;
   private ArrayList<Student> studentDetails=new ArrayList<>();
    StudentData(Context context, ArrayList<Student> student){
        this.studentDetails=student;
        this.ctx=context;
        inflater=(LayoutInflater)ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return studentDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        Holder h=new Holder();

        v=inflater.inflate(R.layout.list_item,null);
        h.mTextName=(TextView)v.findViewById(R.id.textName);
       h.mTextPhoneNumber=(TextView)v.findViewById(R.id.textPhoneNumber);
        h.mTextBranch=(TextView)v.findViewById(R.id.textBranch);
        h.mTextName.setText(studentDetails.get(position).getStuName());
        h.mTextPhoneNumber.setText(studentDetails.get(position).getStuPhoneNumber());
        h.mTextBranch.setText(studentDetails.get(position).getStuBranch());
        return v;
    }
    public class Holder{
       TextView mTextName;
        TextView mTextPhoneNumber;
        TextView mTextBranch;
    }
}

