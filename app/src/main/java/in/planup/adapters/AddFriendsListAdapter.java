package in.planup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import in.planup.R;
import in.planup.models.FriendInvite;

/**
 * @author aritra
 */
public class AddFriendsListAdapter extends ArrayAdapter<FriendInvite> {

    private final LayoutInflater layoutInflater;

    public AddFriendsListAdapter(Context context) {
        super(context, R.layout.friend_invite_listitem);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewCache viewCache;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.friend_invite_listitem, parent, false);
            viewCache = new ViewCache();
            viewCache.nameView = (TextView) convertView.findViewById(R.id.friend_invite_name);
            viewCache.mobileView = (TextView) convertView.findViewById(R.id.friend_invite_mobile);
            convertView.setTag(viewCache);
        } else {
            viewCache = (ViewCache) convertView.getTag();
        }

        FriendInvite friendInvite = getItem(position);

        viewCache.nameView.setText(friendInvite.getName());
        viewCache.mobileView.setText(friendInvite.getMobile());

        return convertView;
    }

    private static class ViewCache {
        public TextView nameView;
        public TextView mobileView;
    }
}
