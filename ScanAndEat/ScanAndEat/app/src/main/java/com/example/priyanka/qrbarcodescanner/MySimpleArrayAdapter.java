package com.example.priyanka.qrbarcodescanner;

import android.animation.ValueAnimator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TIBIWORLD on 12.01.2018.
 */
public class MySimpleArrayAdapter extends RecyclerView.Adapter<MySimpleArrayAdapter.ProductViewHolder> {

    List<Product> productList;

    MySimpleArrayAdapter(List<Product> products) {
        this.productList = products;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_adapter, viewGroup, false);

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

    public static class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
        ImageView arrowDown;

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
            arrowDown = (ImageView)itemView.findViewById(R.id.imageView2);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            parent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

                @Override
                public boolean onPreDraw() {
                    parent.getViewTreeObserver().removeOnPreDrawListener(this);
                    minHeight = parent.getHeight();
                    ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
                    layoutParams.height = minHeight;
                    parent.setLayoutParams(layoutParams);

                    return true;
                }
            });
           // mCardView.setOnClickListener(this);
            parent.setOnClickListener(this);
        }


        public void onClick(View v) {
            // do something when the corky is clicked
            toggleCardViewnHeight(height);
        }

        private void toggleCardViewnHeight(int height) {

            if (parent.getHeight() == minHeight) {
                // expand

                expandView(height); //'height' is the height of screen which we have measured already.

            } else {
                // collapse
                collapseView();

            }
        }

        public void expandView(int height) {
            Log.e("", String.valueOf(height));
            ValueAnimator anim = ValueAnimator.ofInt(parent.getMeasuredHeightAndState(),
                    height);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
                    layoutParams.height = val;

                    parent.setLayoutParams(layoutParams);
                }
            });
          arrowDown.setImageResource(R.mipmap.arrowup);
            anim.start();

        }
        public void collapseView() {

            ValueAnimator anim = ValueAnimator.ofInt(parent.getMeasuredHeightAndState(),
                    minHeight);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
                    layoutParams.height = val;
                    parent.setLayoutParams(layoutParams);

                }
            });

            anim.start();
            arrowDown.setImageResource(R.mipmap.arrowdown);
        }


    }
}
