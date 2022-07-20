package ua.redTeam.peopleForPeople.utils.timeTextUtils.remainingTime;

/**
 * Created by Roman Fedchenko
 * date 18.06.2020
 * author email pomeo77777@gmail.com
 */
public class UARemainingTimeCreatorimpl implements LocaleRemainingTimeCreator {

    @Override
    public String seconds(int seconds){
        switch (seconds){

            case 1: case 21: case 31: case 41: case 51:
                return "секунди";

            default: return "секунд";
        }
    }

    @Override
    public String minutes(int minutes){
        switch (minutes){

            case 1: case 21: case 31: case 41: case 51:
                return "хвилини";

            default: return "хвилин";
        }
    }

    @Override
    public String hours(int hours){
        switch (hours){

            case 1: case 21:
                return "години";

            default: return "годин";
        }
    }

    @Override
    public String days(int days){
        switch (days){

            case 1: case 21: case 31:
                return "дня";

            default: return "днів";
        }
    }

    @Override
    public String months(int months){
        if (months == 1) {
            return "місяця";
        }
        return "місяців";
    }

    @Override
    public String years(int years){
        switch (years){

            case 1: case 21: case 31: case 41: case 51:
                return "рік";

            default: return "років";
        }
    }
}
