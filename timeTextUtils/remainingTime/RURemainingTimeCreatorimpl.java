package ua.redTeam.peopleForPeople.utils.timeTextUtils.remainingTime;

/**
 * Created by Roman Fedchenko
 * date 18.06.2020
 * author email pomeo77777@gmail.com
 */
public class RURemainingTimeCreatorimpl implements LocaleRemainingTimeCreator {

    @Override
    public String seconds(int seconds){
        switch (seconds){

            case 1: case 21: case 31: case 41: case 51:
                return "секунды";

            default: return "секунд";
        }
    }

    @Override
    public String minutes(int minutes){
        switch (minutes){

            case 1: case 21: case 31: case 41: case 51:
                return "минуты";

            default: return "минут";
        }
    }

    @Override
    public String hours(int hours){
        switch (hours){

            case 1: case 21:
                return "часа";

            default: return "часов";
        }
    }

    @Override
    public String days(int days){
        switch (days){

            case 1: case 21: case 31:
                return "дня";

            default: return "дней";
        }
    }

    @Override
    public String months(int months){
        if (months == 1) {
            return "месяця";
        }
        return "месяцев";
    }

    @Override
    public String years(int years){
        switch (years){

            case 1: case 21: case 31: case 41: case 51:
                return "года";

            default: return "лет";
        }
    }
}
