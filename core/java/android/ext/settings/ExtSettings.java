package android.ext.settings;

import android.annotation.BoolRes;
import android.annotation.IntegerRes;
import android.annotation.StringRes;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;

import com.android.internal.R;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/**
 * Note that android.provider.Settings setting names should be defined in the corresponding classes,
 * since the readability of settings is determined by using Java reflection on members of that class.
 *
 * @see android.provider.Settings#getPublicSettingsForClass
 * @hide
 */
public class ExtSettings {

    public static final BoolSetting AUTO_GRANT_OTHER_SENSORS_PERMISSION = new BoolSetting(
            Setting.Scope.PER_USER, Settings.Secure.AUTO_GRANT_OTHER_SENSORS_PERMISSION, true);

    public static final IntSetting AUTO_REBOOT_TIMEOUT = new IntSetting(
            Setting.Scope.GLOBAL, Settings.Global.AUTO_REBOOT_TIMEOUT,
            // default value: 0
            (int) TimeUnit.HOURS.toMillis(0));

    public static final BoolSetting SCREENSHOT_TIMESTAMP_EXIF = new BoolSetting(
            Setting.Scope.PER_USER, Settings.Secure.SCREENSHOT_TIMESTAMP_EXIF, false);


    private ExtSettings() {}

    public static Function<Context, Boolean> defaultBool(@BoolRes int res) {
        return ctx -> ctx.getResources().getBoolean(res);
    }

    public static ToIntFunction<Context> defaultInt(@IntegerRes int res) {
        return ctx -> ctx.getResources().getInteger(res);
    }

    public static Function<Context, String> defaultString(@StringRes int res) {
        return ctx -> ctx.getString(res);
    }
}
