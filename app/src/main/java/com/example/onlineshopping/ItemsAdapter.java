package com.example.onlineshopping;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter <ItemsAdapter.ItemsViewHolder>
{

    List<Items> itemsList;
    Context mContext;
    private OnItemListener onItemListener;

    public ItemsAdapter(List<Items> itemsList, Context context,OnItemListener onItemListener) {
        this.itemsList = itemsList;
        this.mContext = context;
        this.onItemListener=onItemListener;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview,viewGroup,false);
        return new ItemsViewHolder(view,onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {

        final Items items=itemsList.get(i);
        itemsViewHolder.iName.setText(items.getItemName());
        itemsViewHolder.iPrice.setText(items.getItemPrice());
        itemsViewHolder.iImage.setImageResource(items.getItemImage());
        itemsViewHolder.iDesc.setText(items.getItemDesc());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView iName,iPrice,iDesc;
        ImageView iImage;
        OnItemListener onItemListener;

        public ItemsViewHolder(@NonNull View itemView,OnItemListener onItemListener) {
            super(itemView);
            iName=itemView.findViewById(R.id.itemName);
            iPrice=itemView.findViewById(R.id.itemPrice);
            iImage=itemView.findViewById(R.id.itemImage);
            iDesc=itemView.findViewById(R.id.itemDesc);
            this.onItemListener=onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onItemListener.onItemClick(getAdapterPosition());
        }
    }
    public interface  OnItemListener
    {
        void onItemClick(int position);
    }


}
