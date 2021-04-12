package ua.redTeam.peopleForPeople.utils.permissionUtil;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import timber.log.Timber;

public class PermissionUtil {

    public boolean showPermissionDialog( final String permission, int myPermissionCode, Activity activity ){
        Timber.d("showPermissionDialog(). permission = %s,  code = %s", permission, myPermissionCode);
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
        Timber.d("showPermissionDialog(). permission = %s,  code = %s", permission, myPermissionCode);
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
