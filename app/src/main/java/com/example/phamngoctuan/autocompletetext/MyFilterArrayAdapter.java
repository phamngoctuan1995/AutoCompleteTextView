package com.example.phamngoctuan.autocompletetext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**S
 * Created by phamngoctuan on 09/05/2016.
 */
public class MyFilterArrayAdapter extends ArrayAdapter<String>{
    Context context;
    ArrayList<String> strArr;
    ArrayList<String> suggestions, tempArr;
    Filter filter = null;
    public MyFilterArrayAdapter(Context context, int resource, ArrayList<String> str) {
        super(context, resource, str);
        strArr = str;
        suggestions = new ArrayList<>();
        tempArr = new ArrayList<>(str);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.list_item, parent, false);
//        }
//
//        TextView tv = (TextView)view.findViewById(R.id.tv_listitem);
//        tv.setText(strArr.get(position));
//
//        return view;
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return strArr.size();
    }

    @Override
    public String getItem(int position) {
        return strArr.get(position);
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new MyFilter();
        return filter;
    }

    public class MyFilter extends Filter
    {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return (String)resultValue;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (String str : tempArr) {
                    if (str.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        suggestions.add(str);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            List<String> filterList = (ArrayList<String>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (String str : filterList) {
                    add(str);
                    notifyDataSetChanged();
                }
            }
        }
    }
}
