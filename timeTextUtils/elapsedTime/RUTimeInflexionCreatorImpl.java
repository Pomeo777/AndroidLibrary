package ua.redTeam.peopleForPeople.utils.timeTextUtils.elapsedTime;

public class RUTimeInflexionCreatorImpl implements LocaleInflexionCreator{

    @Override
    public String seconds(int seconds){
        switch (seconds){

            case 1: case 21: case 31: case 41: case 51:
                return "секунда";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
            case 32: case 33: case 34:
            case 42: case 43: case 44:
            case 52: case 53: case 54:
                return "секунды";

            default: return "секунд";
        }
    }

    @Override
    public String minutes(int minutes){
        switch (minutes){

            case 1: case 21: case 31: case 41: case 51:
                return "минута";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
            case 32: case 33: case 34:
            case 42: case 43: case 44:
            case 52: case 53: case 54:
                return "минуты";

            default: return "минут";
        }
    }

    @Override
    public String hours(int hours){
        switch (hours){

            case 1: case 21:
                return "час";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
                return "часа";

            default: return "часов";
        }
    }

    @Override
    public String days(int days){
        switch (days){

            case 1: case 21: case 31:
                return "день";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
                return "дня";

            default: return "дней";
        }
    }

    @Override
    public String months(int months){
        switch (months){

            case 1:
                return "месяц";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
                return "месяца";

            default: return "месяцев";
        }
    }

    @Override
    public String years(int years){
        switch (years){

            case 1: case 21: case 31: case 41: case 51:
                return "год";

            case 2: case 3: case 4:
            case 22: case 23: case 24:
            case 32: case 33: case 34:
            case 42: case 43: case 44:
            case 52: case 53: case 54:
                return "года";

            default: return "лет";
        }
    }
}
