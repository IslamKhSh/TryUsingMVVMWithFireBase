package com.example.android.forsale.repositories;

import androidx.lifecycle.LiveData;

import com.example.android.forsale.livedata.ItemsLiveData;
import com.example.android.forsale.models.ItemData;

import java.util.List;

public class ItemRepository implements ItemDataInterface {

    private ItemsLiveData itemsLiveData;
    private String categoryName;

    public ItemRepository(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public LiveData<List<ItemData>> getItemData() {
        itemsLiveData = new ItemsLiveData(categoryName);
        return itemsLiveData.getListOfDocument();
    }
}

interface ItemDataInterface {
    public LiveData<List<ItemData>> getItemData();

}

