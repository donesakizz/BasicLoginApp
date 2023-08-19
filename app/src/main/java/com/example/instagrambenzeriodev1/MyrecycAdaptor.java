package com.example.instagrambenzeriodev1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyrecycAdaptor extends RecyclerView.Adapter<MyrecycAdaptor.Myholder>{

    private ArrayList<Insta> instas;
    //Adaptor 3 tane method oluşturdu.Bu 3 methodun içi dolu olması gerekiyor.
    //Adaptor recyclında override methodların dolu olması istenir .

    public MyrecycAdaptor(ArrayList<Insta> instas) {
        this.instas = instas;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Bir pencere çagıracak yani görüntü oluşturacak.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_item,parent,false);
        return new Myholder(view);
        //Oluşturulan bu pencereyi ve görüntüyü holderda tutmamız gerekiyor.
        // O yüzden returna null değil viewdan gönderir


    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        //Sayfanı içeriğini onBindViewHolderla göndermemiz gerekiyor.Oluşturulan görüntüler buraya atılır.
        holder.txt_yazi.setText(instas.get(position).getYazi());
        holder.img_resim.setImageResource(instas.get(position).getResim());

    }

    @Override
    public int getItemCount() {
        return instas.size();
        //Araçlardan oluşturduğumuz sınıfın burda görülmesini istedik
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView txt_yazi;
        ImageView img_resim;
        //car_item ile ilgili viewleri buraya çektik.


        public Myholder(@NonNull View itemView) {
            super(itemView);
            img_resim=itemView.findViewById(R.id.img_resim);
            txt_yazi=itemView.findViewById(R.id.txt_yazi);

        }

    }
}
