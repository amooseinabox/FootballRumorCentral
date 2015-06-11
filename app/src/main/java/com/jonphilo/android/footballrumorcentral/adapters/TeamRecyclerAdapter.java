package com.jonphilo.android.footballrumorcentral.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonphilo.android.footballrumorcentral.R;
import com.jonphilo.android.footballrumorcentral.models.TeamModel;

import java.util.List;

/**
 * Created by jonathanphilo on 6/10/15.
 */
public class TeamRecyclerAdapter extends RecyclerView.Adapter<TeamRecyclerAdapter.TeamsViewHolder> {
    List<TeamModel> teamsModels;
    Context context;
    OnItemClickListener clickListener;

    public TeamRecyclerAdapter(Context context) {
        this.context = context;
    }

    public TeamRecyclerAdapter(Context context, List<TeamModel> teamsModels) {
        this.context = context;
        this.teamsModels = teamsModels;
    }

    @Override
    public TeamsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerlist_item, viewGroup, false);
        TeamsViewHolder viewHolder = new TeamsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeamsViewHolder versionViewHolder, int i) {
            versionViewHolder.title.setText(teamsModels.get(i).GetTeamName());
            versionViewHolder.subTitle.setText(teamsModels.get(i).GetTeamLocation());
            versionViewHolder.image.setImageDrawable(context.getDrawable(teamsModels.get(i).GetPictureID()));
    }

    @Override
    public int getItemCount() {
        return teamsModels == null ? 0 : teamsModels.size();
    }


    public class TeamsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardItemLayout;
        TextView title;
        TextView subTitle;
        ImageView image;

        public TeamsViewHolder(View itemView)
        {
            super(itemView);

            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.listitem_name);
            subTitle = (TextView) itemView.findViewById(R.id.listitem_subname);
            image = (ImageView) itemView.findViewById(R.id.list_item_pic);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            //clickListener.onItemClick(v, getAdapterPosition());
        }

    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
