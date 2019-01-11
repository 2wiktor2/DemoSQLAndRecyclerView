package com.wiktor.demosqlandrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    //DBHelper helper = new DBHelper();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewID;
        private TextView textViewData;
        private TextView textViewResult;
        private TextView textViewNumber1;
        private TextView textViewNumber2;
        private TextView textViewShop;
        private TextView textViewPrise;
        private TextView textViewNotes;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.tv_id_for_item);
            textViewData = itemView.findViewById(R.id.tv_data_for_item);
            textViewResult = itemView.findViewById(R.id.tv_num3_for_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Toastik", Toast.LENGTH_SHORT).show();
                }
            });
        }

        void bind() {
           // helper = new DBHelper();

        }
    }
}
