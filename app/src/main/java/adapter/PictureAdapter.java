package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cnpay.animationdemo.R;

import java.util.List;

import bean.Picture;

/**
 * 包   名:     adapter
 * 版权所有:     版权所有(C)2010-2016
 * 版   本:          V1.0
 * 时   间:     2016/8/16 0016 17:11
 * 作   者:     zenghonghua
 */
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.MyHolder> {

    private Context mContext;
    private List<Picture> mDatas;

    public PictureAdapter(Context context,List<Picture> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pictue,parent,false);
        return new MyHolder(view,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Picture picture = mDatas.get(position);

        String url = picture.getUrl();
        Glide.with(mContext)
                .load(url)
                .into(holder.iv_picture);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView iv_picture;
        private ItemClickListener mItemClickListener;

        public MyHolder(View itemView,ItemClickListener itemClickListener) {
            super(itemView);
            this.mItemClickListener = itemClickListener;
            iv_picture = (ImageView) itemView.findViewById(R.id.item_picture);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.itemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    private ItemClickListener mItemClickListener;
    
    public interface ItemClickListener {
        void itemClick(View view, int position);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }
}
