package com.example.priyanka.qrbarcodescanner;

import android.animation.ValueAnimator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TIBIWORLD on 21.01.2018.
 */

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder> {

    List<Product> productList;

    ProductViewAdapter(List<Product> products) {
        this.productList = products;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_view_adapter, viewGroup, false);

        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int i) {
        productViewHolder.productName.setText(productList.get(i).getName());
        productViewHolder.productTip.setText(productList.get(i).getTip());
        productViewHolder.productValEnerg.setText(productList.get(i).getValEnerget());
        productViewHolder.productGrasimi.setText(productList.get(i).getGrasimi());
        productViewHolder.productGlucide.setText(productList.get(i).getGlucide());
        productViewHolder.productProteine.setText(productList.get(i).getProteine());
        productViewHolder.productSare.setText(productList.get(i).getSare());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        private CardView mCardView;
        private int minHeight = 0;
        private final int height = 500;
        TextView productName;
        TextView productTip;
        TextView productValEnerg;
        TextView productGrasimi;
        TextView productGlucide;
        TextView productProteine;
        TextView productSare;
        private RelativeLayout parent;

        ProductViewHolder(View itemView) {
            super(itemView);

            productName = (TextView)itemView.findViewById(R.id.productName);
            productTip = (TextView)itemView.findViewById(R.id.productTip);
            productValEnerg = (TextView)itemView.findViewById(R.id.productValEnerg);
            productGrasimi = (TextView)itemView.findViewById(R.id.productGrasimi);
            productGlucide = (TextView)itemView.findViewById(R.id.productGlucide);
            productProteine = (TextView)itemView.findViewById(R.id.productProteine);
            productSare = (TextView)itemView.findViewById(R.id.productSare);
            parent = (RelativeLayout)itemView.findViewById(R.id.card_view_parent);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);
        }



    }
}
