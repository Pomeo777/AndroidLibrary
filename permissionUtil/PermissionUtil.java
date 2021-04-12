package ua.redTeam.peopleForPeople.utils.permissionUtil;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * Created by Roman Fedchenko
 * date 14.05.2020
 * author email pomeo77777@gmail.com
 */
public class PermissionUtil {

    public boolean showPermissionDialog( final String permission, int myPermissionCode, Activity activity ){
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[] { permission}, myPermissionCode);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean showFragmentPermissionDialog(final String permission, int myPermissionCode, Activity activity, Fragment fragment){
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                fragment.requestPermissions(new String[] { permission}, myPermissionCode);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}
