package com.example.android.forsale.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.forsale.models.ItemData;
import com.example.android.forsale.repositories.ItemRepository;

import java.util.List;

public class ItemViewModel extends ViewModel {
    private ItemRepository itemRepository;
    private MutableLiveData<List<ItemData>> _mutableLiveData = new MutableLiveData<>();
    private LiveData<List<ItemData>> mutableLiveData = _mutableLiveData;


    public LiveData<List<ItemData>> getCategoryData(String categoryName) {
        if (itemRepository == null) {
            itemRepository = new ItemRepository(categoryName);
        }

        _mutableLiveData.postValue(itemRepository.getItemData().getValue());
        return mutableLiveData;
    }
}
