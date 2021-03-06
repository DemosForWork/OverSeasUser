package com.ltt.overseasuser.main.tab.fragment.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ltt.overseasuser.R;
import com.ltt.overseasuser.base.RecyclerAdapter;
import com.ltt.overseasuser.base.Status;
import com.ltt.overseasuser.model.MessageListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */
public class InboxAdapter extends BaseQuickAdapter<MessageListBean.DataBean, BaseViewHolder> {
    private List<MessageListBean.DataBean> mDataLists = new ArrayList<>();
    public InboxAdapter(@LayoutRes int layoutResId, @Nullable List<MessageListBean.DataBean> mMessageLists) {
        super(layoutResId, mMessageLists);
        this.mDataLists = mMessageLists;
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageListBean.DataBean dataBeen) {
        helper.setText(R.id.tv_nickname, dataBeen.getCurrent_user().getName());
        helper.setText(R.id.tv_request_category, dataBeen.getRequest_category());
        helper.setText(R.id.tv_conversation, dataBeen.getConversation_id());
        helper.setText(R.id.tv_date_created, dataBeen.getDate_created());
        helper.setText(R.id.tv_supplier, dataBeen.getOpposite_user().getName());
    }


//    private List<MessageListBean.DataBean> mDataLists = new ArrayList<>();
//
//    public InboxAdapter(List<MessageListBean.DataBean> messageLists) {
//        this.mDataLists = messageLists;
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
//        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_inbox, parent, false));
//    }
//
//    @Override
//    public int getContentItemCount() {
//        return mDataLists.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof Holder) {
//            ((Holder) holder).mTv_nickname.setText(mDataLists.get(position).getCurrent_user().getName());
//            ((Holder) holder).mTv_request_category.setText(mDataLists.get(position).getRequest_category());
//            ((Holder) holder).mTv_conversation.setText(mDataLists.get(position).getConversation_id());
//            ((Holder) holder).mTv_date_created.setText(mDataLists.get(position).getDate_created());
//            ((Holder) holder).tv_supplier.setText(mDataLists.get(position).getOpposite_user().getName());
//
//        }
//    }
//
//    public class Holder extends RecyclerHolder {
//        ImageView mIv_logo;
//        TextView mTv_nickname;
//        TextView mTv_request_category;
//        TextView mTv_conversation;
//        TextView mTv_date_created;
//        TextView tv_supplier;
//
//        public Holder(View itemView) {
//            super(itemView);
//            mIv_logo = (ImageView) itemView.findViewById(R.id.iv_logo);
//            mTv_nickname = (TextView) itemView.findViewById(R.id.tv_nickname);
//            mTv_request_category = (TextView) itemView.findViewById(R.id.tv_request_category);
//            mTv_conversation = (TextView) itemView.findViewById(R.id.tv_conversation);
//            mTv_date_created = (TextView) itemView.findViewById(R.id.tv_date_created);
//            tv_supplier = (TextView) itemView.findViewById(R.id.tv_supplier);
//        }
//    }
}
