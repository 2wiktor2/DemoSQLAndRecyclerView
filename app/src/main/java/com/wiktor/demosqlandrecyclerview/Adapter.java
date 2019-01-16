package com.wiktor.demosqlandrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    private ArrayList <HistoryModel> listOfModels;

    //DBHelper helper = new DBHelper();
    public Adapter(ArrayList <HistoryModel> listOfModels) {
        this.listOfModels = listOfModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(listOfModels.get(i));
    }

    @Override
    public int getItemCount() {
        return listOfModels.size();
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
            textViewNumber1 = itemView.findViewById(R.id.tv_num1_for_item);
            textViewNumber2 = itemView.findViewById(R.id.tv_num2_for_item);
            textViewResult = itemView.findViewById(R.id.tv_num3_for_item);
            textViewShop = itemView.findViewById(R.id.tv_shop_for_item);
            textViewPrise = itemView.findViewById(R.id.tv_prise_for_item);
            textViewNotes = itemView.findViewById(R.id.tv_notes_for_item);

            // нажатие по элементу
/*            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Toastik", Toast.LENGTH_SHORT).show();
                }
            });*/
        }

        public void bind(HistoryModel historyModel) {
            textViewID.setText("" + historyModel.getId());
            textViewData.setText(historyModel.getTime());
            textViewNumber1.setText("" + historyModel.getNumber1());
            textViewNumber2.setText("" + historyModel.getNumber2());
            textViewResult.setText("" + historyModel.getNumber3());
            textViewShop.setText(historyModel.getShop());
            textViewPrise.setText("" + historyModel.getPrise());
            textViewNotes.setText(historyModel.getNotes());
        }


    }
}
