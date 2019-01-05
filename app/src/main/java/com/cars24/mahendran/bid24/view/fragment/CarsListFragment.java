package com.cars24.mahendran.bid24.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cars24.mahendran.bid24.R;
import com.cars24.mahendran.bid24.model.CarObject;
import com.cars24.mahendran.bid24.view.activity.MainActivity;
import com.cars24.mahendran.bid24.view.adaptor.RealmCarsAdaptor;

import java.util.ArrayList;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

public class CarsListFragment extends Fragment {
    RecyclerView realmRecyclerView;
    RealmCarsAdaptor carsAdaptor;
    ArrayList<String> carImages;
    ArrayList<String> carNames;
    OrderedRealmCollection<CarObject> carObjects;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cars_fragment, container, false);
        realmRecyclerView = view.findViewById(R.id.carsRecyclerView);
        realmRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        carImages = new ArrayList<>();
        carNames = new ArrayList<>();
        carImages.add("https://st.motortrend.com/uploads/sites/10/2015/11/2016-audi-a8-l-42-sedan-angular-front.png");
        carNames.add("Audi-A8 Sedan Black");
        carImages.add("https://imgd.aeplcdn.com/310x174/cw/ec/26916/Audi-Q3-Right-Front-Three-Quarter-92291.jpg");
        carNames.add("Audi-Q3 White");
        carImages.add("https://imgd.aeplcdn.com/1056x594/n/d7rbe5a_1435582.jpg");
        carNames.add("Audi-Q5 Blue");
        carImages.add("https://media.zigcdn.com/media/model/2016/Aug/elantra-right-facing-750x375_320x160.jpg");
        carNames.add("Elantra Dark Blue");
        carImages.add("https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/media/assets/submodel/8645.jpg");
        carNames.add("Jeep Dark Green");
        carImages.add("https://st.motortrend.com/uploads/sites/10/2015/11/2016-audi-a8-l-42-sedan-angular-front.png");
        carNames.add("Audi-A8 Sedan Black");
        carImages.add("https://imgd.aeplcdn.com/310x174/cw/ec/26916/Audi-Q3-Right-Front-Three-Quarter-92291.jpg");
        carNames.add("Audi-Q3 White");
        carImages.add("https://imgd.aeplcdn.com/1056x594/n/d7rbe5a_1435582.jpg");
        carNames.add("Audi-Q5 Blue");
        carImages.add("https://media.zigcdn.com/media/model/2016/Aug/elantra-right-facing-750x375_320x160.jpg");
        carNames.add("Elantra Dark Blue");
        carImages.add("https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/media/assets/submodel/8645.jpg");
        carNames.add("Jeep Dark Green");

        Realm realm = MainActivity.getInstance().getRealmInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for(int i = 0 ; i < carImages.size(); i++){

                    CarObject carObject = new CarObject();
                    carObject.setId(""+ i);
                    carObject.setName(carNames.get(i));
                    carObject.setImageUrl(carImages.get(i));
                    realm.insertOrUpdate(carObject);
                }

            }
        });
        carObjects = realm.where(CarObject.class).findAll();
        carsAdaptor = new RealmCarsAdaptor(getActivity(), carObjects, true, true);
        realmRecyclerView.setAdapter(carsAdaptor);

        return view;
    }
}
