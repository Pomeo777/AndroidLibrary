package ua.redTeam.peopleForPeople.utils.timeTextUtils.remainingTime;

/**
 * Created by Roman Fedchenko
 * date 18.06.2020
 * author email pomeo77777@gmail.com
 */
public interface LocaleRemainingTimeCreator {
    String seconds(int seconds);

    String minutes(int minutes);

    String hours(int hours);

    String days(int days);

    String months(int months);

    String years(int years);
}
