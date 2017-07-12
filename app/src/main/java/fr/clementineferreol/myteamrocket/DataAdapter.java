package fr.clementineferreol.myteamrocket;

/**
 * Created by clementineferreol on 20/06/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Filterable;
import android.widget.Filter;


import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {

    private ArrayList<Pokemon> mArrayList;
    private ArrayList<Pokemon> mFilteredList;


    public DataAdapter(ArrayList<Pokemon> arrayList) {

        mArrayList = arrayList;
        mFilteredList = arrayList;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.tv_name.setText(mFilteredList.get(i).getName());
        viewHolder.tv_version.setText(mFilteredList.get(i).getName());
        viewHolder.tv_api_level.setText(mFilteredList.get(i).getType());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("Pokemon", mFilteredList.get(i));
                intent.putParcelableArrayListExtra("Pokemon_List", mFilteredList);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<Pokemon> filteredList = new ArrayList<>();

                    for (Pokemon marraylist : mArrayList) {

                        if (marraylist.getName().toLowerCase().contains(charString) ||  marraylist.getType().toLowerCase().contains(charString)) {

                            filteredList.add(marraylist);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Pokemon>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;

        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }

}
