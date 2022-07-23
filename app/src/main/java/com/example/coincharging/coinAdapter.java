package com.example.coincharging;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.type.DateTime;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class coinAdapter extends FirebaseRecyclerAdapter<Coin,coinAdapter.CoinsViewholder> {

    Long epochh;
    protected static String epochx,date, coinx;
    public coinAdapter(
            @NonNull FirebaseRecyclerOptions<Coin> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "Coin.xml") iwth data in
    // model class(here "Coin.class")
    @Override
    protected void
    onBindViewHolder(@NonNull CoinsViewholder holder,
                     int position, @NonNull Coin model)
    {
        epochh = model.getEpoch();
        date = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date (epochh*1000));
        epochx = Long.toString(model.getEpoch());
        coinx = Integer.toString(model.getCoin());

        // Add firstname from model class (here
        // "Coin.class")to appropriate view in Card
        // view (here "Coin.xml")
        holder.epoch.setText(date);

        // Add lastname from model class (here
        // "Coin.class")to appropriate view in Card
        // view (here "Coin.xml")
        holder.coin.setText(coinx);

    }

    // Function to tell the class about the Card view (here
    // "Coin.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public CoinsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new coinAdapter.CoinsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "Coin.xml")
    class CoinsViewholder
            extends RecyclerView.ViewHolder {
        TextView epoch, coin;
        public CoinsViewholder(@NonNull View itemView)
        {
            super(itemView);

            epoch = itemView.findViewById(R.id.epoch_tv);
            coin = itemView.findViewById(R.id.coin_tv);
        }
    }


}
