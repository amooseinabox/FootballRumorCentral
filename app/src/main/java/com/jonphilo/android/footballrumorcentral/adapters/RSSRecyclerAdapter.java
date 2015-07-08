package com.jonphilo.android.footballrumorcentral.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jonphilo.android.footballrumorcentral.R;
import com.jonphilo.android.footballrumorcentral.xml.RSSItem;

import java.util.List;

/**
 * Created by jonathanphilo on 7/6/15.
 */
public class RSSRecyclerAdapter extends RecyclerView.Adapter<RSSRecyclerAdapter.RSSViewHolder> {
    List<RSSItem> rssItems;
    Context context;
    OnItemClickListener clickListener;

    public RSSRecyclerAdapter(Context context) {
        this.context = context;
    }

    public RSSRecyclerAdapter(Context context, List<RSSItem> rssItems) {
        this.context = context;
        this.rssItems = rssItems;
    }

    @Override
    public RSSViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerlist_item, viewGroup, false);
        return new RSSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RSSViewHolder rssViewHolder, int i) {
        rssViewHolder.title.setText(rssItems.get(i).getTitle());
        rssViewHolder.subTitle.setText(rssItems.get(i).getPubDate());
//        rssViewHolder.image.setImageDrawable(context.getDrawable(rssItems.get(i).GetPictureID()));
    }

    @Override
    public int getItemCount() {
        return rssItems == null ? 0 : rssItems.size();
    }


    public class RSSViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardItemLayout;
        TextView title;
        TextView subTitle;
//        ImageView image;

        public RSSViewHolder(View itemView)
        {
            super(itemView);

            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.listitem_name);
            subTitle = (TextView) itemView.findViewById(R.id.listitem_subname);
//            image = (ImageView) itemView.findViewById(R.id.list_item_pic);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            clickListener.onItemClick(v, getAdapterPosition());
        }

    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
