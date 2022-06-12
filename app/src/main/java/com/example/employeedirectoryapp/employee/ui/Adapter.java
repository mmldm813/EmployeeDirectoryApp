package com.example.employeedirectoryapp.employee.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedirectoryapp.employee.domain.model.Employee;
import com.example.employeedirectoryapp.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Employee> dataList;
    private Context context;

    public Adapter(Context context, List<Employee> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.employeeName.setText(dataList.get(position).getEmployeeName());
        holder.teamName.setText(dataList.get(position).getEmployeeTeam());
        holder.phoneNumber.setText(dataList.get(position).getPhoneNumber());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getSmallPicUrl())
                .placeholder(R.drawable.mood_foreground)
                .error(R.drawable.mood_foreground)
                .into(holder.employeePhoto);
    }

    @Override
    public int getItemCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        ImageView employeePhoto;
        TextView employeeName;
        TextView phoneNumber;
        TextView teamName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            employeeName = view.findViewById(R.id.employee_name);
            employeePhoto = view.findViewById(R.id.employee_photo);
            phoneNumber = view.findViewById(R.id.phone_number);
            teamName = view.findViewById(R.id.team_name);
        }
    }
}
