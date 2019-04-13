package com.mygate.mygatetest;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sumit on 13/04/19.
 */


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> data = new ArrayList<>();
    public void setData(List<User> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myview  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup,false);
        return new UserViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {

        User user = data.get(i);
        userViewHolder.usernameTv.setText(user.getUserName());
        userViewHolder.passCodeTv.setText(String.format("# %s", user.getPasscode()));

        File file = new File(Uri.parse(user.getImagePath()).getPath());
        Log.e("path", user.getImagePath());
        Picasso.get()
                .load(file)
                .resize(600, 600)
                .centerCrop()
                .into(userViewHolder.userImageTv);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView usernameTv;
        private TextView passCodeTv;
        private CircleImageView userImageTv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            userImageTv = itemView.findViewById(R.id.user_image_tv);
            usernameTv = itemView.findViewById(R.id.user_name_tv);
            passCodeTv = itemView.findViewById(R.id.user_passcode_tv);

        }
    }
}
