package com.example.android.forsale.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.forsale.models.CategoryData;
import com.example.android.forsale.models.ItemData;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import javax.annotation.Nullable;

public class ItemsLiveData extends LiveData<List<CategoryData>> implements EventListener<QuerySnapshot> {

    private final Query query;
    private ListenerRegistration listenerRegistration = null;
    private MutableLiveData<List<ItemData>> mListOfDocument;

    public ItemsLiveData(String collectionName) {
        this.mListOfDocument = new MutableLiveData<>();
        query = FirebaseFirestore.getInstance().collection(collectionName).whereEqualTo("Availability", true);
    }

    @Override
    protected void onActive() {
        if (listenerRegistration == null) {
            listenerRegistration = query.addSnapshotListener(this);
        }
    }

    @Override
    protected void onInactive() {
        listenerRegistration.remove();
    }

    @Override
    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
        if (queryDocumentSnapshots != null && e == null) {
            mListOfDocument.postValue(queryDocumentSnapshots.toObjects(ItemData.class));
        } else {
            // handle errors

        }
    }

    public LiveData<List<ItemData>> getListOfDocument() {
        return mListOfDocument;
    }
}
