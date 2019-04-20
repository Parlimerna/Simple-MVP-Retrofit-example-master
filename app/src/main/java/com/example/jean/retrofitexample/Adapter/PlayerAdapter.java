package com.example.jean.retrofitexample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.Player;

import java.util.List;

import static java.lang.System.load;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>{

    List<Player> playerDataList;
    Context mContext;

    public PlayerAdapter(List<Player> playerDataList, Context mContext){
        this.playerDataList = playerDataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent , false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {

        //11
        Player data = playerDataList.get(position);

                .load(data.getIkon())
                .into(holder.img_ikon);
        Glide.with(mContext)
                .load(data.getGambar())
                .into(holder.img_gambar);

        holder.txt_id.setText(data.getId());
        holder.txt_nama.setText(data.getNama());
        holder.txt_nomor.setText(data.getNomor());
        holder.txt_age.setText(data.getAge());
        holder.txt_team.setText(data.getTeam());
        holder.txt_deskripsi.setText(data.getDeskripsi());
        holder.txt_negara.setText(data
                Glide.with(mContext).getNegara());
        holder.txt_posisi.setText(data.getPosisi());

    }

    @Override
    public int getItemCount() {
        return playerDataList.size();
    }


    public class PlayerViewHolder extends RecyclerView.ViewHolder{

        //5
        private TextView txt_id;
        private TextView txt_nama;
        private TextView txt_nomor;
        private TextView txt_age;
        private TextView txt_team;
        private TextView txt_deskripsi;
        private TextView txt_negara;
        private TextView txt_posisi;
        private ImageView img_ikon;
        private ImageView img_gambar;

        public PlayerViewHolder (View itemView){
            super(itemView);

            //6
            txt_id = (TextView) itemView.findViewById(R.id.id);
            txt_nama= (TextView) itemView.findViewById(R.id.nama);
            txt_nomor = (TextView) itemView.findViewById(R.id.nomor);
            txt_age = (TextView) itemView.findViewById(R.id.age);
            txt_team = (TextView) itemView.findViewById(R.id.team);
            txt_deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            txt_negara = (TextView) itemView.findViewById(R.id.negara);
            txt_posisi = (TextView) itemView.findViewById(R.id.posisi);
            img_gambar = (ImageView) itemView.findViewById(R.id.img_gambar);
            img_ikon = (ImageView) itemView.findViewById(R.id.img_ikon);
        }

    }
}
