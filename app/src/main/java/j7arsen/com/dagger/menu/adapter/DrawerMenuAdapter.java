package j7arsen.com.dagger.menu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import j7arsen.com.dagger.R;
import j7arsen.com.dagger.data.MenuData;

/**
 * Created by arsen on 14.10.16.
 */

public class DrawerMenuAdapter extends RecyclerView.Adapter<DrawerMenuAdapter.ViewHolder> {

    OnItemClickListener mItemClickListener;

    private ArrayList<MenuData> mMenuList = new ArrayList<>();


    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, MenuData menuData);
    }

    public DrawerMenuAdapter() {
      //  mMenuList = DataManager.getInstance().getMenuList();
    }

    public void setData(ArrayList<MenuData> menuList){
        this.mMenuList = menuList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_drawer_menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuData data = mMenuList.get(position);
        holder.tvName.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return mMenuList == null ? 0 : mMenuList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_row_drawer_menu_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, mMenuList.get(getAdapterPosition()));
            }
        }
    }

}
