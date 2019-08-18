package com.example.android.forsale.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.forsale.R;
import com.example.android.forsale.databinding.ListItemBinding;
import com.example.android.forsale.models.ItemData;

import java.util.List;

public class ItemsAdapters extends ListAdapter<ItemData, ItemsAdapters.ItemHolder> {

    private static final DiffUtil.ItemCallback<ItemData> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemData>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemData oldItem, @NonNull ItemData newItem) {
            return oldItem.getImageUrl().equals(newItem.getImageUrl());
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemData oldItem, @NonNull ItemData newItem) {
            return oldItem.getArName().equals(newItem.getArName()) &&
                    oldItem.getEnName().equals(newItem.getEnName()) &&
                    oldItem.getImageUrl().equals(newItem.getImageUrl()) &&
                    oldItem.getPrice().equals(newItem.getPrice()) &&
                    oldItem.getAvailability().equals(newItem.getAvailability()) &&
                    oldItem.getWeight().equals(newItem.getWeight());
        }
    };
    private List<ItemData> mItemsList;


    public ItemsAdapters(List<ItemData> itemsList) {
        super(DIFF_CALLBACK);
        this.mItemsList = itemsList;

    }

    @NonNull
    @Override
    public ItemsAdapters.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBinding listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new ItemHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapters.ItemHolder holder, int position) {
        holder.itemBinding.setItemData(mItemsList.get(position));

        // holder.itemBinding.setListItemClicks(listener);

    }

    @Override
    protected ItemData getItem(int position) {
        return mItemsList.get(position);
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        private ListItemBinding itemBinding;

        ItemHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.itemBinding = listItemBinding;
        }

    }

}
