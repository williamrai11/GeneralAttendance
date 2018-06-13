package com.example.william.sxcattendance.AttendancePage.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.william.sxcattendance.AttendancePage.Contract;
import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;
import com.example.william.sxcattendance.R;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.tooltip.Tooltip;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.CustomViewHolder> {

    private LayoutInflater inflater;
    private List<StudentsModel> studentNames;
    private Context context;
    private int numbers = 1;
    private int x;
    private Contract.View.setValues setValues;
    private int currentAbsent;
    private int currentPresent;


    public AttendanceAdapter(Context context,
                             List<StudentsModel> studentNames,
                             Contract.View.setValues setValues,
                             int currentAbsent,
                             int currentPresent){

        inflater = LayoutInflater.from(context);
        this.studentNames = studentNames;
        this.context = context;
        this.setValues = setValues;
        this.currentAbsent = currentAbsent;
        this.currentPresent = currentPresent;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_items,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.setToogle(studentNames.get(position).getFirst_name()+" "+studentNames.get(position).getLast_name());


        holder.toggleButton.setText(String.valueOf(numbers++));

        if (numbers++ == 0){
            int xx = position;
            holder.toggleButton.setTextOn(String.valueOf(++xx));
            holder.toggleButton.setChecked(true);
            Log.d("abcd", "onBindViewHolder: asd");
        }else {
            int xx = position;
            holder.toggleButton.setTextOff(String.valueOf(++xx));
            holder.toggleButton.setChecked(false);
            Log.d("test", "onBindViewHolder: asd");

        }

        holder.showPopUpStudentName(studentNames.get(position).getFirst_name()+" "+studentNames.get(position).getLast_name());
    }

    @Override
    public int getItemCount() {
        return studentNames.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private ToggleButton toggleButton;

        public CustomViewHolder(View itemView) {
            super(itemView);
            toggleButton = itemView.findViewById(R.id.toogle_button);
        }

        public void setToogle(final String name){
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        int x = getLayoutPosition();
                        toggleButton.setTextOn(String.valueOf(++x));
                        toggleButton.setBackground(ContextCompat.getDrawable(context,R.drawable.second_square));
                        currentAbsent++;
                        currentPresent--;

                        setValues.setAbsentAndPresent(currentPresent,currentAbsent);
                    }else {
                        int x = getLayoutPosition();
                        toggleButton.setTextOff(String.valueOf(++x));

                        toggleButton.setBackground(ContextCompat.getDrawable(context,R.drawable.square));

                        currentPresent++;
                        currentAbsent--;

                        setValues.setAbsentAndPresent(currentPresent,currentAbsent);

                    }
                }
            });

        }

        public void showPopUpStudentName(final String name){
            toggleButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Tooltip.make(context,
                            new Tooltip.Builder(101)
                                    .anchor(v, Tooltip.Gravity.BOTTOM)
                                    .closePolicy(new Tooltip.ClosePolicy()
                                            .insidePolicy(true, false)
                                            .outsidePolicy(true, false), 3000)
                                    .activateDelay(800)
                                    .showDelay(100)
                                    .text(name)
                                    .maxWidth(500)
                                    .withArrow(true)
                                    .withOverlay(true)
                                    .typeface(Typeface.DEFAULT)
                                    .floatingAnimation(Tooltip.AnimationBuilder.DEFAULT)
                                    .build()
                    ).show();

                    return true;
                }
            });
        }


    }
}
