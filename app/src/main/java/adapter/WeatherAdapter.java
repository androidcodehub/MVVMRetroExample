package adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.androidcodehub.myapplication.R;
import com.androidcodehub.myapplication.databinding.ListItemBinding;

import java.util.List;

import model.Day;
import viewmodel.ItemDayViewModel;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Day> days;

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item, parent, false);
        return new WeatherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        ListItemBinding binding = holder.binding;
        binding.setItem(new ItemDayViewModel(days.get(position)));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;

        public WeatherViewHolder(ListItemBinding binding) {
            super(binding.weatherLayout);
            this.binding = binding;
        }
    }

    public WeatherAdapter(List<Day> days) {
        this.days = days;
    }
}