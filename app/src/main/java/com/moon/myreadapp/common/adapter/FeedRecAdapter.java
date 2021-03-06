package com.moon.myreadapp.common.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.moon.appframework.common.log.XLog;
import com.moon.appframework.core.XApplication;
import com.moon.myreadapp.R;
import com.moon.myreadapp.common.adapter.base.BaseRecyclerAdapter;
import com.moon.myreadapp.databinding.LvFeedItemBinding;
import com.moon.myreadapp.mvvm.models.dao.Feed;
import com.moon.myreadapp.util.DBHelper;
import com.moon.myreadapp.util.ScreenUtils;

import java.util.List;

/**
 * Created by moon on 15/11/9.
 */
public class FeedRecAdapter extends BaseRecyclerAdapter<Feed, LvFeedItemBinding> {


    public FeedRecAdapter(Context context, List<Feed> data) {
        super(context,data);
    }

    @Override
    protected int getItemCoreViewType(int truePos) {
        return 1;
    }

    @Override
    protected BindingHolder<LvFeedItemBinding> onCreateCoreViewHolder(ViewGroup parent, int viewType) {
        View convertView = mInflater.inflate(R.layout.lv_feed_item, null);
        LvFeedItemBinding binding = LvFeedItemBinding.bind(convertView);
        convertView.setTag(binding);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        int padding = ScreenUtils.getResources().getDimensionPixelOffset(R.dimen.normal_padding);
//        lp.setMargins(padding, padding, padding, 0);
        convertView.setLayoutParams(lp);
        BindingHolder mHolder = new BindingHolder(convertView);
        return mHolder;
    }

    @Override
    protected void onBindCoreViewHolder(final BindingHolder<LvFeedItemBinding> holder, int truePos) {
        Feed feed = mData.get(truePos);
        long unread = DBHelper.Query.getFeedUnReadByFeedId(feed.getId());
        holder.getBinding().setCount((int)unread);
        holder.getBinding().setFeed(feed);

        holder.getBinding().feedIcon.setDefaultImageResId(R.drawable.image_bg);
        holder.getBinding().feedIcon.setImageUrl(feed.getIcon(),XApplication.getInstance().getImageLoader());
    }


}
