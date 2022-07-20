package ua.redTeam.peopleForPeople.utils.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractList;

/**
 * Created by Roman Fedchenko
 * date 18.05.2020
 * author email pomeo77777@gmail.com
 */
public class RecyclerBindingAdapter <T>
        extends RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder> {
    private int holderLayout, variableId;
    private AbstractList<T> items;
    private OnItemClickListener<T> onItemClickListener;
    public RecyclerBindingAdapter(int holderLayout, int variableId, AbstractList<T> items) {
        this.holderLayout = holderLayout;
        this.variableId = variableId;
        this.items = items;
    }
    @Override
    public RecyclerBindingAdapter.@NotNull BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(holderLayout, parent, false);
        return new BindingHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerBindingAdapter.BindingHolder holder, int position) {
        final T item = items.get(position);
//        holder.getBinding().getRoot().setOnClickListener(v -> {
//            if (onItemClickListener != null)
//                onItemClickListener.onItemClick(position, item);
//        });
        holder.getBinding().setVariable(variableId, item);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener<T> {
        void onItemClick(int position, T item);
    }
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
