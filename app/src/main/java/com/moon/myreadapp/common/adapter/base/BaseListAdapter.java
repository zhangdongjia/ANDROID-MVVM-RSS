package com.moon.myreadapp.common.adapter.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.moon.myreadapp.util.Globals;

import java.util.List;

/**
 * Created by moon on 15/10/19.
 *
 */
public abstract class BaseListAdapter<E> extends BaseAdapter {


    private List<E> mData;
    protected LayoutInflater mInflater;

    public BaseListAdapter(List<E> data) {
        mInflater = LayoutInflater.from(Globals.getApplication());
        mData = data;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public E getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getClass().hashCode();
    }

    public List<E> getmData() {
        return mData;
    }

    public void setmData(List<E> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void add(E e) {
        this.mData.add(e);
        notifyDataSetChanged();
    }

    public void addAll(List<E> list) {
        this.mData.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        this.mData.remove(position);
        notifyDataSetChanged();
    }
    public abstract View getView(int position, View convertView, ViewGroup parent);

}